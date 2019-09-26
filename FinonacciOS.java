import java.util.Scanner;
public class FinonacciOS extends Thread
{
    public void run()
    {
        try{
            int a=0,b=1,c=0;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a limit for series...");
            int n=sc.nextInt();
            System.out.println("Fibonacci series is: ");
            while(n>0)
            {
                System.out.println(c+"");
                a=b;
                b=c;
                c=a+b;
                n=n-1;
                
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try
        {
            FinonacciOS f=new FinonacciOS();
            f.start();
            f.sleep(1000);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}