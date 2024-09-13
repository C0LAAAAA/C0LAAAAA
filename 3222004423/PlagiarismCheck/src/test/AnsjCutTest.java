package Main;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class AnsjCutTest {

    @Test
    public void test1() {
        String text = "在百合花幽暗的阁楼上， 在我们的月亮床上 ， 在海龟梦想的舞蹈里";
        List<String> expected = Arrays.asList("百合花", "幽暗", "阁楼", "我们", "月亮", "床上", "海龟", "梦想", "舞蹈","里");

        // 调用 WordAnsjCut 方法
        List<String> actual = AnsjCut.WordAnsjCut(text);

        // 断言分词结果是否符合预期
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String text = "唉，唉，唉，唉！ ";
        List<String> expected = Arrays.asList("唉", "唉", "唉", "唉");

        // 调用 WordAnsjCut 方法
        List<String> actual = AnsjCut.WordAnsjCut(text);

        // 断言标点符号被去除，分词结果是否符合预期
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        List<String> list1 = Arrays.asList("百合花", "幽暗", "阁楼");
        List<String> list2 = Arrays.asList("圆舞曲", "拿走", "梦想");

        List<String> expected = Arrays.asList("百合花", "幽暗", "阁楼", "圆舞曲", "拿走", "梦想");

        // 调用 Merge 方法
        List<String> actual = AnsjCut.Merge(list1, list2);

        // 断言合并后的结果是否符合预期
        assertEquals(expected, actual);
    }
}
