package day01;

import java.util.Random;
import java.util.Scanner;

/**
 * 随机生成一个5位的英文字母验证码(大小写混搭)
 * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
 * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
 * @author Bonnie
 *
 */
public class Test05 {
	public static void main(String[] args) {
/*		System.out.println((int)'A');
		System.out.println((int)'a');*/
		Scanner console = new Scanner(System.in);
		Random random = new Random();
		String identifyingCode = "";
		//产生五位随机验证码
		for(int i = 0; i < 5; i++){
			int r = random.nextInt(2);
			if(r == 0){
				identifyingCode += (char)(random.nextInt(26) + 65);
			}
			else {
				identifyingCode += (char)(random.nextInt(26) + 97);
			}
		}
		System.out.println(identifyingCode);
		System.out.println("请输入验证码:");
		String input = console.next();
		if(identifyingCode.equalsIgnoreCase(input)){
			System.out.println("验证码正确");
		}
		else{
			System.out.println("验证码错误");
		}
	}
}
