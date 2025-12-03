package JavaProgram;

public class ReverStringWithoutReversingNumberandSpecialCharacter {

	public static void main(String[] args) {
		String s="Aditya1234Riya567";
		char[] temp=new char[s.length()];
		int c=0;
		int start=0;
		for(int i=0;i<s.length();i++)
		{
			if(!Character.isLetter(s.charAt(i)) && (Character.isLetter(s.charAt(i-1))))
			{
				for(int k=i-1;k>=start;k--)
				{
					temp[c]=s.charAt(k);
					System.out.println(s.charAt(k));
					System.out.println(c);
					c++;
				}
			}
			if(!Character.isLetter(s.charAt(i)))
			{
				temp[c]=s.charAt(i);
				System.out.println(s.charAt(i));
				System.out.println(c);
				c++;
				start=c;
			}
		}
		String finastring=new String(temp);
		System.out.println("Final Output :" + finastring);


	}
}

