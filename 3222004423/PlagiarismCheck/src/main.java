import java.util.Arrays;
import java.util.List;

import static Main.AnsjCut.Merge;
import static Main.AnsjCut.WordAnsjCut;
import static Main.CosineSimilarity.getSimilarity;
import static Main.CountNum.CountNum;
import static Main.ReadAndWrite.Read;
import static Main.ReadAndWrite.Write;

public class main {

    public static void main(String[] args)  {

        // 检查命令行参数数量是否正确
        if (args.length != 3) {
            System.out.println("\n请输入 <原文文件地址> <抄袭版论文的文件地址> <答案文件地址>");
            return;
        }

        // 从命令行参数获取文件路径
        String origPath = args[0];
        String plagPath = args[1];
        String outputPath = args[2];

        /**
         //测试用代码，可以注释掉或者删除
         String origPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\src\\Main\\resources\\orig.txt";
         String plagPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\src\\Main\\resources\\orig_0.8_add.txt";
         String outputPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\src\\Main\\resources\\1test.txt";
         **/

        // 读取原文和抄袭文本
        List<String> origText = Read(origPath);
        List<String> plagText = Read(plagPath);

        // 使用Ansj分词工具进行分词
        origText = WordAnsjCut(String.valueOf(origText));
        plagText = WordAnsjCut(String.valueOf(plagText));

        // 合并两个文本的词汇表
        List<String> mergeText = Merge(origText, plagText);

        // 打印分词结果，可以注释掉或者删除
        // System.out.println("Original Text:\n" + origText);
        // System.out.println("Plagiarized Text:\n" + plagText);
        // System.out.println("Merge Text:\n" + mergeText);

        // 计算原文和抄袭文本中每个词项的出现次数
        int origNum[] = CountNum(origText, mergeText);
        int plagNUM[] = CountNum(plagText, mergeText);

        // 打印词频统计结果，可以注释掉或者删除
        // System.out.println("\nOriginal Text : \n" + Arrays.toString(origNum));
        // System.out.println("Plagiarized Text : \n" + Arrays.toString(plagNUM));

        // 计算两个文本的余弦相似度
        float s = (float) getSimilarity(origNum, plagNUM);

        // 打印余弦相似度，保留两位小数
        System.out.printf("\n余弦相似度：%.2f", s);

        // 将余弦相似度写入指定的输出文件
        Write(outputPath, s);

    }

}