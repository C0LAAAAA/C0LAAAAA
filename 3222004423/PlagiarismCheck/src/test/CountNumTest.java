package test;


import Main.CountNum;

import java.util.Arrays;
import java.util.List;

public class CountNumTest {

    public static void main(String[] args) {
        // 定义文本和合并后的词汇表
        List<String> text = Arrays.asList("3", "2", "3", "1", "2", "3");
        List<String> mergeText = Arrays.asList("3", "2", "1", "0");

        // 计算文本中每个词项的出现频率
        int[] frequency = CountNum.CountNum(text, mergeText);

        // 打印结果
        for (int i = 0; i < mergeText.size(); i++) {
            System.out.println( mergeText.get(i)+ "的词频是: " + frequency[i]);
        }
    }
}
