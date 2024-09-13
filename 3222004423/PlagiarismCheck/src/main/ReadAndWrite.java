package Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadAndWrite 类提供文件读取和写入的功能。
 */
public class ReadAndWrite {
    /**
     * 从指定路径读取文本文件，并将其内容作为一个字符串添加到列表中返回。
     *
     * @param textPath 文本文件的路径。
     * @return 包含文本文件内容的列表。
     */
    public static List<String> Read(String textPath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(textPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * 将给定的余弦相似度值写入到指定的输出文件中。
     *
     * @param outputPath 输出文件的路径。
     * @param s 要写入的余弦相似度值。
     */
    public static void Write(String outputPath, float s) {
        // 将数据写入到文件
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            // 格式化写入余弦相似度值，保留两位小数
            writer.printf("余弦相似度：%.2f", s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}