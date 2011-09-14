package ca.mcgill.ece.libtsp.FI;

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

	public static void FIfPreem(double a, Reference<Float> Fmem, ArrayList<Float> x,
			ArrayList<Float> y, int Nout)

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
	
	public static void FIfFiltAP (ArrayList<Float> x, ArrayList<Float> y, int Nout, ArrayList<Float> h, int Ncof)

	{
	  int m;
	  int j;
	  double sum;

	  if (h.get(0) == 0.0F)
	    UThalt ("FIfFiltAP: %s", FIM_NonCausal);

	  /* Loop over output points */
	  List<Float> yp = y.subList(Ncof-1, y.size());
	  for (m = 0; m < Nout; ++m) {
	    sum = x.get(m);
	    for (j = 1; j < Ncof; ++j)
	      sum = sum - h.get(j) * yp.get(m-j);
	    yp.set(m, (float) sum / h.get(0));
	  }

	  return;
	}
}
