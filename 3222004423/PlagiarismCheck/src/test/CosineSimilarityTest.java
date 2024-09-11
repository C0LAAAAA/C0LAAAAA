package test;

import Main.CosineSimilarity;

public class CosineSimilarityTest {

    public static void main(String[] args) {
        // 定义两个向量
        int[] v1 = {1, 2, 3};
        int[] v2 = {4, 5, 6};

        // 计算两个向量的余弦相似度
        double similarity= CosineSimilarity.getSimilarity(v1, v2);

        // 打印结果
        System.out.println("余弦相似度1: " + similarity);

        // 定义两个完全垂直的向量
        int[] v3 = {1, 0, 0};
        int[] v4 = {0, 1, 0};

        // 计算两个完全垂直的向量的余弦相似度
        double similarity2 = CosineSimilarity.getSimilarity(v3, v4);

        // 打印结果
        System.out.println("余弦相似度2: " + similarity2);

        // 定义一个与自身相关的向量
        int[] v5 = {2, 3, 4};

        // 计算向量与自身的余弦相似度
        double similarity3 = CosineSimilarity.getSimilarity(v5, v5);

        // 打印结果
        System.out.println("余弦相似度3: " + similarity3);
    }
}