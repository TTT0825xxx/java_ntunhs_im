package HW933;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW933 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> grades = new HashMap<>();

        boolean isLoop = true;

        while (isLoop) {
            System.out.println("請選擇操作：");
            System.out.println("1. 新增學生成績");
            System.out.println("2. 查詢學生成績");
            System.out.println("3. 修改學生成績");
            System.out.println("4. 刪除學生成績");
            System.out.println("5. 列出所有學生成績");
            System.out.println("0. 結束操作");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 捕獲換行符

            switch (choice) {
                case 1:
                    addGrade(grades, scanner);
                    break;
                case 2:
                    queryGrade(grades, scanner);
                    break;
                case 3:
                    updateGrade(grades, scanner);
                    break;
                case 4:
                    deleteGrade(grades, scanner);
                    break;
                case 5:
                    listAllGrades(grades);
                    break;
                case 0:
                    isLoop = false;
                    break;
                default:
                    System.out.println("請輸入正確的操作選項（0-5）！");
            }
        }

        scanner.close();
    }

    static void addGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.print("請輸入學生名稱：");
        String name = scanner.nextLine();
        System.out.print("請輸入學生成績：");
        int score = scanner.nextInt();
        scanner.nextLine(); // 捕獲換行符
        grades.put(name, score);
        System.out.println("學生成績已添加！");
    }

    static void queryGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.print("請輸入要查詢的學生名稱：");
        String name = scanner.nextLine();
        Integer score = grades.get(name);
        if (score != null) {
            System.out.println( name + " 的成績是：" + score);
        } else {
            System.out.println("找不到學生 " + name + " 的成績！");
        }
    }

    static void updateGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.print("請輸入要修改成績的學生名稱：");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            System.out.print("請輸入新的成績：");
            int score = scanner.nextInt();
            scanner.nextLine(); // 捕獲換行符
            grades.put(name, score);
            System.out.println(name + " 的成績已更新！");
        } else {
            System.out.println("找不到學生 " + name + " 的成績，無法進行修改！");
        }
    }

    static void deleteGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.print("請輸入要刪除成績的學生名稱：");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            grades.remove(name);
            System.out.println(name + " 的成績已刪除！");
        } else {
            System.out.println("找不到學生 " + name + " 的成績，無法進行刪除！");
        }
    }

    static void listAllGrades(Map<String, Integer> grades) {
        System.out.println("所有學生成績：");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}