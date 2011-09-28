package ca.mcgill.ece.libtsp.FI;

public class FIpar {
	public static int FI_UNDEF	= 0;	/* undefined filter file identifier */
	public static int FI_FIR	= 1;	/* FIR filter, direct form */
	public static int FI_IIR	= 2;	/* IIR filter, cascade of biquad sections */
	public static int FI_ALL	= 3;	/* All-pole filter, direct form */
	public static int FI_WIN	= 4;	/* Window coefficients, direct form */
	public static int FI_CAS	= 5;	/* Cascade analog biquad sections */
};
