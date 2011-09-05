package ca.mcgill.ece.libtsp.AF;

import java.io.File;


public class AF_filepar {
	public File fp;		/* File pointer */
	public int Op;		/* Operation (read, write) */
	public int Error;		/* Error flag (0 for no error) */
	public long  Novld;	/* Number of points clipped */
	public double Sfreq;		/* Sampling rate */
	public int Ftype;		/* File type */
	public int Format;		/* Data format, FD_INT16, etc. */
	public int Swapb;		/* Swap code (DS_NATIVE or DS_SWAP) */
	public int NbS;		/* Number of bits per sample */
	public double ScaleF;	/* Scale factor applied to file data */
	public long  Nchan;	/* Number of channels */
	public char SpkrConfig;	/* Speaker configuration mask */
	public long  Start;	/* Start byte */
	public long  Isamp;	/* Sample offset */
	public long  Nsamp;	/* Number of samples */
	public AF_info InfoS;	/* Information structure */
}
