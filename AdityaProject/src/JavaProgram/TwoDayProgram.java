package JavaProgram;

public final class TwoDayProgram {

	public static void main(String[] args) {
		//		int[][]a=new int[2][5];
		int[][][]a= {{{20,30,50},{30,40,60},{70,80,90,100}}};
		//		a[0][0]=20;
		//		a[0][1]=30;
		//		a[1][1]=40;
		//		a[2][2]=90;		
		for(int i=0;i<a.length;i++)
		{
			System.out.println("a length:" + a.length);
			for(int j=0;j<a[i].length;j++)
			{
				System.out.println("a[i] length:" + a[i].length);

				for(int k=0;k<a[i][j].length;k++)
					
				{
					System.out.print(a[i][j][k]+ " ");
				}
			}
			System.out.println();
		}
	}
}
