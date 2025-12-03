package JavaProgram;

public class NumAlphSpeclChar {
	public static void main(String[] args) {
		String str="1234abcd!@$";
		String alph="";
		String num="";
		String specchar="";
		String space="";

		int a=0,b=0,c=0,d=0;

		for(int i=0;i<str.length();i++)
		{
			if (Character.isDigit(str.charAt(i))){
				num=num+str.charAt(i);
				a++;
			}
			else if (Character.isAlphabetic(str.charAt(i))){
				alph=alph+str.charAt(i);
				b++;
			}
			else if(Character.isSpaceChar(str.charAt(i))) {
				space=space+str.charAt(i);
				c++;
			}
			else{
				specchar=specchar+str.charAt(i);
				d++;
			}
		}
		System.out.println(alph+" "+ "Count of Number :" + a);
		System.out.println(num + " "+"Countof Alphabet :" + b);
		System.out.println(space +" "+ "Countof Spaces :" + c);
		System.out.println(specchar+" "+ "Countof Special character :" + d);
	}
}