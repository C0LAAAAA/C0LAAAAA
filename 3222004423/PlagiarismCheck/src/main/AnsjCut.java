package Main;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * AnsjCut 类用于使用 Ansj 分词工具进行文本分词。
 */
public class AnsjCut {

    /**
     * 定义停用词集合，这些词在分词结果中会被过滤掉。
     */
    private static final Set<String> stopWords = Set.of("的", "了", "在", "是", "我", "有", "他", "她", "它", "[", "]", "因为", "也", "让", "可是", "但是", "地", "才", "会", "要", "和", "必须","上");

    /**
     * 使用 Ansj 分词工具对给定文本进行分词处理。
     *
     * @param p 要分词的原始文本。
     * @return 分词结果的列表，不包含停用词。
     */
    public static List<String> WordAnsjCut(String p) {
        // 去除文本中的换行、空格和标点符号
        p = p.replaceAll("\\s+", "").replaceAll("[.,;:!?'\"“”‘’。、，？《》（）【】「」：！]", "");

        // 使用 Ansj 分词工具解析文本并获取分词结果
        Result result = ToAnalysis.parse(p);

        // 从结果中提取词项并转换为字符串流，同时过滤停用词
        List<String> terms = result.getTerms().stream()
                .map(Term::getName)  // 获取每个词项的名称
                .filter(name -> !stopWords.contains(name))  // 过滤停用词
                .collect(Collectors.toList());  // 收集成列表

        return terms;
    }

    /**
     * 合并两个文本的词汇表，去除重复的词汇。
     *
     * @param s1 第一个文本的词汇列表。
     * @param s2 第二个文本的词汇列表。
     * @return 合并后的词汇列表。
     */
    public static List<String> Merge(List<String> s1, List<String> s2) {
        Set<String> set = new LinkedHashSet<>(s1);
        set.addAll(s2);
        return new ArrayList<>(set);
    }

}