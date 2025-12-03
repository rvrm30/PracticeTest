package JavaProgram;

public class BubblesortString {

	public static void main(String[] args) 
	{
		String[] a= {"Verma","Riya","Aditya","Vimal","nha"};
		String temp ="";
			
		for(int i=0;i<a.length;i++) //i=0
		{
			int flag=0;
			for(int j=0;j<a.length-1-i;j++) //j=0
			{
				if( (a[j].toLowerCase().compareTo(a[j + 1].toLowerCase()) > 0)) //comparTO() is a string method that convert each character  into unicode with its same it will 
				{                            //assign 0:value if its greater than it will assign value:1 and if its less then it will asign -1: value  
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0)
				break;
		}	
		//for(int i=0;i<a.length;i++)
		for(String element:a)
		{
			//System.out.print(a[i]+ " ");
			System.out.print(element+ " ");
			
		}
	}

}
