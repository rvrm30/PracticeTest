package JavaProgram;

public class Printlastcharofeachword {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String str="My name is Riya Verma"; 
			String words []=str.split(" ");
		
			
			for(int i=0;i<words.length;i++)
			{
				String word=words[i]; //name

				if(!word.isEmpty()) {
					System.out.print(word.charAt(word.length()-1)+" ");
				}
				}
				
								
			}
		

		}
		
		

	


