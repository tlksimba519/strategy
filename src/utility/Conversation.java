package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Console��X/�J�u��
 */
public class Conversation {
	
	public static String input() throws IOException {
		
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
		
	}
	
	public static void output(Object wantToSay) {
		
		System.out.println(wantToSay);
		
	}
	
	public static void output(Object...objs) {
		
		for(Object wantToSay : objs) {
			
			System.out.println(wantToSay);
			
		}
		
	}

}
