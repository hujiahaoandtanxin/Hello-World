/**
 * µÚÈıÕÂ
 * Á·Ï°ËÄ
 * @author SYC
 *
 */
public class VelocityTest {
	public static void main(String[] args) {
		float d=500.63f;
		float t=4.43f;
		float v = CalculateVelocity.velocity(d, t);
		System.out.println("distance="+d);
		System.out.println("time="+t);
		System.out.println("velocity="+v);
	}
	
}
	class CalculateVelocity{
		static float velocity(float d,float t) {
			if(t==0) {
				return 0;
			}else {
				return d/t;
			}
		}
	}
