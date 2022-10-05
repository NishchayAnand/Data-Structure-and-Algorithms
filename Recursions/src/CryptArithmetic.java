import java.io.*;
import java.util.*;

/* Problem Statement: Given 3 strings, we need to map each character of the 3 input strings such 
 * 					  that S1 + S2 = S3.
 * 
 * 					  Sample: T(0) E(9) A(3) M(4)
 * 								   P(2) E(9) P(2)
 * 						------------------------------
 * 					     T(0) O(1) P(2) P(2) R(6)
 * 						------------------------------
 * 
 * General Observations:
 * 	- Since, we need to find the different ways of mapping the unique characters in the 3 input 
 * 	  strings, we can use a recursive approach to solve the problem.
 * 	- We can transverse over the unique characters recursively and try to map each character to 
 * 	  all 0-9 digits one at a time, whichever hasn't been mapped before.
 * 	- In the base condition, we will be getting a unique mapping. We basically need to check if 
 * 	  the mapping could be a possible solution.
 * 	- We will need to create a hashmap that will store the mapping. Also create a string that will 
 *    contain all unique elements of S1, S2 and S3.
 *    
 *
 *	Extra Note: Its better to always dry run on some of the sample outputs to get an idea what the 
 * 				problem is trying to convey.
 * 
 * */



public class CryptArithmetic {

  public static void main(String[] args) {
      
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    
    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    
    scn.close();
    
  }
  
  public static boolean isValidSolution(String s1, String s2, String s3, HashMap<Character, Integer> hm){
	  
	  int carry=0;
	  int i = s1.length()-1;
	  int j = s2.length()-1;
	  int k = s3.length()-1;
	  
	  while(i>=0 && j>=0) {
		  
		  int d1 = hm.get(s1.charAt(i));
		  int d2 = hm.get(s2.charAt(j));
		  int d3 = hm.get(s3.charAt(k));
		  
		  int temp = d1+d2+carry;
		  int rem = temp%10;
		  carry = temp/10;
		  		  
		  if(rem!=d3) {
			  return false;
		  }
		  
		  i--;
		  j--;
		  k--;
		  
	  }
	  
	  while(i>=0) {
		  int d1 = hm.get(s1.charAt(i));
		  int d3 = hm.get(s3.charAt(k));
		  
		  int temp = d1 + carry;
		  carry = 0;
		  if(temp!=d3) {
			  return false;
		  }
		  
		  i--;
		  k--;
	  }
	  
	  while(j>=0) {
		  int d2 = hm.get(s2.charAt(j));
		  int d3 = hm.get(s3.charAt(k));
		  
		  int temp = d2 + carry;
		  if(temp!=d3) {
			  return false;
		  }
		  
		  carry = 0;
		  j--;
		  k--;
	  }
	  
	  if(k==0) {
		  int d3 = hm.get(s3.charAt(k));
		  if(carry!=d3) {
			  return false;
		  }
	  }
	  
	  return true;
	  
  }

  
  public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, 
		  boolean[] usedNumbers, String s1, String s2, String s3) {
	      
	  	// base condition:
      if(idx == unique.length()){
    	  
          if(isValidSolution(s1, s2, s3, charIntMap)){
        	  
        	  char[] arr = unique.toCharArray();
        	  Arrays.sort(arr);	 
        	  
              for(int i=0; i<arr.length; i++){
                  char ch = arr[i];
                  System.out.print(ch+"-"+charIntMap.get(ch)+" ");
              }
              System.out.println();	  
              
          }	 
          
          return;
          
      }
      
      for(int dig = 0; dig<10; dig++){
    	  
          if(!usedNumbers[dig]){
	          charIntMap.put(unique.charAt(idx), dig);
	          usedNumbers[dig] = true;
	          solution(unique, idx+1, charIntMap, usedNumbers, s1, s2, s3);
	          usedNumbers[dig] = false;	              
          }
          
      }
	      
  }

}
