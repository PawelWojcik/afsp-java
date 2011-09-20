package ca.mcgill.ece.libtsp.FI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ece.audio.misc.Reference;

public class FI {
	public static void FIfWinHamm(ArrayList<Float> win, Integer N, Double a) {
		Integer i, k;
		Double w;

		if (N > 1)
			w = java.lang.Math.PI / (N - 1);
		else
			w = 0.0;

		for (i = 0, k = N - 1; i <= k; ++i, --k) {
			win.set(i,
					(float) ((1.0 - a) + a
							* java.lang.Math.cos(w * (2 * i - (N - 1)))));
			win.set(k, win.get(i));
		}

	}

	public static void FIfPreem(double a, Reference<Float> Fmem,
			ArrayList<Float> x, ArrayList<Float> y, int Nout)

	{
		int i;
		float c, temp, Fm;

		/* Loop over the samples */
		c = (float) a;
		Fm = Fmem.get();
		for (i = 0; i < Nout; ++i) {
			temp = x.get(i);
			y.set(i, temp - c * Fm);
			Fm = temp;
		}

		/* New filter memory value */
		Fmem.set(Fm);
	}

	public static void FIfFiltAP(ArrayList<Float> x, ArrayList<Float> y,
			int Nout, ArrayList<Float> h, int Ncof)

	{
		int m;
		int j;
		double sum;
		// if (h.get(0) == 0.0F)
		// UThalt ("FIfFiltAP: %s", FIM_NonCausal);
		/* Loop over output points */
		List<Float> yp = y.subList(Ncof - 1, y.size());
		for (m = 0; m < Nout; ++m) {
			sum = x.get(m);
			for (j = 1; j < Ncof; ++j)
				sum = sum - h.get(j) * yp.get(m - j);
			yp.set(m, (float) sum / h.get(0));
		}
		return;
	}

	public static void FIfDeem(double a, Reference<Float> Fmem,
			ArrayList<Float> x, ArrayList<Float> y, int Nout) {
		int i;
		float c, temp;

		/* Loop over the samples */
		c = (float) a;
		temp = Fmem.get();
		for (i = 0; i < Nout; ++i) {
			temp = x.get(i) + c * temp;
			y.set(i, temp);
		}

		/* New filter memory value */
		Fmem.set(temp);
	}

	public static void FIfConvol(ArrayList<Float> x, ArrayList<Float> y,
			int Nout, ArrayList<Float> h, int Ncof) {
		int m;
		int j;
		double sum;
		List<Float> xp;

		/* Loop over output points */
		xp = x.subList(Ncof - 1, x.size());
		for (m = 0; m < Nout; ++m) {

			/* Convolution */
			sum = 0.0;
			for (j = 0; j < Ncof; ++j) {
				sum += h.get(j) * xp.get(m - j);
			}
			y.set(m, (float) sum);
		}

		return;
	}

	public static void FIdWinHamm(ArrayList<Double> win, int N, double a) {
		int i, k;
		double w;

		if (N > 1)
			w = java.lang.Math.PI / (N - 1);
		else
			w = 0.0;

		for (i = 0, k = N - 1; i <= k; ++i, --k) {
			win.set(i,
					(1.0 - a) + a * java.lang.Math.cos(w * (2 * i - (N - 1))));
			win.set(k, win.get(i));
		}

		return;
	}
	
	private static int CHECKSYM(ArrayList<Double> x, int N) {
		//return (int) (1.00001 * VRdCorSym(x,N));
		return 0;
	}

	public static int FIdReadFilt(String Fname, int MaxNcof,
			ArrayList<Double> h, Reference<Integer> Ncof, File fpinfo) {
		String FItab[] = { "!FIR**", /* FIR filter, direct form */
		"!IIR**", /* IIR filter, cascade of biquad sections */
		"!ALL**", /* All-pole filter, direct form */
		"!WIN**", /* Window coefficients, direct form */
		"!CAS**", /* Cascade analog biquad sections */
		null };

		/* String descriptions of the filter types */
		String FItype[] = { FImsg.FI_UNDEF_desc, FImsg.FI_FIR_desc,
				FImsg.FI_IIR_desc, FImsg.FI_ALL_desc, FImsg.FI_WIN_desc,
				FImsg.FI_CAS_desc };
		String COMMENT_CHAR = "!";
		File fp;
		String line;
		int N, FiltType, Sym;
		String FullName;
		

		return 0;
	}
}
