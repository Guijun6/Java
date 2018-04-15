//有10人围成圈数数，每次数到3的人退出其他人继续，问最后剩下的一个人原来的位置是多少

public class Test {
	public static void main(String[] args) {
		System.out.println(lastLive());
	}
	public static int lastLive() {
		int[] data = new int[10];
		for(int i = 0; i < data.length; i++) {
			data[i] = i;
		}
		int tmp = 1;
		int count = data.length;
		int i = 0;
		while(true) {
			if(count == 1) {
				return data[0];
			}
			if(tmp == 3) {
				for(int j = i; j < count-1; j++) {
					data[j] = data[j+1];
				}
				count--;
				tmp = 1;
			} else {
				i++;
				tmp++;
			}
			if(i == count) {
				i = 0;
			}
		}
	}
}
