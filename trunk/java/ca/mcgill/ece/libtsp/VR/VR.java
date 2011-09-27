package ca.mcgill.ece.libtsp.VR;

import java.util.ArrayList;

public class VR {
	public static double VRdCorSym(ArrayList<Double> x, int N) {
		int i, j;
		double Sn, Sd, rho;

		/*
		 * For two vectors x[i] and y[i], the correlation coefficient is SUM
		 * x[i] y[i] rho = --------------------------- . sqrt(SUM x[i]^2 SUM
		 * y[i]^2)
		 * 
		 * The correlation takes on values from -1 to +1. In our case, the
		 * vector y[i] is the reversal of x[i]. The two sums in the denominator
		 * are equal and so the square root can be eliminated.
		 */
		Sn = 0.0;
		Sd = 0.0;
		for (i = 0, j = N - 1; i < j; ++i, --j) {
			Sn += (x.get(i) * x.get(j) + x.get(i) * x.get(j));
			Sd += (x.get(i) * x.get(i) + x.get(j) * x.get(j));
		}
		if (i == j) {
			Sn += x.get(i) * x.get(j);
			Sd += x.get(i) * x.get(j);
		}

		if (Sd != 0.0)
			rho = Sn / Sd;
		else
			rho = 0.0;

		return rho;
	}
}
