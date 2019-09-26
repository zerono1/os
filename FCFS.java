import java.util.Scanner; 
public class FCFS {
public static void main(String[] args)
{
    double avwt=0.0,avtat=0.0; int i,j,n, BT[], WT[], TAT[];
    BT = new int[20]; WT = new int[20]; TAT = new int[20];
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter number of processes(MAXIMUM 20): "); n=sc.nextInt();
    System.out.println("Enter process burst time: "); for(i=0;i<n;i++)
    {
        System.out.print("P["+(i+1)+"]: "); BT[i]=sc.nextInt();
    }
    WT[0]=0;
    for(i=1;i<n;i++)
    {
        WT[i]=0;
        for(j=0;j<i;j++)
        {
            WT[i]+=BT[j];
        }
    }
    System.out.println("Process\t\tBursttime\t\tWaitingtime\t\tTAT time"); for(i=0;i<n;i++)
    {
        TAT[i]=BT[i]+WT[i];
        avwt+=WT[i]; avtat+=TAT[i];
        System.out.println((i+1) + "\t\t\t" + BT[i] + "\t\t\t" + WT[i] + "\t\t\t" + TAT[i]);
    }
    avwt/=i; 
    avtat/=i;
    System.out.println("Average Wait Time: "+avwt);
 
    System.out.println("Average Turn Around Time: "+avtat);

}

}
