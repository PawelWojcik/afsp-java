package ca.mcgill.ece.libtsp.AF;

import ca.mcgill.ece.libtsp.UT.UT;

public class AF_read {
	public double Sfreq;
	public AF_dformat DFormat;
	public AF_ndata NData;
	public AF_infoX InfoX;
	
	private static AF_read singleton = null;

	private AF_read() {
		this.Sfreq = 0.0;
		this.DFormat = new AF_dformat(AFpar.FD_UNDEF, UT.DS_NATIVE, 0,
				AFpar.AF_SF_DEFAULT);
		char spkrConfig[] = { (char) AFpar.AF_X_SPKR, 0 };
		this.NData = new AF_ndata(AFpar.AF_LDATA_UNDEF, AFpar.AF_NSAMP_UNDEF, 1L,
				spkrConfig);
		this.InfoX = new AF_infoX(null, 0, 0);
	}
	
	public static AF_read AF_READ_DEFAULT() {
		if(singleton == null) {
			singleton = new AF_read();
		}
		return singleton;
	}
}
