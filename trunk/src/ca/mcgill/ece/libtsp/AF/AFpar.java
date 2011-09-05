package ca.mcgill.ece.libtsp.AF;

import ca.mcgill.ece.libtsp.UT.UT;

public class AFpar {
	public static int AF_MAXN_SPKR = 30; /*
										 * Maximum size for speaker position
										 * array
										 */
	public static int AF_SPKR_FL = 1; /* Front left */
	public static int AF_SPKR_FR = 2; /* Front right */
	public static int AF_SPKR_FC = 3; /* Front centre */
	public static int AF_SPKR_LF = 4; /* Low frequency */
	public static int AF_SPKR_BL = 5; /* Back left */
	public static int AF_SPKR_BR = 6; /* Back right */
	public static int AF_SPKR_FLC = 7; /* Front left of centre */
	public static int AF_SPKR_FRC = 8; /* Front right of centre */
	public static int AF_SPKR_BC = 9; /* Back centre */
	public static int AF_SPKR_SL = 10; /* Side left */
	public static int AF_SPKR_SR = 11; /* Side left */
	public static int AF_SPKR_TC = 12; /* Top centre */
	public static int AF_SPKR_TFL = 13; /* Top front left */
	public static int AF_SPKR_TFC = 14; /* Top front centre */
	public static int AF_SPKR_TFR = 15; /* Top front right */
	public static int AF_SPKR_TBL = 16; /* Top back left */
	public static int AF_SPKR_TBC = 17; /* Top back centre */
	public static int AF_SPKR_TBR = 18; /* Top back right */
	public static int AF_SPKR_X = 19; /* No position */
	public static int AF_N_SPKR_NAMES = 19;
	public static int AF_X_SPKR = AF_N_SPKR_NAMES + 1;
	public static String[] AF_Spkr_Names = { "FL", "FR", "FC", "LF", "BL",
			"BR", "FLC", "FRC", "BC", "SL", "SR", "TC", "TFL", "TFC", "TFR",
			"TBL", "TBC", "TBR", "-", null /* Terminating null string */
	};

	public static final String FM_AFSP = "AFsp";

	public static final int AF_MAXINFO = 10240;
	public static final int AF_NOERR = 0;
	public static final int AF_UEOF = -1;
	public static final int AF_IOERR = 1;
	public static final int AF_DECERR = 2;

	public static final int FO_NONE = 0;
	public static final int FO_RO = 1;
	public static final int FO_WO = 2;

	public static final int FD_UNDEF = 0;
	public static final int FD_MULAW8 = 1;
	public static final int FD_ALAW8 = 2;
	public static final int FD_UINT8 = 3;
	public static final int FD_INT8 = 4;
	public static final int FD_INT16 = 5;
	public static final int FD_INT24 = 6;
	public static final int FD_INT32 = 7;
	public static final int FD_FLOAT32 = 8;
	public static final int FD_FLOAT64 = 9;
	public static final int FD_TEXT = 10;

	public static final int NFD = FD_TEXT + 1;

	public static final int FDL_MULAW8 = 1;
	public static final int FDL_ALAW8 = 1;
	public static final int FDL_UINT8 = 1;
	public static final int FDL_INT8 = 1;
	public static final int FDL_INT16 = 2;
	public static final int FDL_INT24 = 3;
	public static final int FDL_INT32 = 4;
	public static final int FDL_FLOAT32 = 4;
	public static final int FDL_FLOAT64 = 8;
	public static final int FDL_TEXT = 0;

	public static final int AF_DL[] = { 0, FDL_MULAW8, FDL_ALAW8, FDL_UINT8,
			FDL_INT8, FDL_INT16, FDL_INT24, FDL_INT32, FDL_FLOAT32,
			FDL_FLOAT64, FDL_TEXT };

	public static final double AF_SF_UNDEF = 1.;
	public static final double AF_SF_MULAW8 = 1. / 32768.;
	public static final double AF_SF_ALAW8 = 1. / 32768.;
	public static final double AF_SF_UINT8 = 128. / 32768.;
	public static final double AF_SF_INT8 = 128. / 32768.;
	public static final double AF_SF_INT16 = 1. / 32768.;
	public static final double AF_SF_INT24 = 1. / 256. * 32768.;
	public static final double AF_SF_INT32 = 1. / 65536. * 32768.;
	public static final double AF_SF_FLOAT32 = 1.;
	public static final double AF_SF_FLOAT64 = 1.;
	public static final double AF_SF_TEXT = 1.;
	public static final double AF_SF_DEFAULT = -Double.MAX_VALUE;

