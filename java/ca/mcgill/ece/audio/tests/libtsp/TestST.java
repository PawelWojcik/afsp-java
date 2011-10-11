package ca.mcgill.ece.audio.tests.libtsp;

import ca.mcgill.ece.audio.misc.Reference;
import ca.mcgill.ece.libtsp.ST.ST;

public class TestST {
	public static void main(String args[]) {
		testSTcatMax();
		testSTcopyMax();
	}
	
	public static void testSTcatMax() {
		Reference<String> ref = new Reference<String>("123");
		int ret = ST.STcatMax("4567890", ref, 9);
		System.out.println(ret + " " + ref.get());
	}
	
	public static void testSTcopyMax() {
		Reference<String> ref = new Reference<String>("");
		int ret = ST.STcatMax("123456789", ref, 2);
		System.out.println(ret + " " + ref.get());
	}
}
