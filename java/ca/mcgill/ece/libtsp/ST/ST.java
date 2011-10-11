package ca.mcgill.ece.libtsp.ST;

import ca.mcgill.ece.audio.misc.Reference;

public class ST {
	public static int STKeyMatch(String str, String keyTable[]) {
		int NOSTAR = 0;
		int STAR = 1;
		int NOMATCH	= -1;
		
		int state;
		int kt;
		int j;
		if(str == null) return NOMATCH;
		for(int i = 0; i < keyTable.length; i++) {
			state = NOSTAR;
			String s = keyTable[i];
			boolean flag = false;
			for(kt = 0, j = 0; kt < s.length() && j < str.length(); ++kt) {
				if(s.charAt(kt) == '*') {
					if(state == NOSTAR) {
						state = STAR;
					} else {
						return i;
					}
				} else if(s.charAt(kt) != str.charAt(j)){
					flag = true;
					break;
				} else {
					++j;
				}
			}
			if (j == str.length() && (kt == s.length() || state == STAR || s.charAt(kt) == '*') && flag == false)
				return i;
		}
		return NOMATCH;
	}

	public static int STcatMax(String Si, Reference<String> So, int Maxchar) {
		StringBuilder sb = new StringBuilder(So.get());
		sb.append(Si);
		So.set(sb.substring(0, Maxchar>sb.length()?sb.length():Maxchar));		
		return So.get().length();
	}
	
	public static int STcopyMax(String Si, Reference<String> So, int Maxchar) {
		int size = Maxchar>Si.length()?Si.length():Maxchar;
		So.set(Si.substring(0, size));
		return So.get().length();
	}
	
	public static int STcopyNMax(String Si, Reference<String> So, int N, int Maxchar) {
		int size = N<Si.length()?N:Si.length();
		size = size>Maxchar?Maxchar:size;
		So.set(Si.substring(0, size));
		return So.get().length();
	}
	
	public int STdec1double(String str, Reference<Double> Dval) {
		Dval.set(Double.parseDouble(str));
		return 0;
	}
	
	public int STdec1float(String str, Reference<Float> Fval) {
		Fval.set(Float.parseFloat(str));
		return 0;
	}
	
	public int STdec1int(String str, Reference<Integer> Ival) {
		Ival.set(Integer.parseInt(str));
		return 0;
	}
	
	public int STdec1long(String str, Reference<Long> Lval) {
		Lval.set(Long.parseLong(str));
		return 0;
	}
}