	public static final double AF_SF[] = { AF_SF_UNDEF, AF_SF_MULAW8,
			AF_SF_ALAW8, AF_SF_UINT8, AF_SF_INT8, AF_SF_INT16, AF_SF_INT24,
			AF_SF_INT32, AF_SF_FLOAT32, AF_SF_FLOAT64, AF_SF_TEXT };

	public static final String AF_DTN[] = { "undefined", "8-bit mu-law",
			"8-bit A-law", "offset-binary 8-bit integer", "8-bit integer",
			"16-bit integer", "24-bit integer", "32-bit integer",
			"32-bit float", "64-bit float", "text data" };

	public static final String AF_DTX[] = { null, "%d-bit mu-law",
			"%d-bit A-law", "offset-binary %d-bit integer", "%d-bit integer",
			"%d-bit integer", "%d-bit integer", "%d-bit integer",
			"%d-bit float", "%d-bit float", "text data" };
	public static final String AF_DTXX[] = { null, "%d/%d-bit mu-law",
			"%d/%d-bit A-law", "offset-binary %d/%d-bit integer",
			"%d/%d-bit integer", "%d/%d-bit integer", "%d/%d-bit integer",
			"%d/%d-bit integer", "%d/%d-bit float", "%d/%d-bit float",
			"text data" };

	public static final int FT_UNKNOWN = 0;
	public static final int FT_NH = 1;
	public static final int FT_AU = 2;
	public static final int FT_WAVE = 3;
	public static final int FT_AIFF_C = 4;
	public static final int FT_SPHERE = 5;
	public static final int FT_ESPS = 6;
	public static final int FT_SF = 7;
	public static final int FT_SPPACK = 8;
	public static final int FT_INRS = 9;
	public static final int FT_AIFF = 10;
	public static final int FT_SPW = 11;
	public static final int FT_NSP = 12;
	public static final int FT_TXAUD = 13;

	public static final int NFT = FT_TXAUD + 1;
	public static final int FT_ERROR = -1;
	public static final int FT_AUTO = 255;
	public static final int FT_UNSUP = 256;

	public static final String AF_FTN[] = { null, "Audio file", /*
																 * Headerless or
																 * non-standard
																 * audio file
																 */
	"AU audio file", "WAVE file", "AIFF-C sound file",
			"NIST SPHERE audio file", "ESPS audio file", "IRCAM soundfile",
			"SPPACK file", "INRS-Telecom audio file", "AIFF sound file",
			"Comdisco SPW Signal file", "CSL NSP file", "Text audio file" };

	public static long AF_LDATA_UNDEF = -1L;
	public static long AF_NSAMP_UNDEF = -1L;
	public static long AF_NFRAME_UNDEF = -1L;

	public static final int AF_NOFIX = 0;
	public static final int AF_FIX_NSAMP_HIGH = 1;
	public static final int AF_FIX_NSAMP_LOW = 2;
	public static final int AF_FIX_LDATA_HIGH = 4;

	/* Codes for output audio file types */
	public static final int FTW_UNDEF = 0;
	public static final int FTW_AU = 1;
	public static final int FTW_WAVE = 2;
	public static final int FTW_AIFF_C = 3;
	public static final int FTW_NH_X = 4;
	public static final int FTW_AIFF = 5;

	public static final int FTW_SUBTYPE_MOD = 16;

	public static final int FTW_NH_EB = (FTW_NH_X + UT.DS_EB * FTW_SUBTYPE_MOD);
	public static final int FTW_NH_EL = (FTW_NH_X + UT.DS_EL * FTW_SUBTYPE_MOD);
	public static final int FTW_NH_NATIVE = (FTW_NH_X + UT.DS_NATIVE
			* FTW_SUBTYPE_MOD);
	public static final int FTW_NH_SWAP = (FTW_NH_X + UT.DS_SWAP
			* FTW_SUBTYPE_MOD);

	public static final int FTW_WAVE_NOEX = (FTW_WAVE + 1 * FTW_SUBTYPE_MOD);

	public static final String AF_FTWN[] = { null, "AU audio file",
			"WAVE file", "AIFF-C sound file", "Headerless audio file",
			"AIFF sound file" };

	public static final double AF_SFREQ_DEFAULT = 8000.0;

	public static final int AF_OPT_GENERAL = 1;
	public static final int AF_OPT_INPUT = 2;
	public static final int AF_OPT_OUTPUT = 4;
}
