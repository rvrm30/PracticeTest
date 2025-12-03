package JavaProgram;

import java.util.Arrays;

public class AnagramString {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String str1="heart";
		String str2="earth";

		if(areAnagrams(str1,str2))
		{
			System.out.println(str1 + " and " + str2 + " "+ "are anagrams :");
		}
		else
		{
			System.out.println(str1 + " and " + str2 + " " + "are not  anagrams :");
		}			
	}
	public static boolean areAnagrams(String str1,String str2)
	{
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();

		//Check if lengths are same
		if(str1.length()!=str2.length())
		{
			return false;
		}
		//Covert string to char arrays
		char[] charArray1=str1.toCharArray();
		char[] charArray2=str2.toCharArray();

		//Sort the char Array
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		//Check if sorted Arrays are same
		return Arrays.equals(charArray1, charArray2);
	}

}

