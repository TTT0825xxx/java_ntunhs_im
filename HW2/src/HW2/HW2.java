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
	System.out.println("�w��ϥ������E�_�t�ΡA�Ш̧Ǧ^�����D");
	System.out.println("===========================");
	System.out.println("�аݱz�̪�O�_�o�N");
	fever=scanner.next();
	if(fever.toLowerCase().equals("y")) {
		System.out.print("�аݱz�O�_�y��");
		cough=scanner.next();
		if(cough.toLowerCase().equals("y")) {
			System.out.println("�аݱz�̪�O�_�h��");
			lazy =scanner.next();
			if(lazy.toLowerCase().equals("y")) {
				System.out.print("����/�p�j�z�i��P�_�F!!!");
			}
					
		else {
			System.out.print("�h��L�t��");
		}
		}
		else if(cough.toLowerCase().equals("n")) {
	    	System.out.println("�z�O�_������");
	    	highbool=scanner.next();
			if(highbool.toLowerCase().equals("y")) {
				System.out.println("�аݱz�̪�O�_�f��");
				dry =scanner.next();
				if(dry.toLowerCase().equals("y")) {
					System.out.print("�z�i��o�x�f�F!!!");
				}
				else if(dry.toLowerCase().equals("n")) {
					System.out.println("��L�t��");
	    	}
			}
			else if(highbool.toLowerCase().equals("n")) {
				System.out.println("�аݱz�̪�O�_�s��");
				sweats =scanner.next();
				if(sweats.toLowerCase().equals("y")) {
					System.out.print("�z�i��o�ͯf�F!!!");
				}
				else if(sweats.toLowerCase().equals("n")) {
					System.out.println("��L�t��");
				}
	else if(fever.toLowerCase().equals("n")) {
		System.out.println("���`");}
	}
	}
  }
	}
  }