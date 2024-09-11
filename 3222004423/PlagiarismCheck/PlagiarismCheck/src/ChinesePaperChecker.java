import java.io.*;
import java.util.Arrays;
import java.util.List;

import static main.AnsjCut.Merge;
import static main.AnsjCut.WordAnsjCut;
import static main.CosineSimilarity.getSimilarity;
import static main.CountNum.CountTF;
import static main.ReadAndWrite.Read;
import static main.ReadAndWrite.Write;

public class ChinesePaperChecker {

    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("/n请输入: java ChinesePaperChecker <orig_file> <plagiarized_file> <output_file>");
            return;
        }

        String origPath = args[0];
        String plagPath = args[1];
        String outputPath = args[2];

        /**

        String origPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\resources\\orig.txt";
        String plagPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\resources\\orig_0.8_dis_15.txt";
        String outputPath = "C:\\Users\\Vert\\IdeaProjects\\PlagiarismCheck\\resources\\1test.txt";

        **/

        List<String> origText =Read(origPath);
        List<String> plagText =Read(plagPath);

        origText=WordAnsjCut(String.valueOf(origText));
        plagText=WordAnsjCut(String.valueOf(plagText));

        List<String> mergeText=Merge(origText,plagText);

       // System.out.println("Original Text:\n\n" + origText);
       // System.out.println("Plagiarized Text:\n\n" + plagText);

        //System.out.println("Merge Text:\n\n" + mergeText);



        int origNum[]=CountTF(origText,mergeText);
        int plagNUM[]=CountTF(plagText,mergeText);

       // System.out.println("Original Text : " + Arrays.toString(origNum));
        //System.out.println("Plagiarized Text : " + Arrays.toString(plagNUM));

        float s= (float) getSimilarity(origNum,plagNUM);

        System.out.printf("%.2f", s);

        Write(outputPath,s);


    }

}
