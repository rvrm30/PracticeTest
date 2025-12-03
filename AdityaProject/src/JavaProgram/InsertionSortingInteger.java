package JavaProgram;

public class InsertionSortingInteger 
{
//Insertion sort work like playing card 
	public static void main(String[] args) 
	{
		int[]a= {5,1,6,2,4,3,-1,10};
		int temp,j;
		for(int i=1;i<a.length;i++)
		{
			temp=a[i];
			j=i; //so that for value of 'i' will not be impacted
			while(j>0 && a[j-1]>temp)
			{
				a[j]=a[j-1]; 
				j=j-1; //value of 'j' will be  exhausted
			}
			a[j]=temp;
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+ " ");
		}
	}

}
