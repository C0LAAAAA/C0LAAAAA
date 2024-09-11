package test;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnsjCutTest {

    private static final Set<String> stopWords = Set.of("的", "了", "在", "是", "我", "有", "他", "她", "它", "[", "]"); // 定义停用词集合

    public static List<String> WordAnsjCut(String p) {

        // 去除换行、空格和标点符号
        p = p.replaceAll("\\s+", "").replaceAll("[.,;:!?'\"“”‘’。、，？《》（）【】「」：！]", "");

        // 解析文本并获取分词结果
        Result result = ToAnalysis.parse(p);

        // 从结果中提取词项并转换为字符串流，同时过滤停用词
        List<String> terms = result.getTerms().stream()
                .map(Term::getName)  // 获取每个词项的名称
                .filter(name -> !stopWords.contains(name))  // 过滤停用词
                .collect(Collectors.toList());  // 收集成列表
        return terms;
    }

    public static List<String> Merge(List<String> s1, List<String> s2) {
        Set<String> set = new LinkedHashSet<>(s1);
        set.addAll(s2);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        String text1 = "活着前言\n" +
                "\n" +
                "    一位真正的作家永远只为内心写作，只有内心才会真实地告诉他，他的自私、他的高尚是多么突出。内心让他真实地了解自己，一旦了解了自己也就了解了世界。很多年前我就明白了这个原则，可是要捍卫这个原则必须付出艰辛的劳动和长时期的痛苦，因为内心并非时时刻刻都是敞开的，它更多的时候倒是封闭起来，于是只有写作，不停地写作才能使内心敞开，才能使自己置身于发现之中，就像日出的光芒照亮了黑暗，灵感这时候才会突然来到。\n";
        String text2 = "长期以来，我的作品都是源出于和现实的那一层紧张关系。我沉湎于想象之中，又被现实紧紧控制，我明确感受着自我的分裂，我无法使自己变得纯粹，我曾经希望自己成为一位童话作家，要不就是一位实实在在作品的拥有者，如果我能够成为这两者中的任何一个，我想我内心的痛苦将会轻微得多，可是与此同时我的力量也会削弱很多。";

        List<String> words1 = WordAnsjCut(text1);
        List<String> words2 = WordAnsjCut(text2);

        System.out.println("Text 1 words: " + words1);
        System.out.println("Text 2 words: " + words2);

        List<String> mergedWords = Merge(words1, words2);
        System.out.println("Merged words: " + mergedWords);
    }
}