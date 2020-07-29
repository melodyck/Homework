package day05;

import java.util.*;
import java.util.Map.Entry;

/**
 *创建一个Map，保存某个学生的成绩:
 *在控制台输入该学生成绩，格式:
 *科目:成绩;科目:成绩;...
 *例如:  
 *语文:99;数学:98;英语:97;物理:96;化学:95
 *然后输出物理的成绩。
 *然后将化学的成绩设置为96
 *然后删除英语这一项。
 *然后遍历该Map分别按照遍历key，Entry，value
 *的形式输出该Map信息。
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println("请输入各科成绩,格式:\n" +
                "科目:成绩;科目:成绩;...\n" +
                "例如:\n" +
                "语文:99;数学:98;英语:97;物理:96;化学:95");
        Scanner console = new Scanner(System.in);
        String s = console. nextLine();
        console.close();
        String[] entry = s.split(";");
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String e: entry){
            String[] subjectAndGrade = e.split(":");
            map.put(subjectAndGrade[0], Integer.parseInt(subjectAndGrade[1]));
        }
        System.out.println("物理:" + map.get("物理"));
        map.put("化学", 96);
        map.remove("英语");
        //keySet遍历
        System.out.println("键值遍历");
        Set<String> keySet = map.keySet();
        for(String key: keySet){
            System.out.println(key + ":" + map.get(key));
        }
        //entrySet遍历
        System.out.println("键值对遍历");
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        for(Entry<String, Integer> e: entrySet){
            System.out.println(e);
        }
        //values遍历
        System.out.println("value值遍历");
        Collection<Integer> values = map.values();//values方法返回类型为Collection接口类
        for(Integer grade: values){
            System.out.println(grade);
        }
    }
}
