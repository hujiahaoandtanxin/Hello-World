/**
 * 第三章
 * 练习5,6
 * 验证equal默认比较引用的
 * @author SYC
 *
 */
public class EqualTest {
	
	public static void main(String[] args) {
		Dog dog1 =new Dog();
		dog1.name="spot";
		dog1.says="Ruff!";
		Dog dog2=new Dog();
		dog2.name="scruffy";
		dog2.says="Wurf!";
		System.out.println(dog1.equals(dog2));
		dog1.name=dog2.name="spot";
		dog1.says=dog2.says="Ruff!";
		System.out.println(dog1.equals(dog2));
	}
}
class Dog{
	static String name;
	static String says;
}
