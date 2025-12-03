package JavaProgram;

import java.util.UUID;

public class CountAlphaNumSpecCharSpace {
	static int countofAlphabet=0;
	static int totalNum=0;
	static  int countofSpaces=0;

	public static void main(String[] args) {

		String a="Aditya 123!@#$%";
		char c[]=a.toCharArray();
		System.out.println(c[5]);
		for(int i=0;i<c.length;i++)
		{
			boolean answer1=Character.isAlphabetic(c[i]);
			boolean answer2=Character.isDigit(c[i]);
			boolean answer3=Character.isSpaceChar(c[i]);

			if(answer1==true)	
			{
				countofAlphabet++;
			}
			if (answer2==true)
			{
				totalNum++;
			}
			if (answer3==true)
			{
				countofSpaces++;
			}		

		}
		System.out.println("Count of  Alphabet" + " "+ countofAlphabet);
		System.out.println("Count of digit :"+  " " + totalNum);
		System.out.println("Count of  spaces" + " "+ countofSpaces);
		int TotalSpecialChar=a.length()-(countofAlphabet+countofSpaces+totalNum);
		System.out.println(TotalSpecialChar);
		
		String guid=UUID.randomUUID().toString();
		System.out.println(guid);


	}


}

