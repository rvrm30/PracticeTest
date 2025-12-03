package JavaProgram;

public class ArrayDecleration 
{
public static void main(String args[])
{
	int[][] a=new int[2][3]; //Decleration and creation of array
	int[][] b={{10,20},{30,40,50},{70,80,90}}; // decleration,Creation and Initiutlization in 1 step
	
	//10 20
	//30 40 50
	//70 80 90
	
	a[0][0]=20;
	a[0][1]=30;
	System.out.println(a[0][1]);
	System.out.println(a.length);
	
}
}
