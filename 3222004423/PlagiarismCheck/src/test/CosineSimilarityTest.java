package Main;

import org.junit.Test;
import static org.junit.Assert.*;

public class CosineSimilarityTest {

    // 测试完全相同的向量，预期余弦相似度为1.0
    @Test
    public void test1() {
        int[] vector1 = {1, 2, 3};
        int[] vector2 = {1, 2, 3};
        double similarity = CosineSimilarity.getSimilarity(vector1, vector2);
        assertEquals(1.0, similarity, 0.001);
    }

    // 测试正交向量（不同维度），预期余弦相似度为0.0
    @Test
    public void test2() {
        int[] vector1 = {1, 0, 0};
        int[] vector2 = {0, 1, 0};
        double similarity = CosineSimilarity.getSimilarity(vector1, vector2);
        assertEquals(0.0, similarity, 0.001);
    }

    // 测试完全相反的向量，预期余弦相似度为-1.0
    @Test
    public void test3() {
        int[] vector1 = {1, 2, 3};
        int[] vector2 = {-1, -2, -3};
        double similarity = CosineSimilarity.getSimilarity(vector1, vector2);
        assertEquals(-1.0, similarity, 0.001);
    }

    // 测试相似的向量（一个向量的每个元素是另一个向量的元素的两倍），预期余弦相似度为1.0
    @Test
    public void test4() {
        int[] vector1 = {1, 1, 1};
        int[] vector2 = {2, 2, 2};
        double similarity = CosineSimilarity.getSimilarity(vector1, vector2);
        assertEquals(1.0, similarity, 0.001);
    }

    // 测试一个向量全为零，预期余弦相似度为0.0
    @Test
    public void test5() {
        int[] vector1 = {0, 0, 0};
        int[] vector2 = {1, 2, 3};
        double similarity = CosineSimilarity.getSimilarity(vector1, vector2);
        assertEquals(0.0, similarity, 0.001);
    }

}