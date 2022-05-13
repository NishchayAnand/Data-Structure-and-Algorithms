
public class SubArrayMaxSum {
	
	public static int getMaxSubArraySum(int[] arr) {
		
		int maxSum = 0;
		
		for(int start=0;start<arr.length; start++) {
			int subArraySum = 0;
			for(int index=start; index<arr.length;index++) {
				subArraySum+=arr[index];
				if(subArraySum > maxSum) {
					maxSum = subArraySum;
				}				
			}				
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,-2,3};
		System.out.println(getMaxSubArraySum(arr));
		
	}

}
