package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个List集合并添加元素0-9
 * 然后获取子集[3,4,5,6]
 * 然后将子集元素扩大10倍
 * 然后输出原集合。
 * 之后删除集合中的[7,8,9]
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        //返回列表中指定的fromIndex （含）和toIndex之间的部分视图。 （如果fromIndex和toIndex相等，返回的列表为空。）
        // 返回的列表由此列表支持，因此返回列表中的非结构性更改将反映在此列表中，反之亦然。 返回的列表支持此列表支持的所有可选列表操作。
        List<Integer> sublist = list.subList(3, 7);
        for (int i = 0; i < sublist.size(); i++) {
            sublist.set(i, sublist.get(i) * 10);
        }
        System.out.println(list);
        list.removeAll(list.subList(7, 10));
    }
}
