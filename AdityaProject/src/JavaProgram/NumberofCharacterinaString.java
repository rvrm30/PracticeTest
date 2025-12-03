package JavaProgram;

public class NumberofCharacterinaString
{
	public static void main(String [] args)
	{
		String a="Aditya   Vimal";
		int count=0;
	for(int i=0;i<a.length();i++)
	{
			if(a.charAt(i)!=' ')
			{
				count++;
			}			
		}
	System.out.println(count);
	}
	}


