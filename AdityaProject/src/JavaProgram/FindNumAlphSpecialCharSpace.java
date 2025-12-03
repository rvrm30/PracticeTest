package JavaProgram;

public class FindNumAlphSpecialCharSpace {

		public static void main(String[] args) {
			String str="123abc!@$";
			String alph="";
			String num="";
			String specchar="";
			String space="";

			int a=0,b=0,c=0,d=0;

			for(int i=0;i<str.length();i++)
			{
               if (!Character.isDigit(str.charAt(i))&&!Character.isAlphabetic(str.charAt(i))&&!Character.isSpaceChar(str.charAt(i))){
					
            	   specchar=specchar+str.charAt(i);
					a++;
				}

               else if (Character.isDigit(str.charAt(i))){
					
					num=num+str.charAt(i);
					b++;
				}
				else if (Character.isAlphabetic(str.charAt(i))){
					alph=alph+str.charAt(i);
					c++;
				}
				else if(Character.isSpaceChar(str.charAt(i))) {
					space=space+str.charAt(i);
					d++;
				}
				else{
					specchar=specchar+str.charAt(i);
					d++;
				}
			}
			System.out.println(alph+": "+ "Count of Alphabet :" + a);
			System.out.println(num + " :"+"Countof Number :" + b);
			System.out.println(space +": "+ "Count of Spaces :" + c);
			System.out.println(specchar+": "+ "Countof Special character :" + d);
		}
	}
