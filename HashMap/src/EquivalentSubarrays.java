import java.util.*;

/*

    Problem Statement: Given an array of integers, we need to count the number of subarrays which contains all unique 
                       integers present in the input array.

    Observations:
        - First step should be to get the unique elements in the input array.
            - Brute force approach would to select each integer in the input array and check if there exist another 
              another integer equal to the one selected. 
                -> Nested Loop approach -> Time: O(n^2)
            - Another option is to use hashset -> Time: O(n)
        - The problem has boiled down to finding all subarrays which contain all the elements present in the hashset.
        - Lets assume we have a containsAllUniqueIntegers() function which checks if a subarray contains all integers
          present in the hashset.
            -> Time Complexity: O(T)
        - For any batch of subarrays starting from index i, we only need to find the first subarray (i,jf) which contains 
          all elements present in the hashset. All remaining subarrays (i, j>jf) will automatically contain all elements
          present in the hashset. -> Intelligent check
        - If subrray (i,j) is the first subarray, containing all elements present in the hashset, in the batch of 
          subarrays starting from index i, then we can say that all subarrays between (i, j-1) don't contain all unique
          elements. Therefore, for the next (i+1)th batch, we don't need to check subrrays between (i+1, j-1), i.e., we
          don't need to reset j at the start of each new batch. -> Intelligent check
        - Since, in every interation, we are acquiring or releasing some element and we need to maintain the count of 
          unique elements for each subarray under-consideration, the best data structure to use would be a frequency 
          HashMap.
                -> HashMap -> Acquire -> Time: O(1)
                -> HashMMap -> Release -> Time: O(1)
        - For any subarray, containsAllUniqueIntegers() can check if HashMap.size() == HashSet.size()
                -> if yes, the subarray under-consideration contains all unique integers of the input array.
                -> Time Complexity, O(T) = O(1) 

    Algorithms:
        - Brute Force approach: Iterate over each possible subarray and use containsAllUniqueIntegers() to check if the 
                                subarray under-consideration contains all integers present in the hashset.
                                
                                - Nested Loop Approach: Time Complexity: O(n^2*T)

        - Dynamic Sliding Window Approach: Iterate over the subarrays intelligently.
            
            1. Lets start from starting index i = 0 and find the count of subarrays starting from index i= 0 which returns
               containsAllUniqueIntegers() = true

                    A = [2,3,1,2,3], HS = [1,2,3] = 3 integers
                         0,1,2,3,4

                         (0,0), sub = [2] (acquired & containsAllUniqueIntegers()=false)
                         (0,1), sub = [2,3] (acquired & containsAllUniqueIntegers()=false)
                         (0,2), sub = [2,3,1] (acquired & containsAllUniqueIntegers()=true), ans = 3

            2. If we have found the first subarray (i,j) for batch starting from index i, we have to increase the ans
               by (n-j) and increment i to find the first subarray in the next batch of subrrays starting from index (i+1)

                         (1,2), sub = [3,1] (released & containsAllUniqueIntegers()=false)
                         (1,3), sub = [3,1,2] (acquired & containsAllUniqueIntegers()=true), ans = 5
                         (2,3), sub = [1,2] (released & containsAllUniqueIntegers()=false)
                         (2,4), sub = [1,2,3] (acquired & containsAllUniqueIntegers()=true), ans = 6
                         (3,4), sub = [2,3] (released & containsAllUniqueIntegers()=false)
                         (3,5) -> j>arr.length -> termination condition

            - Time Complexity: O(n*Acquire_Time) + O(nT) + O(m*Release)

            - Overall Time Comlexity: O(n) + O(n) + O(m) ~ O(n)
                            
*/

public class EquivalentSubarrays {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		//write your code here
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            hs.add(arr[i]);
        }

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0;

        for(int j=0; j<n; j++){

            if(map.size()!=hs.size()){

                int add_key = arr[j];
                map.put(add_key, map.getOrDefault(add_key,0)+1);

                // since we need to maintain same j for release operations, we can run a while loop for i inside the j loop
                while(map.size()==hs.size()){

                    count += (n-j);

                    int remove_key = arr[i];
                    int freq = map.get(remove_key);
                    if (freq==1) {
                        map.remove(remove_key);
                    } else {
                        map.put(remove_key, freq-1);
                    }

                    i++;

                }

            }

        }

        System.out.println(count);
        
        scn.close();
		
	}

}
