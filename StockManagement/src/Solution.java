import java.util.Arrays;

class Solution {

	public static void main(String[] A) {
		int[] aa = new int[] { 2 };
		System.out.println(solution(aa));
	}

	public static int solution(int[] A) {
		int result = 0;
		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i++) {
			if(A[i]<=0 && A[i+1]>1){
				result=1;
				break;
			}
			if (A[i] == A[i + 1] || ((A[i] + 1) == A[i + 1])) {
				continue;
			} else {
				if (A[i] >= 0) {
					result = (A[i] + 1);
					break;
				} else if (A[i + 1] <= 0 && i == A.length - 1) {
					result = (1);
					break;
				}
			}
		}
		if (result == 0) {
			if (A[A.length - 1] <= 0) {
				result = (1);

			} else {
				if(A.length==1 && A[A.length - 1]>1){
					result=1;
				}else{
					result = (A[A.length - 1] + 1);
				}
			}
		}
		return result;
	}
}