import java.util.ArrayList;
import java.util.Scanner;

public class Eegcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in) ;
		
		System.out.println("Extended Euclidean Algorithm");
		
		System.out.println("Enter modulus");
		int mod = scan.nextInt() ;
		
		System.out.println("Enter number");
		int num = scan.nextInt() ;
		
		do
		{
			if(mod > num)
			{
				int mul = eegcd(mod , num) ;
				if (mul == -1)
				{
					System.out.println("The multiplicative inverse of "+ num +" doesn't exist in " + mod ) ;
				}
				else
				{
					System.out.println("The multiplicative inverse of "+ num +" in mod "+mod+" is "+mul) ;
				}
					
			}
			else
			{
				System.out.println("Enter again , mod <= num");
			}
		}while(mod <= num) ;
		
		scan.close() ;
	}

	
	public static int coprime(int fmod , int fnum)
	{
		int result = -1 ;
		ArrayList<Integer> primeMod = new ArrayList<Integer>() ;
		
		for(int i = 2 ; i <= fmod ; i++)
		{
			while(fmod%i == 0)
			{
				primeMod.add(i) ;
				fmod/=i;
			}
		}
		System.out.println(primeMod);
		
		ArrayList<Integer> primeNum = new ArrayList<Integer>() ;
		
		for(int i = 2 ; i <= fnum ; i++)
		{
			while(fnum%i == 0)
			{
				primeNum.add(i) ;
				fnum/=i;
			}
		}
		System.out.println(primeNum);
		
		primeMod.retainAll(primeNum) ;
		
		System.out.println(primeMod);
		if(primeMod.size() == 0)
		{
			result = 0 ;
		}
		else
		{
			result = 1 ;
		}
		return result ;
	}
	
	public static int eegcd(int fmod , int fnum)
	{
		int result = 0 ;
		
		int q = 0 ;
		int n1 = fmod ;
		int n2 = fnum ;
		int r = 0 ;
		
		int t0 = 0 ;
		int t1 = 1 ;
		int t2 = 0 ;
		
		while(n2 != 0)
		{
			q = n1/n2 ;
			r = n1%n2 ;
			t2 = t0-q*t1 ;
			
			n1 = n2 ;
			n2 = r ;
			t0 = t1 ;
			t1 = t2 ;
		}
		
		if(n1 != 1)
		{
			result = -1 ;
		}
		else
		{
			if(t0 < 0)
			{
				result = fmod+t0 ;
			}
			else
			{
				result = t0 ;
			}
		}
		
		return result;
	}
}
