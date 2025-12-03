package JavaProgram;

public class UpperCaseFirstLetterofWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a="aditya vimal";
		String [] b=a.split(" ");
		
		
		for(int i=0;i<b.length;i++)
		{
			b[i]=b[i].substring(0,1).toUpperCase()+b[i].substring(1);
			
		}
		
		a=String.join(" ",b);
		System.out.println(a);
	}

}
