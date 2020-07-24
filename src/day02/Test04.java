package day02;
/**
 * 将字符串"123abc456def789ghi"中的英文部分替换为"#char#"
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        String s = "123abc456def789ghi";
        String regex = "[a-zA-Z]+";//连续的多个英文字母:[a-zA-Z]+
        String sChange = s.replaceAll(regex, "#char#");//
        System.out.println(sChange);
    }
}
