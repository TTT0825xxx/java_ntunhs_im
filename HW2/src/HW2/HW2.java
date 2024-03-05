package HW2;

import java.util.Scanner;

public class HW2 {
	static String fever;
	static String cough;
	static String lazy;
	static String highbool;
	static String dry;
	static String sweats;
  public static void main(String[]args){
	Scanner scanner=new Scanner(System.in);
	System.out.println("歡迎使用醫療診斷系統，請依序回答問題");
	System.out.println("===========================");
	System.out.println("請問您最近是否發燒");
	fever=scanner.next();
	if(fever.toLowerCase().equals("y")) {
		System.out.print("請問您是否咳嗽");
		cough=scanner.next();
		if(cough.toLowerCase().equals("y")) {
			System.out.println("請問您最近是否疲倦");
			lazy =scanner.next();
			if(lazy.toLowerCase().equals("y")) {
				System.out.print("先生/小姐您可能感冒了!!!");
			}
					
		else {
			System.out.print("去其他系統");
		}
		}
		else if(cough.toLowerCase().equals("n")) {
	    	System.out.println("您是否高血壓");
	    	highbool=scanner.next();
			if(highbool.toLowerCase().equals("y")) {
				System.out.println("請問您最近是否口乾");
				dry =scanner.next();
				if(dry.toLowerCase().equals("y")) {
					System.out.print("您可能得肝病了!!!");
				}
				else if(dry.toLowerCase().equals("n")) {
					System.out.println("其他系統");
	    	}
			}
			else if(highbool.toLowerCase().equals("n")) {
				System.out.println("請問您最近是否盜汗");
				sweats =scanner.next();
				if(sweats.toLowerCase().equals("y")) {
					System.out.print("您可能得肺病了!!!");
				}
				else if(sweats.toLowerCase().equals("n")) {
					System.out.println("其他系統");
				}
	else if(fever.toLowerCase().equals("n")) {
		System.out.println("正常");}
	}
	}
  }
	}
  }