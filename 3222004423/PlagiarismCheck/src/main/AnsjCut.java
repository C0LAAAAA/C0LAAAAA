package main;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnsjCut {

    private static final Set<String> stopWords = Set.of("的", "了", "在", "是", "我", "有","他","她","它","[","]"); // 定义停用词集合

    public static List<String> WordAnsjCut(String p){

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

    public static List<String> Merge(List<String> s1, List<String> s2){
        Set<String> set = new LinkedHashSet<>(s1);
        set.addAll(s2);
        return new ArrayList<>(set);
    }


}