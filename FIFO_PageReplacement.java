import java.util.Scanner;

public class FIFO_PageReplacement {

    public static void main(String[] args) 
    {
        Scanner sc =new Scanner(System.in);
        int page_faults=0,m,n,s,pages,frames;
        
        System.out.print("Enter total number of pages: ");
        pages=sc.nextInt();
        int reference_string[]=new int[pages];
        
        System.out.println("Enter values of reference string");
        for(m=0;m<pages;m++)
        {
            reference_string[m]=sc.nextInt();
        }
        System.out.print("Enter total number of frames: ");
        frames=sc.nextInt();
        int temp[]=new int[frames];
        for(m=0;m<frames;m++)
        {
            temp[m]=-1;
        }
        for(m=0;m<pages;m++)
        {
            s=0;
            for(n=0;n<frames;n++)
            {
                if(reference_string[m]==temp[n])
                {
                    s++;
                    page_faults--;
                }
            }
            page_faults++;
            if((page_faults<=frames)&&(s==0))
            {
                temp[m]=reference_string[m];
            }
            else
            {
                temp[(page_faults-1)%frames]=reference_string[m];
            }
            for(n=0;n<frames;n++)
            {
                System.out.print(temp[n]+"\t");
            }
            System.out.println();
        }
        System.out.println("Total page faults: "+page_faults);
        
        
    }
    
}