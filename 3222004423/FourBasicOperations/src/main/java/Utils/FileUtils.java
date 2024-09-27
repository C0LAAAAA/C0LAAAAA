package Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // 将题目或答案写入文件
    public static void writeToFile(String fileName, List<String> data) {
        // 确保文件夹存在
        Path path = Paths.get("resources");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);  // 创建resources文件夹
            } catch (IOException e) {
                System.out.println("无法创建文件夹：" + path.toString());
                e.printStackTrace();
                return; // 如果创建文件夹失败，提前返回
            }
        }

        // 写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < data.size(); i++) {
                writer.write((i + 1) + ". " + data.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("写入文件失败：" + fileName);
            e.printStackTrace();
        }
    }

    // 将题目和答案写入文件
    public static void writeToFile(String fileName_p, String fileName_a, List<String> problems, List<String> answers) {
        try (BufferedWriter problemsWriter = new BufferedWriter(new FileWriter(fileName_p));
             BufferedWriter answersWriter = new BufferedWriter(new FileWriter(fileName_a))) {
            for (int i = 0; i < problems.size(); i++) {
                problemsWriter.write((i + 1) + ". " + problems.toArray()[i] );
                problemsWriter.newLine();
            }

            for (int i = 0; i < answers.size(); i++) {
                answersWriter.write((i + 1) + ". " + answers.get(i));
                answersWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("写入文件失败：" + fileName_p);
            System.out.println("写入文件失败：" + fileName_a);
            e.printStackTrace();
        }
    }

    // 将统计结果写入文件
    public static void writeToFile(String fileName_a, ArrayList<Integer> correctList, ArrayList<Integer> wrongList, ArrayList<Integer> errorList) {
        String fileDir = fileName_a.replace("Answers.txt", "");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileDir + "/Grade.txt"))) {
            writer.write("Correct: " + correctList.size() + "( " + correctList.toString().replaceAll("[\\[\\] ]", "") + " )");
            writer.newLine();
            writer.write("Wrong: " + wrongList.size() + "( " + wrongList.toString().replaceAll("[\\[\\] ]", "") + " )");
            writer.newLine();
            writer.write("Error: " + errorList.size() + "( " + errorList.toString().replaceAll("[\\[\\] ]", "") + " )");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("写入文件失败：" + fileDir + "/Grade.txt");
            e.printStackTrace();
        }
    }

    // 从文件中读取内容，返回列表
    public static List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) { // 只添加非空白行
                    lines.add(trimmedLine);
                }
            }
        } catch (IOException e) {
            System.out.println("读取文件失败：" + fileName);
            e.printStackTrace();
        }
        return lines;
    }
}
