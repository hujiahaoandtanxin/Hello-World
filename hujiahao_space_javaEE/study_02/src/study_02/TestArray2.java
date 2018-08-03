package study_02;


public class TestArray2 {
/**
 * 十进制转换为二进制
 * @param num
 */
	public static void toBin(int num ) {
		StringBuffer box=new StringBuffer();
		while (num>0) {
			box.append(num%2);
			num=num/2;
		}
		System.out.println(box.reverse());
	}
	public static void main(String[] args) {
		toBin(6);
		int array[]= {5,8,7,6};
		bubbleSort(array);
		
	}
	public static void compare(int a ,int b,int array[]) {
		
	}
	/**
	 * 冒泡排序
	 * @param array
	 */
	public static void bubbleSort(int array[]) {
		for(int a=0;a<array.length-1;a++) {
			for(int b=a+1;b<array.length;b++) {
				if(array[a]>array[b]) {
					int temp=array[a];
					array[a]=array[b];
					array[b]=temp;			
				}
				
			}
		}
		for (int i = 0; i < array.length; i++) {
			int j = array[i];
			System.out.print(j);
		}
	}
	
}
