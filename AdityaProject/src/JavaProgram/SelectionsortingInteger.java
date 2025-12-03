package JavaProgram;

public class SelectionsortingInteger {

	public static void main(String[] args)
	{
		int[] a= {10,21,3,1,47,89,21,6};
		int temp=0;
		int min;

		for(int i=0;i<a.length;i++)
		{
			min=i; // min=1
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[min]) //j=2 , 
				{
					min=j; //min=2, min=3, min=2
				}
			}
			temp=a[i]; //temp=10,temp=10, temp=21
			a[i]=a[min]; //a[0]=3,a[0]=1 , a[i]=3
			a[min]=temp; //a[2]=10,a[3]=10, a[2]=21
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+ " ");
		}
	}

}

