package BSSS;
import java.util.Scanner;
public class BSSS {
	    public static void main(String[] args) {
	        // 初始化一張儲值卡
	        StoreValueCard card = new StoreValueCard("ntunhs001", 1000, 0);
	        Scanner scanner = new Scanner(System.in);
	        
	        // 儲值卡系統選單
	        while (true) {
	            System.out.println("請選擇操作：");
	            System.out.println("1. 儲值");
	            System.out.println("2. 扣款");
	            System.out.println("3. 兌換紅利");
	            System.out.println("4. 查看明細");
	            System.out.println("5. 離開");
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
	                case 1:
	                    System.out.println("請輸入儲值金額：");
	                    int value = scanner.nextInt();
	                    card.addValue(value);
	                    break;
	                case 2:
	                    System.out.println("請輸入扣款金額：");
	                    int chargeAmount = scanner.nextInt();
	                    card.charge(chargeAmount);
	                    break;
	                case 3:
	                    card.exchangeBonus();
	                    break;
	                case 4:
	                    card.printDetails();
	                    break;
	                case 5:
	                    System.out.println("程式結束。");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("輸入無效，請重新輸入。");
	            }
	        }
	    }
	}

	class StoreValueCard {
	    private String cardId;
	    private int balance;
	    private int bonus;
	    private static int totalCardNum = 0;

	    // 建構子
	    public StoreValueCard(String cardId, int balance, int bonus) {
	        this.cardId = cardId;
	        this.balance = balance;
	        this.bonus = bonus;
	        totalCardNum++; // 新增一張卡，增加總發行卡數
	    }

	    // Getter 方法
	    public String getCardId() {
	        return cardId;
	    }

	    public int getBalance() {
	        return balance;
	    }

	    public int getBonus() {
	        return bonus;
	    }

	    // 儲值
	    public void addValue(int value) {
	        if (value > 0) {
	            balance += value;
	            System.out.println("已成功儲值 " + value + " 元。");
	            if (value >= 1000) {
	                bonus++;
	            }
	        } else {
	            System.out.println("請確認儲值金額不為負值。");
	        }
	    }

	    // 扣款
	    public void charge(int amount) {
	        if (amount > 0) {
	            if (balance >= amount) {
	                balance -= amount;
	                System.out.println("已成功扣款 " + amount + " 元。");
	            } else {
	                System.out.println("餘額不足，無法扣款。");
	            }
	        } else {
	            System.out.println("請確認扣款金額不為負值。");
	        }
	    }

	    // 兌換紅利
	    public void exchangeBonus() {
	        int exchangeRate = 10; // 一元兌換十點紅利
	        int bonusToExchange = balance / exchangeRate;
	        balance -= bonusToExchange * exchangeRate;
	        bonus += bonusToExchange;
	        System.out.println("已成功兌換紅利，目前紅利為：" + bonus);
	    }

	    // 列印明細
	    public void printDetails() {
	        System.out.println("卡號：" + cardId);
	        System.out.println("餘額：" + balance + " 元");
	        System.out.println("紅利：" + bonus + " 點");
	    }

	    // 靜態方法，取得總發行卡數
	    public static int getTotalCardNum() {
	        return totalCardNum;
	    }
	}