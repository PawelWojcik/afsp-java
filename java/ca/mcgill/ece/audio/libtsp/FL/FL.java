package ca.mcgill.ece.audio.libtsp.FL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FL {
	public static String FLgetLine(File fp) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fp));
			return br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
