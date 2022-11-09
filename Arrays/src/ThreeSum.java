import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> finalAns = new ArrayList<>();
        
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        
        for(int i=0; i<nums.length-2; i++){
            
            int j = i + 1;
            int k = nums.length-1;
            int localTarget = 0 - nums[i];
            
            while(j<k){
                if(nums[j]+nums[k]<localTarget){
                    j++;
                } else if(nums[j]+nums[k]>localTarget){
                    k--;
                } else {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    // HashSet will use the equals of ArrayList class to compare the elements. The equals method of ArrayList is already overridden to compare two arraylists element-wise rather than just comparing their addresses.
                    ans.add(triplet);
                    j++;
                    k--;
                }
            }
            
        }
        
        for(ArrayList<Integer> triplet: ans){
            finalAns.add(triplet);
        }
        
        return finalAns;
        
    }
}