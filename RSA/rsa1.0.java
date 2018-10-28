package RSA;

import java.util.Scanner;

public class rsa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1=0 ,num2=0 ;
		int result1=0 , result2=0 ;
		int e = 0 ;
		Scanner scan = new Scanner(System.in) ;
		
	    do
	    {
			System.out.println("Enter Number 1:");
			num1 = scan.nextInt() ;
			result1 = prime(num1) ;
			if(result1 == 0)
			{
				System.out.println("Not a prime Number. Enter again") ;
			}
	    }while(result1 == 0) ;
		
		
		do
		{
			System.out.println("Enter Number 2:");
			num2 = scan.nextInt() ;
			result2 = prime(num2) ;
			if(result2 == 0)
			{
				System.out.println("Not a prime Number. Enter again") ;
			}
		}while(result2 == 0) ;
		
		int n = num1*num2;
		int phi = (num1-1)*(num2-1) ;
		
		e = finde(phi);
		//System.out.println("Value of e = " + e);
			
		System.out.println("Public Key:["+ e + " , " + n + "]");
		
		
		
		System.out.println("Enter Message:") ;
		int message = scan.nextInt() ;
		
		System.out.println("Ciphered Text : " + (Math.pow(message, e)%n) ) ;
		
		scan.close();
	}
	
	public static int prime(int number)
	{
		int result = 1;
		int i = 2 ;
		
		for(;i<number/2;i++)
		{
			if(number%i == 0)
			{
				result = 0 ;
				i = number ;
			}
		}
		return result ;
	}
	
	public static int finde(int phi)
	{
		int result = 0 ;
		int e = 2 ;
	
		while( e < phi)
		{
			if(gcd(phi , e) == 1 )
			{
				result = e ;
				e = phi ;
			}
			else
			{
				e++ ;
			}
		}
				
		return result;
	}

	public static int gcd(int num1 , int num2)
	{
		int result = 0 ;
		
		if(num1 == 0)
		{
			result = num2 ;
		}
		else 
		{
			result = gcd(num2%num1 , num1) ;
		}

		return result ;
	}
}
