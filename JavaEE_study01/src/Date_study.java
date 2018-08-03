import java.util.Date;
import java.util.HashMap;

public class Date_study {
	/**
	 *	java时间原点，公元1970年1月1日 00：00：00 毫秒值是0
	 * @param args
	 */
	public static void main(String[] args) {
		//当前时间---以毫秒算的
		long currentTimeMillis = System.currentTimeMillis();
		//该构造方法是获取当前的时间
		Date date =new Date();
		/*System.out.println(date);
		System.out.println(currentTimeMillis);*/
		HashMap hashMap=new HashMap();
		//返回一个字节数
		int str = getStr("ss");
		System.out.println(str);
	}
	private static int getStr(String str) {
		return str.length()*2;
		
	} 
}
