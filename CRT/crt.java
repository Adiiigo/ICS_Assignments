import java.util.Scanner;

public class crt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in) ;
		
		System.out.println("Enter number of equations(x%num=rem)");
		int count = scan.nextInt() ;
		
		int[] num = new int[count] ;
		System.out.println("Enter num values");
		for(int i = 0 ; i <count ; i++)
		{
			num[i] = scan.nextInt() ;
		}
		
		int[] rem = new int[count] ;
		System.out.println("Enter rem values");
		for(int i = 0 ; i <count ; i++)
		{
			rem[i] = scan.nextInt() ;
		}
		
		int M = 1 ;
		for(int i = 0 ; i <count ; i++)
		{
			M = M * num[i];
		}
		
		int[] m = new int[count] ;
		for(int i = 0 ; i <count ; i++)
		{
			m[i] = M / num[i] ;
		}
		
		int[] y = new int[count] ;
		for(int i = 0 ; i < count ; i++)
		{
			if(m[i] > num[i])
			{
				y[i] = m[i] % num[i] ;
			}
			else
			{
				//Use eegcd
			}
		}
				
		int x = 0;
		for(int i = 0 ; i < count ; i++)
		{
			x = x + y[i]*m[i]*rem[i];
		}
		x = x%M ;
		System.out.println("X = " + x);
	}

}
