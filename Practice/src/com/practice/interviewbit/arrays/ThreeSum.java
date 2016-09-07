package com.practice.interviewbit.arrays;

public class ThreeSum {

	public static void main(String[] args) {
		int[] a = {1,3,4,6,9,12};
		int[] r = checkThreeSum(a, 17);
		
		if(r != null)
			System.out.println(a[r[0]]+","+a[r[1]]+","+a[r[2]]);
		else{
			System.out.println("No match");
		}
	}
	
	
	public static int[] checkThreeSum(int[] a, int sum){
		
		int[] result = new int[3];
		int i1=0, i2=0, i3=0;
		boolean matchFound = false;
		
		outer:
		for(int i=0; i < a.length-2; i++){
			i1=i;
			i2=i+1;
			i3=i+2;
			int currSum = a[i1] + a[i2] + a[i3];
			
			if(currSum == sum){
				matchFound=true;
				break;
			}
			
			if(currSum < sum)
				continue;
			
			int index = i;
			while(currSum > sum && index>0){
				index--;
				currSum = a[i1] + a[index] + a[i3];
				result[0]=index;
				result[1]=i1;
				result[2]=i3;
				if(currSum < sum){
					currSum = a[index] + a[i2] + a[i3];
					result[0]=index;
					result[1]=i2;
					result[2]=i3;
				}
				
				if(currSum == sum){
					matchFound=true;
					break outer;
				}
			}
		}
		
		if(matchFound){
			return result;
		} else{
			return null;
		}
	}

}
