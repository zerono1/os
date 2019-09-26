import java.util.Scanner;
public class SJF_Algorithm {

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int i,n,min,k=1,btime=0,temp,j,ta=0,sum=0;
        int p[]= new int [] {1,2,3,4,5,6,7,8,9,10};
        int bt[]=new int[10];
        int at[]=new int[10];
        int wt[]=new int[10];
        int tt[]=new int[10];
        float wavg=0,tavg=0,tsum=0,wsum=0;
        System.out.print("Enter number of processes: ");
        n=sc.nextInt();
        System.out.println("Enter burst time of all processes: ");
        for(i=0;i<n;i++)
        {
            bt[i]=sc.nextInt();
        }
        System.out.println("Enter arrival time of all processes: ");
        for(i=0;i<n;i++)
        {
            at[i]=sc.nextInt();
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(at[i]<at[j])
                {
                    temp=p[j];
                    p[j]=p[i];
                    p[i]=temp;
                    temp=at[j];
                    at[j]=at[i];
                    at[i]=temp;
                    temp=bt[j];
                    bt[j]=bt[i];
                    bt[i]=temp;
                }
            }
        }
        
        for(j=0;j<n;j++)
        {
            btime=btime+bt[j];
            min=bt[k];
            for(i=k;i<n;i++)
            {
                if(btime>=at[i] && bt[i]<min)
                {
                    temp=p[k];
                    p[k]=p[i];
                    p[i]=temp;
                    temp=at[k];
                    at[k]=at[i];
                    at[i]=temp;
                    temp=bt[k];
                    bt[k]=bt[i];
                    bt[i]=temp;
                }
            }
            k++;
        }
        wt[0]=0;
        for(i=1;i<n;i++)
        {
            sum=sum+bt[i-1];
            wt[i]=sum-at[i];
            wsum+=wt[i];
        }
        wavg=(wsum/n);
        for(i=0;i<n;i++)
        {
            ta=ta+bt[i];
            tt[i]=ta-at[i];
            tsum=tsum+tt[i];
        }
        tavg=(tsum/n);
        System.out.println("Process\tburst\tarrival\twaiting\tturnaround");
        for(i=0;i<n;i++)
        {
            System.out.println(p[i]+"\t"+bt[i]+"\t"+at[i]+"\t"+wt[i]+"\t"+tt[i]);
        }
        System.out.println("Average Wait time: "+wavg);
        System.out.println("Average turn around time: "+tavg);
        
    }
    
}