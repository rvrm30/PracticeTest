package JavaProgram;

public class DuplicateCharInAString 
{
    public static void main(String[] args) 
    {
        String a = "Adityaaa  Vimal".toLowerCase();
        char[] b = a.toCharArray();
        int count = 0;
        for (int i = 0; i < b.length; i++) 
        {
            for (int j = i + 1; j < b.length; j++)
            {
                if (b[i] == b[j] && b[i]!=' ')
                {   
                    System.out.println(b[j]);
                    count++;
                    
                    break; // To avoid counting the same character multiple times
                }
            }
        }
        System.out.print("Duplicate char count: " + count);
    }
}
