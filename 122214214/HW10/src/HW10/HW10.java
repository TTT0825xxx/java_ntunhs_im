package HW10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class HW10 {
	    private static final String FILE_PATH = "students.csv";
	    private static Map<String, Integer> grades = new HashMap<>();

	    public static void main(String[] args) {
	        try {
	            loadGrades();
	        } catch (IOException e) {
	            System.out.println("Error loading grades: " + e.getMessage());
	        }

	        Scanner scanner = new Scanner(System.in);
	        boolean isLoop = true;

	        while (isLoop) {
	            String line = input("請輸入指令選擇下列功能 0.新增 1.查詢 2.修改 3. 刪除 4.顯示所有 99. 結束：", scanner);
	            String name;
	            int grade;

	            switch (line) {
	                case "99":
	                    isLoop = false;
	                    break;
	                case "0":
	                    name = input("請輸入學生姓名:", scanner);
	                    grade = Integer.parseInt(input("請輸入學生成績:", scanner));
	                    grades.putIfAbsent(name, grade);
	                    break;
	                case "1":
	                    name = input("請輸入學生姓名:", scanner);
	                    System.out.println("學生姓名：" + name + " 成績：" + grades.getOrDefault(name, -1));
	                    break;
	                case "2":
	                    name = input("請輸入學生姓名：", scanner);
	                    grade = Integer.parseInt(input("請輸入學生修改成績:", scanner));
	                    grades.put(name, grade);
	                    System.out.println("學生姓名：" + name + " 修改後成績：" + grades.get(name));
	                    break;
	                case "3":
	                    name = input("請輸入學生姓名:", scanner);
	                    grades.remove(name);
	                    System.out.println("學生姓名：" + name + "已刪除");
	                    break;
	                case "4":
	                    System.out.println("學生成績列表:");
	                    grades.forEach((k, v) -> System.out.println(k + ": " + v));
	                    break;
	            }
	        }

	        scanner.close();

	        try {
	            saveGrades();
	        } catch (IOException e) {
	            System.out.println("Error saving grades: " + e.getMessage());
	        }
	    }

	    static String input(String prompt, Scanner scanner) {
	        System.out.print(prompt);
	        return scanner.nextLine();
	    }

	    static void loadGrades() throws IOException {
	        File file = new File(FILE_PATH);
	        if (file.exists()) {
	            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    String[] parts = line.split(",");
	                    if (parts.length == 2) {
	                        grades.put(parts[0], Integer.parseInt(parts[1]));
	                    }
	                }
	            }
	        } else {
	            file.createNewFile();
	        }
	    }

	    static void saveGrades() throws IOException {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
	            for (Map.Entry<String, Integer> entry : grades.entrySet()) {
	                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
	            }
	        }
	    }
	}

