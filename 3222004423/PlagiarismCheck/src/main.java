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


        if (args.length != 3) {
            System.out.println("/n请输入: java main <orig_file> <plagiarized_file> <output_file>");
            return;
        }

        String origPath = args[0];
        String plagPath = args[1];
        String outputPath = args[2];

/**

        String origPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\src\\Main\\resources\\orig.txt";
        String plagPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\src\\Main\\resources\\orig_0.8_add.txt";
        String outputPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\src\\Main\\resources\\1test.txt";

 **/

        List<String> origText =Read(origPath);
        List<String> plagText =Read(plagPath);

        origText=WordAnsjCut(String.valueOf(origText));
        plagText=WordAnsjCut(String.valueOf(plagText));

        List<String> mergeText=Merge(origText,plagText);

        // System.out.println("Original Text:\n\n" + origText);
        // System.out.println("Plagiarized Text:\n\n" + plagText);
        // System.out.println("Merge Text:\n\n" + mergeText);



        int origNum[]= CountNum(origText,mergeText);
        int plagNUM[]= CountNum(plagText,mergeText);

        // System.out.println("Original Text : " + Arrays.toString(origNum));
        // System.out.println("Plagiarized Text : " + Arrays.toString(plagNUM));

        float s= (float) getSimilarity(origNum,plagNUM);

        System.out.printf("\n余弦相似度：%.2f", s);

        Write(outputPath,s);


    }

}
