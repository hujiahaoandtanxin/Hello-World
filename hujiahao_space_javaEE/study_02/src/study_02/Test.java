package study_02;

public class Test {
	public static void testArray() {
		int sum=0;
		int [][]array= {{1,5,6},{2,4,5},{4,5,8}};
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum+=array[i][j];
			}
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		testArray();
	}
}
