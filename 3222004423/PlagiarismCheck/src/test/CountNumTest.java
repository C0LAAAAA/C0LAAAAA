package Main;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class CountNumTest {

    @Test
    public void test1() {
        // 定义文本，数字1到9，每个数字出现次数与其值相等
        List<String> text = Arrays.asList(
                "9", "9", "9", "9", "9", "9", "9", "9", "9",
                "8", "8", "8", "8", "8", "8", "8", "8",
                "7", "7", "7", "7", "7", "7", "7",
                "6", "6", "6", "6", "6", "6",
                "5", "5", "5", "5", "5",
                "4", "4", "4", "4",
                "3", "3", "3",
                "2", "2",
                "1"
        );
        // 定义合并后的词汇表，包含数字0到9
        List<String> mergeText = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        // 计算文本中每个词项的出现频率
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 每个数字的词频
        int[] actual = CountNum.CountNum(text, mergeText);

        // 验证频率是否符合预期
        assertArrayEquals(expected, actual);
    }


    @Test
    public void test2() {
        // 定义空文本
        List<String> text = Arrays.asList();
        // 定义合并后的词汇表，包含数字0到9
        List<String> mergeText = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        // 计算文本中每个词项的出现频率
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 所有词汇的词频都为0
        int[] actual = CountNum.CountNum(text, mergeText);

        // 验证频率是否符合预期
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        // 定义文本，数字1到3，每个数字出现次数与其值相等
        List<String> text = Arrays.asList(
                "3", "3", "3",
                "2", "2",
                "1"
        );
        // 定义空的合并词汇表
        List<String> mergeText = Arrays.asList();

        // 计算文本中每个词项的出现频率
        int[] expected = {}; // 没有合并词汇，结果应该是空的
        int[] actual = CountNum.CountNum(text, mergeText);

        // 验证频率是否符合预期
        assertArrayEquals(expected, actual);
    }


}
