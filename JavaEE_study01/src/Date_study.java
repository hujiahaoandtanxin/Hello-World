import java.util.Date;
import java.util.HashMap;

public class Date_study {
	/**
	 *	javaʱ��ԭ�㣬��Ԫ1970��1��1�� 00��00��00 ����ֵ��0
	 * @param args
	 */
	public static void main(String[] args) {
		//��ǰʱ��---�Ժ������
		long currentTimeMillis = System.currentTimeMillis();
		//�ù��췽���ǻ�ȡ��ǰ��ʱ��
		Date date =new Date();
		/*System.out.println(date);
		System.out.println(currentTimeMillis);*/
		HashMap hashMap=new HashMap();
		//����һ���ֽ���
		int str = getStr("ss");
		System.out.println(str);
	}
	private static int getStr(String str) {
		return str.length()*2;
		
	} 
}
