
public class Regex_study {
	
	public static void main(String[] args) {
		regexQQ();
		split_01();
		replaceAll_01();emailRegex();
	}
	/**
	 * 验证QQ格式
	 */
	public static void regexQQ() {
		String QQ="12345600";
		//第一位数字是1到9，第二位开始有6个或者8个数字，0到9
		boolean matches = QQ.matches("[1-9][\\d]{6,8}");
		if(matches==true) {
			System.out.println("QQ格式正确");		
		}else {
			System.out.println("QQ格式有误");
		}
	}
	/**
	 * 切割字符串---使用正则规则
	 */
	public static void split_01() {
		String ip ="192.168...22.2525";
		String[] str = ip.split("\\.+");
		System.out.println(str);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	/**replaceAll方法
	 * 取代字符串
	 */
	public static void replaceAll_01() {
		String str="456wewe656";
		//字母换成任意多个1
		String newStr = str.replaceAll("[\\D+]", "1");
		System.out.println(newStr);
	}
	/**
	 * 邮箱格式验证
	 */
	public static void emailRegex() {
		String email="1@qq.com.cn";
		String emailRegex="\\w+@\\w+[\\.\\w]+";
		boolean b = email.matches(emailRegex);
		System.out.println(b);
	}
}	
