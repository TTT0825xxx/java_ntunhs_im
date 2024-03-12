package hk31;

import java.util.Scanner;

public class hk31 {
   public static void main(String[]args) {
	   
	   Scanner sc=new Scanner(System.in);
	   int idx=0;
	   int num=5;
	   int arr[]=new int[5];
	   
	   int nums[];
	   nums=new int [5];
	   System.out.println("enter a number");
	   for(int i=0;
			   i<num;i++) {
		   arr[i]=sc.nextInt();
	   }
	   idx=num-1;
	   while(idx>=0) {
	   System.out.printf("arr[%d]:%d\n",idx,arr[idx]);
	   idx--;
	   }
   }
}
