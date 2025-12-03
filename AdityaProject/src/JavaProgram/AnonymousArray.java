package JavaProgram;

public class AnonymousArray {
	
//	1.Array without any name
//	2.Create and initialize in single line
//	3.It can be single or multi dimensioal array 
//	4.It can be used only once
//	5/It can be ussed as an argument in some method

	public static void main(String[] args) 
	{
		AnonymousArray.AddNum(new int[]{10,20,30});

	}
	static void AddNum(int[]no)
	{
		int total=0;
//		for(int i:no) // for each loop
		for(int i=0;i<no.length;i++) // normal for loop
		{
			total=total+no[i];
		}
		System.out.println("Sum of all no.: " + total);
	}
}
