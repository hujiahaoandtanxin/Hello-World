import java.util.Random;

public class RandMath {
	public static void main(String[] args) {
		Random rand =new Random();
		Random rand1 =new Random(2);
		System.out.println(rand.nextInt());
		System.out.println(rand1.nextInt());
		System.out.println(rand.nextFloat());
	}
}
