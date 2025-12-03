package JavaProgram;

public class PallindromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="MADAM";
		String b="";
		
		for(int i=a.length()-1;i>=0;i--)
		{
			b=b+a.charAt(i);
		}
		if(a.equalsIgnoreCase(b))
			System.out.println("Pallindrome");
		else
			System.out.println("Not plalindrome");
	}

}
