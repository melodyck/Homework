package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个List集合，并存放10个随机数，然后排序该集合
 * 后输出
 * @author Bonnie
 *
 */
public class Test07 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Math.random());
        }
        list.sort(null);//参数为用于比较列表元素的Comparator 。 null值表示应使用元素' natural ordering '
        System.out.println(list);
    }
}
