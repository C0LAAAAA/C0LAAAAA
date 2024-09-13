package Main;

import java.util.List;

/**
 * CountNum 类用于统计一个文本中每个词汇的出现频率。
 */
public class CountNum {

    /**
     * 计算文本中每个词汇的出现频率。
     *
     * @param text 要统计的文本，由词汇组成的列表。
     * @param mergetext 合并后的词汇表，包含所有可能的词汇。
     * @return 一个整数数组，表示每个词汇在文本中的出现次数。
     */
    public static int[] CountNum(List<String> text, List<String> mergetext) {
        // 初始化频率数组，数组的大小与合并后的词汇表大小相同
        int[] frequency = new int[mergetext.size()];

        // 遍历文本中的每个词汇
        for (String word : text) {
            // 遍历合并后的词汇表
            for (int i = 0; i < mergetext.size(); i++) {
                // 如果文本中的词汇与词汇表中的词汇相同，则增加该词汇的计数
                if (word.equals(mergetext.get(i))) {
                    frequency[i]++;
                }
            }
        }
        // 返回包含每个词汇出现次数的数组
        return frequency;
    }

}