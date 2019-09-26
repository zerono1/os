import java.util.*;
class LRU
{
    int[] frame,page,present;
    int size,pages,pf=0,flag=0,flag1=0;
    int n,p;
    double faultRate;
    void get()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter frame size:");
        n=s.nextInt();
        System.out.print("Enter no of pages:");
        p=s.nextInt();
        size=n;
        pages=p;
        frame=new int[n];
        present=new int[n];
        page=new int[p];
        System.out.println("Enter pages");
        for(int i=0;i<pages;i++)
            page[i]=s.nextInt();
        for(int i=0;i<size;i++)
            frame[i]=-1;
    }
    int check(int x)
    {
        flag=-1;
        for(int i=0;i<size;i++)
            if(frame[i]==x)
            {
                flag=i;
                break;
            }
        return flag;
    }
    int replace(int x)
    {
        int i;
        for(i=0;i<size;i++)
            present[i]=0;
        flag1=0;
        for(i=x-1;i>=0;i--)
        {
            if(check(page[i])>=0)
            {
                flag1++;
                present[check(page[i])]=1;
            }
            if(flag1==(size-1)) 
                break;
        }
        for(i=0;i<size;i++)
            if(present[i]==0)
            {
                flag1=i;
                break;
            }
        return i;
    }
    void lru()
    {
        for(int i=0;i<pages;i++)
        {
            if(i<size)
            {
                frame[i]=page[i];
                pf++;
                for(int j=0;j<size;j++)
                    System.out.print(frame[j]+"    ");
                System.out.println();
            }
            else
            {
                if(check(page[i])==-1)
                {
                    int r=replace(i);
                    frame[r]=page[i];
                    pf++;
                    for(int j=0;j<size;j++)
                        System.out.print(frame[j]+"    ");
                    System.out.println();
                }
                else
                {
                    for(int j=0;j<size;j++)
                        System.out.print(frame[j]+"    ");
                    System.out.println();
                }
            }
        }
        faultRate=pf/p;
        System.out.println("PAGE FAULT: "+pf);
        System.out.println("Length of string: "+p);
        
        System.out.println("FAULT RATE: "+faultRate);
    }
    public static void main(String arg[])
    {
        LRU obj=new LRU();
        obj.get();
        obj.lru();
        
    }
}