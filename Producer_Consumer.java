import java.util.Scanner;

public class Producer_Consumer 
{
    static int mutex=1,full=0,empty=3,x=0;
    
    static public void producer1()
    {
        mutex=wait(mutex);
        full=signal(full);
        empty=wait(empty);
        x++;
        System.out.println("Producer produces the item: "+x);
        mutex=signal(mutex);
    }
    static public void consumer1()
    {
        mutex=wait(mutex);
        full=wait(full);
        empty=signal(empty);
        System.out.println("Consumer consumes: "+x);
        x--;
        mutex=signal(mutex);
    }
    static public int wait(int s)
    {
        return(--s);
    }
    static public int signal(int s)
    {
        return(++s);
    }

    public static void main(String[] args) {
        System.out.println("Thankyou Kunal!!!");
        int n;
        System.out.println("1.Producer\n2.Consumer\n3.exit");
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter your choice: ");
            n=sc.nextInt();
            switch(n)
            {
                case 1: 
                    if((mutex==1)&&(empty!=0))
                        producer1();
                    else
                        System.out.println("Buffer is full!!!");
                        break;
                            
                case 2: 
                    if((mutex==1)&&(full!=0))
                        consumer1();
                    else
                        System.out.println("Buffer is empty!!!");
                        break;
                            
                case 3: 
                    return;
            }
        }
    }
}