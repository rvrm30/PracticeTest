package JavaProgram;

public class ExceptionHandling 
{
	public static void main(String[] args) throws Exception 
	{
		try {
			int a[] = new int[5];
			// Uncommenting the next line will throw an ArithmeticException
			 
			System.out.println(a[7]); // This will throw ArrayIndexOutOfBoundsException
			//int b = 10 / 0;
		} catch (ArithmeticException e) 
		{
			System.out.println("Arithmetic Exception: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Array Index Out Of Bounds Exception: " + e.getMessage());
		} catch (Exception e) 
		{
			System.out.println("General Exception: " + e.getMessage());
		} finally 
		{
			System.out.println("I am in the finally block");
		}
	}
}
