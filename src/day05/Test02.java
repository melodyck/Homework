package day05;

import java.util.Arrays;

/**
 * 创建一个栈，存入Integer类型元素1,2,3,4,5
 * 然后遍历队列并输出每个元素
 * @author Bonnie
 *
 */
public class Test02 {
    public static class Stack<E>{
        private Object[] stack;
        private int size;
        public Stack(int cap){
            stack = new Object[cap];//初始化栈数组
        }
        public void push(E data){
            stack[size++] = data;
        }
        public Object pop(){
            return stack[--size];
        }
        public void travel(){
            for (int i = 0; i < size; i++) {
                System.out.println(stack[i]);
            }
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "stack=" + Arrays.toString(stack) +
                    '}';
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.travel();
    }
}
