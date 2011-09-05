/*-------------- Telecommunications & Signal Processing Lab ---------------
                             McGill University

Routine:
  void SPdPreFFT (double x[], double y[], int N, int Ifn)

Purpose:
  FFT pre/postprocessing for real sequences

Description:
  Forward discrete Fourier transform:
    If Ifn is greater than zero, this routine completes the discrete Fourier
    transform of 2*N real data points.  The input to this routine are the
    real and imaginary vectors from a N/2 point DFT.  These values are assumed
    to have been generated by taking the DFT of a complex sequence formed by
    sifting the odd- and even-numbered coefficients into the real and imaginary
    parts of a complex vector.

    Let the resulting N+1 complex output values corresponding to the first
    half of the frequency response be (ar(0),ai(0)), ... , (ar(N),ai(N).  The
    remaining complex frequency points can be obtained by complex conjugation,
    (ar(i),ai(i)) = (ar(2*N-i),-ai(2*N-i)).  The frequency response samples are
    stored in the arrays x and y as follows.
      ar(0)    <->  x[0]
      ar(1)    <->  x[1]
       ...          ...
      ar(N-1)  <->  x[N-1]
      ar(N)    <->  y[0]
      ai(1)    <->  y[1]
      ai(2)    <->  y[2]
       ...          ...
      ai(N-1)  <->  y[N-1]
    Note that ar(N) is stored in the place that would normally be reserved for
    ai(0).  This is possible since both ai(0) and ai(N) are known a priori to
    be zero.

  Inverse discrete Fourier transform:

    If Ifn is less than zero, this routine prepares the data for evaluating an
    inverse discrete Fourier transform that results in 2*N real data values.
    Let the N+1 complex input values be (ar(0),ai(0)), ... , (ar(N),ai(N)).  If
    these values are to result in a real sequence after the inverse discrete
    Fourier transform, ai(0) and ai(N) must both be zero.  The remaining 2*N
    data values (N+1 real components and N-1 imaginary components) are stored
    in the arrays x and y as follows.
      ar(0)    <->  x[0]
      ar(1)    <->  x[1]
       ...          ...
      ar(N-1)  <->  x[N-1]
      ar(N)    <->  y[0]
      ai(1)    <->  y[1]
      ai(2)    <->  y[2]
       ...          ...
      ai(N-1)  <->  y[N-1]
    Note that ar(N) is stored in the place that would normally be reserved for
    ai(0).  This subroutine is then called to prepare the data for the inverse
    discrete Fourier transform.  The output of the inverse transform contains
    the 2*N desired real data points stored alternately in the arrays x and y.

Parameters:
  <-> double x[]
      N values, the real part of complex data
  <-> double y[]
      N values, the imaginary part of complex data
   -> int N
      The arrays x and y each have N elements
   -> int Ifn
      Parameter specifying the direction of the transform
      Ifn > 0, transform from time to frequency
      Ifn < 0, transform from frequency to time

Author / revision:
  P. Kabal  Copyright (C) 2003
  $Revision: 1.2 $  $Date: 2003/05/09 02:47:19 $

-------------------------------------------------------------------------*/

#include <math.h>

#include <libtsp/nucleus.h>

#define PI	3.14159265358979323846


void
SPdPreFFT (double x[], double y[], int N, int Ifn)

{
  int k, j;
  double cc, ss, tm, c1, s1, ar0, ar1, ai0, ai1, xx, yy;

/* Initialization */
  cc = cos (PI / N);
  ss = sin (PI / N);
  tm = x[0];
  x[0] = tm + y[0];
  y[0] = tm - y[0];

/*
   Set up the sine and cosine values for recursive calculation,
   c1 and s1 represent the real and imaginary parts of exp(-j*k*pi/N)
*/
  if (Ifn > 0) {
    ss = -ss;
    c1 = cc;
    s1 = ss;
  }
  else {
    c1 = -cc;
    s1 = -ss;
    x[0] = 0.5 * x[0];
    y[0] = 0.5 * y[0];
  }

/* Complete the transform or prepare for the inverse transform*/
  for (j = 1, k = N - 1; j <= N / 2; ++j, --k) {
    ar0 = x[j] + x[k];
    ar1 = y[j] + y[k];
    ai0 = y[j] - y[k];
    ai1 = x[j] - x[k];
    xx = c1 * ar1 + s1 * ai1;
    yy = s1 * ar1 - c1 * ai1;
    y[k] = 0.5 * (yy - ai0);
    y[j] = 0.5 * (yy + ai0);
    x[k] = 0.5 * (ar0 - xx);
    x[j] = 0.5 * (ar0 + xx);

/*
   Recursion to get the next sine and cosine values
     cos(a+b) = cos(a)*cos(b)-sin(a)*sin(b)
     sin(a+b) = cos(a)*sin(b)+sin(a)*cos(b)
   where a+b=(k+1)*pi/N, a=k*ii/N and b=ii/N
*/
    tm = c1 * cc - s1 * ss;
    s1 = c1 * ss + s1 * cc;
    c1 = tm;
  }
  return;
}
