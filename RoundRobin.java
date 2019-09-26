import java.util.Scanner;

public class RoundRobin 
{

    public static void main(String[] args) 
    {   
        Scanner sc=new Scanner(System.in);
        int count,j,n,time,remain,flag=0,time_quantam=0;
        int wait_time=0,tat=0;
        int at[]=new int[10];
        int bt[]=new int[10];   
        int rt[]=new int[10]; 
        System.out.print("Enter total process: ");
        n=sc.nextInt();
        remain=n;
        for(count=0;count<n;count++)
        {
            System.out.println("ENTER ARRIVAL TIME AND BURST TIME of process "+(count+1));
            at[count]=sc.nextInt();
            bt[count]=sc.nextInt();
            rt[count]=bt[count];
        }
        System.out.print("Enter time quantam: ");
        time_quantam=sc.nextInt();
        System.out.println("process\t\tTAT\t\tWaiting time");
        for(time=0,count=0;remain!=0;)
        {
            if(rt[count]<=time_quantam && rt[count]>0)
            {
                time+=rt[count];
                rt[count]=0;
                flag=1;
            }
            else if(rt[count]>0)
            {
                rt[count]-=time_quantam;
                time+=time_quantam;
            }
            if(rt[count]==0 && flag==1)
            {
                remain--;
                int a,b;
                System.out.println("P["+(count+1)+"]\t\t"+(time-at[count])+"\t\t"+(time-at[count]-bt[count]));
                wait_time+=time-at[count]-bt[count];
                tat+=time-at[count];
                flag=0;
            }
            if(count==n-1)
            {
                count=0;
            }
            else if(at[count+1]<=time)
            {
                count++;
            }
            else
            {
                count=0;
            }
            
        }
        System.out.println("Average Wait_time: "+wait_time*1.0/n);
        System.out.println("Average TAT: "+tat*1.0/n);
    }
}