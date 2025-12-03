package JavaProgram;

import java.util.Arrays;

public class Anagram {
	
	public static void main(String args[])
	{
		String str1="mary";
		String str2="army";
		
	
		char [] c1=str1.toLowerCase().toCharArray();
		char [] c2=str2.toLowerCase().toCharArray();
		
		Arrays.sort(c1);
	    Arrays.sort(c2);
	    
	    if(Arrays.equals(c1, c2))
	    {
	    	System.out.println("String is Anagram");
	    }
	    else
	    	System.out.println("String is not an Anagram");

	}

}
