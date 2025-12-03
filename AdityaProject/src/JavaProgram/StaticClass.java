package JavaProgram;

public class StaticClass 
{
	  int a=0;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		StaticClass sc=new StaticClass();
				sc.add(1, 2);
				sc.sub(4, 5);
	}
	
			
		static void add(int b,int c)
		{
//			this.a=a;
			a=a+10;
			int sum=b+c+a;
			
			System.out.println(sum);
		}
		
		static void sub(int e,int f)
		{
//			this.a=a;
			a=a+20;
			int sub=e+f+a;
			
			System.out.println(sub);
		}

	}

