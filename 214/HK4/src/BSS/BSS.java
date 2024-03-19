package BSS;

import java.util.Scanner;

public class BSS {
public static void main(String[]args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("這是可以陪你聊天程式，你可以問我一些問題");
	while(true) {
		System.out.print("你說:");
		String temp = sc. nextLine();
		
		if("0".equals(temp)) {
			System.out.println("離開聊天程序");
			break;
			}
		temp=temp.replaceAll("嗎","")
				.replace("會不會","會")
				.replace("能不能","能")
				.replace("你能","我能")
				.replace("你會","我會")
				.replace("?","!");
		System.out.println("我說:"+temp);
		}
	sc.close();
}
}
