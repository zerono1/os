import java.util.*;

public class Prime extends Thread
{
    public void run()
    {
        int n,flag=0,i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter limit: ");
        n=sc.nextInt();
        System.out.println("Prime Numbers are: ");
        
        for(i=0;i<=n;i++)
        {
            for(j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag=0;
                    break;
                }
                else
                {
                    flag=1;
                }
            }
            if(flag==1)
            {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Prime pm=new Prime();
        pm.start();
    }
    
}