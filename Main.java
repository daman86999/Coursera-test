import java.util. Scanner;
import java.util.*;
import java.util.ArrayList;

abstract class FamilyEarning		// Abstract classes concept
{
	int sum=0;
	Scanner sc = new Scanner(System.in);
	void details()
	{
		System.out.print("Enter the total numbers of family members : \t");
		int members = sc.nextInt();
		System.out.print("\nEnter the total working member of family : \t");
		int working = sc.nextInt();
		int arr[] = new int[working];
		for(int i =0;i<arr.length;i++)
		{
			System.out.print("\nEnter the earning of  "+(i+1)+" person : \t");
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++)
		{
			sum=sum + arr[i];	
		}
		//System.out.println("The total earning of family is : \t"+sum);
		
	}
	int total()
	{
		return sum;
	}
	abstract void bill();			//operator overriding
}
class Expenses extends FamilyEarning		// Inheritance
{
	Scanner sc = new Scanner(System.in);
	
	void totalEarning()
	{
		System.out.println("=====>>>>Total earning of the family: \t"+super.total());
	}
	void bill()
	{
		System.out.println("====== Expenses of the family ======");
		String src[] = new String[1000];
		int amt[] = new int[1000];
		int flag = 1;
		int i=0;
		int sum = 0;
		char check = 'n';
		while(flag !=0)
		{	
			System.out.print("\nEnter the source of expenditure : \t");
			src[i] = sc.next();
			System.out.print("\nEnter the amount\t");
			amt[i] = sc.nextInt();
			sum = sum+amt[i];
			System.out.print("\nAny other expenses : \t(y/n)");
			check = sc.next().charAt(0);
			if(check == 'y' || check == 'Y')
				{}
			else
				{flag = 0;}
			i++;
		}
		System.out.println(i);
		System.out.print("The total expenditure is :\t"+sum);
		
		int left;
		left = super.total() - sum;
		
		sum = 0;
		if(left>0)
		{
			System.out.print("\nMoney saved this month is : \t"+left);
		}
		if(left<0)
		{	
			System.out.print("\nWARNING : Expenses are going over budget !!!");
			System.out.println("\nSystem recomends the user to lower his/her expenses...");
			for(int j=0;j<i;j++)
			{	
				System.out.println("Enter the reduced amount for\t"+src[j]);
				System.out.println("The previous amount was: \t"+amt[j]);
				System.out.print("\nEnter the new amount\t");
				amt[j] = sc.nextInt();
				sum = sum+amt[j];
				
			}
			left = super.total() - sum;
			System.out.println("After the expenditure money saved this month is :"+left);
			
		}
	}
}

public class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("This is the Main class");
		Expenses ex = new Expenses();
		ex.details();
		ex.totalEarning();
		ex.bill();
	}
}