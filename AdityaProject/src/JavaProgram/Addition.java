package JavaProgram;

//EXAMPLE OF OVERIDING
class Addition {
	    public static void main(String[] args) {
	        Addition a = new Addition();
	        a.add(5,2);
	        a.sub(6,4);
	        a.add(3,4,5);
	    }
	    
	  void add(int a,int b)
	  {
	      int sum=0;
	      sum=a+b;
	      System.out.println("Sum ="+sum);
	  }
	  
	  void add (int a, int b, int c)
	  {
	     int sum=0;
	      sum=a+b+c;
	      System.out.println("Sum ="+sum); 
	  }
	  
	  void sub(int a, int b)
	  {
	      int sub=0;
	      sub=a-b;
	      System.out.println("Sub ="+sub);
	  }
	  
	  
	
}
