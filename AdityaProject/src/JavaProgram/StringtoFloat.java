package JavaProgram;

public class StringtoFloat {
	
	
         public static void main(String[] args) {
        
        String []s={"100.50", "-80.00", "20.00", "-10.00"};
        float sum=0;
        for(int i=0;i<s.length;i++)
        { float c=Float.parseFloat(s[i]);
            if(c<0)
            {
               sum=sum+c; 
            }
        }
        System.out.println(sum);
    }

}
