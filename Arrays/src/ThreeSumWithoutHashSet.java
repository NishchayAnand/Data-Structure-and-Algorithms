import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumWithoutHashSet {
	
	public List<List<Integer>> threeSumCleansed2(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int i = 0;
        while(i<nums.length-2){
            
            int j = i + 1;
            int k = nums.length-1;
            int localTarget = 0 - nums[i];
            
            while(j<k){
            	
            	int pairSum = nums[j]+nums[k];
            	
            	if(pairSum == localTarget) {
            		ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
            	}
            	
            	// same while loop has to be run for pairSum < localTarget and pairSum = localTarget. 
            	while(pairSum<=localTarget && nums[j]==nums[++j] && j<k);
            	
            	// same while loop has to be run for pairSum > localTarget and pairSum = localTarget. 
            	while(pairSum>=localTarget && nums[k]==nums[--k] && k>j);  
                 
            }
                       
            while(nums[i]==nums[++i] && i<nums.length-2);
            
        }
        
        return ans;
        
    }
	
	public List<List<Integer>> threeSumCleansed1(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int i = 0;
        while(i<nums.length-2){
            
            int j = i + 1;
            int k = nums.length-1;
            int localTarget = 0 - nums[i];
            
            while(j<k){
                if(nums[j]+nums[k]<localTarget){                	
                    while(nums[j]==nums[++j] && j<k);                     
                } else if(nums[j]+nums[k]>localTarget){               	             
                    while(nums[k]==nums[--k] && k>j);                   
                } else {                	
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);                    
                    while(nums[j]==nums[++j] && j<k);  
                    while(nums[k]==nums[--k] && k>j);                                      
                }
            }
                       
            while(nums[i]==nums[++i] && i<nums.length-2);
            
        }
        
        return ans;
        
    }
	
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int i = 0;
        while(i<nums.length-2){
            
            int j = i + 1;
            int k = nums.length-1;
            int localTarget = 0 - nums[i];
            
            while(j<k){
            	
            	// pair sum is less than the target sum.
                if(nums[j]+nums[k]<localTarget){
                	
                    j++;
                    // to make sure we are not considering the duplicate element.
                    while(nums[j]==nums[j-1] && j<k){ // j<k is required to make sure we do not go out of the bounds of the array from right hand side.
                        j++;
                    }
                    
                 // pair sum is greater than the target sum.    
                } else if(nums[j]+nums[k]>localTarget){
                	
                    k--;
                    // to make sure we are not considering the duplicate element.
                    while(nums[k]==nums[k+1] && k>j){ // j<k is required to make sure we do not go out of the bounds of the array from left hand side.
                        k--;
                    }
                    
                 // pair sum is greater than the target sum.   
                } else {
                	
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
                    
                    j++;
                    k--;
                    
                    // to make sure we are not considering the duplicate elements.
                    while(nums[j]==nums[j-1] && j<k){
                        j++;
                    }
                    while(nums[k]==nums[k+1] && k>j){
                        k--;
                    }
                    
                }
            }
            
            // to make sure we are not doing same work of finding nums[j], nums[k] pair for duplicate nums[i].
            i++;
            while(nums[i]==nums[i-1] && i<nums.length-2){
                i++;
            }
            
        }
        
        return ans;
        
    }
    
}