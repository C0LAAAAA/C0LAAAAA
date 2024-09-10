package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<String> Read(String textPath) throws IOException {
        List<String> article = new ArrayList<String>();


        try {
            // 读取文件内容
            String Text = new String(Files.readAllBytes(Paths.get(textPath)));

            // 去除换行、空格和标点符号
            Text = Text.replaceAll("\\s+", "").replaceAll("[.,;:!?'\"“”‘’。、，？《》（）【】「」：]", "");

            // 将处理后的文本添加到列表中
            article.add(Text);

        }catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
            e.printStackTrace();
        }

        return article;
    }



    public static void Write(String outputPath) {

        // 输出到文件
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            writer.printf("test R&W");
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
