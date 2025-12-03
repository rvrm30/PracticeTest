package JavaProgram;

public class StringToDouble {

public static void main(String[] args) {
        
        String []s={"100.50", "-80.00", "20.00", "-10.00"};
        double sum=0.0;
        for(int i=0;i<s.length;i++)
        { double c=Double.parseDouble(s[i]);
            if(c<0)
            {
               sum=sum+c; 
            }
        }
        System.out.println(sum);
    }
}
