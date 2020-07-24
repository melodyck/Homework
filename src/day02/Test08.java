package day02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
 * @author Bonnie
 *
 */
public class Test08 {
    private static class Person{
        private String name;
        private int age;
        private String gender;
        private int salary;
        public Person(){}
        public Person(String name, int age, String gender, int salary) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("请输入员工信息,格式为：\n" + " name,age,gender,salary;name,age,gender,salary;....");
        String input = console.nextLine();
        ArrayList<Person> list = new ArrayList<>();
        String[] person = input.split(";");
        for(String data: person){
            String[] information = data.split(",");
            Person person1 = new Person(information[0], Integer.parseInt(information[1]), information[2], Integer.parseInt(information[3]));
            list.add(person1);
        }
        for (Person p: list) {
            System.out.println(p);
        }

    }
}
