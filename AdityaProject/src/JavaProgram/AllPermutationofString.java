package JavaProgram;

public class AllPermutationofString {

	public static void main(String[] args) 
	{
		String perm="ABC";
		int l=0;
		int r=perm.length()-1;
		permute(perm,l,r);
	}
	private static void permute(String str,int l,int r)
	{
		if(l==r)
		{
			System.out.println(str);
		}
		else
		{
			for(int i=l;i<=r;i++) 
			{
				str=swap(str,l,i);
				permute(str,l+1,r);
				str=swap(str,l,i);//backtrack

			}
		}

	}
	private static String swap(String a, int i, int j) {
		char temp;
		char[] charArray=a.toCharArray();
		temp=charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=temp;
		return String.valueOf(charArray);
	}

}
