package Main;

/**
 * CosineSimilarity 类用于计算两个向量之间的余弦相似度。
 */
public class CosineSimilarity {

    /**
     * 计算两个整数数组表示的向量之间的余弦相似度。
     *
     * @param number1 原文词频向量。
     * @param number2 抄袭文件词频向量。
     * @return 两个向量之间的余弦相似度，范围从 -1（完全相反）到 1（完全相同）。
     */
    public static double getSimilarity(int[] number1, int[] number2) {
        // 初始化向量的点积和各自的平方和
        float square1 = 0, square2 = 0, product = 0;

        // 遍历向量中的每个元素
        for (int i = 0; i < number1.length; i++) {
            // 计算点积
            product += number1[i] * number2[i];

            // 计算第一个向量的平方和
            square1 += (float) Math.pow(number1[i], 2);
            // 计算第二个向量的平方和
            square2 += (float) Math.pow(number2[i], 2);
        }

        // 计算余弦相似度
        if(square1==0 ||square2==0)return 0;// 防止除以0
        // 公式为：点积 / (sqrt(平方和1) * sqrt(平方和2))
        return (float) (product / (Math.sqrt(square1) * Math.sqrt(square2)));
    }
}