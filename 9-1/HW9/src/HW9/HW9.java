package HW9;
import java.util.Scanner;
import java.util.Arrays;

public class HW9 {

    public static void main(String[] args) {
        // 讓使用者輸入數字，並存入陣列
        double[] numbers = inputNumbers();

        // 如果沒有輸入數字，則結束程式
        if (numbers.length == 0) {
            System.out.println("沒有輸入數字，無法計算。");
            return;
        }

        // 將數字排序
        Arrays.sort(numbers);

        // 計算最大值、最小值和平均值
        double max = numbers[numbers.length - 1];
        double min = numbers[0];
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        double average = sum / numbers.length;

        // 顯示結果
        System.out.println("排序後的數字：" + Arrays.toString(numbers));
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println("平均值：" + average);
    }

    // 讓使用者輸入數字並存入陣列中
    static double[] inputNumbers() {
        System.out.println("請輸入數字，以空格分隔：");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] numberStrings = inputLine.split(" ");
        double[] numbers = new double[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            try {
                numbers[i] = Double.parseDouble(numberStrings[i]);
            } catch (NumberFormatException e) {
                System.out.println("輸入的內容不是有效的數字：" + numberStrings[i]);
                return new double[0];
            }
        }
        return numbers;
    }
}