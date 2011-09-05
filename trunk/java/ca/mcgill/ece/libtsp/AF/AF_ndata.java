package ca.mcgill.ece.libtsp.AF;

public class AF_ndata {
	public long Ldata;
	public long Nsamp;
	public long Nchan;
	public char SpkrConfig[];
	public AF_ndata(long ldata, long nsamp, long nchan, char[] spkrConfig) {
		super();
		Ldata = ldata;
		Nsamp = nsamp;
		Nchan = nchan;
		SpkrConfig = spkrConfig;
	}
	
	
}
