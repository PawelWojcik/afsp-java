package ca.mcgill.ece.libtsp.ST;

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
			for(kt = 0, j = 0; kt < s.length() && j < str.length(); ++kt) {
				if(s.charAt(kt) == '*') {
					if(state == NOSTAR) {
						state = STAR;
					} else {
						return i;
					}
				} else if(s.charAt(kt) != str.charAt(j)){
					break;
				} else {
					++j;
				}
			}
			if (j == str.length() && (kt == s.length() || state == STAR || s.charAt(kt) == '*'))
				return i;
		}
		return NOMATCH;
	}
}
