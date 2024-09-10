import java.io.*;
import java.util.List;

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

        List<String> origText =Read(origPath);
        List<String> plagText =Read(plagPath);


        System.out.println("Original Text:\n\n" + origText);
        System.out.println("Original Text:\n\n" + plagText);

        Write(outputPath);


    }

}
