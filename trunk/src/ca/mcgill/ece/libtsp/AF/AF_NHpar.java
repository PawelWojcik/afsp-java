package ca.mcgill.ece.libtsp.AF;

public class AF_NHpar {
	public int Format;
	public long Start;
	public double Sfreq;
	public int Swapb;
	public long Nchan;
	public double ScaleF;

	public AF_NHpar(int format, long start, double sfreq, int swapb,
			long nchan, double scaleF) {
		super();
		Format = format;
		Start = start;
		Sfreq = sfreq;
		Swapb = swapb;
		Nchan = nchan;
		ScaleF = scaleF;
	}

}
