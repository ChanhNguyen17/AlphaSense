package com.alphasense;

import java.util.HashMap;
import java.util.Map;

class Functions {

    static int longestSubstringWithoutRepeating(String str){
        // Create HashMap for vsited characters
        Map<Character, Integer> visitedChar = new HashMap<>();
        // Initialize result
        int result = 0;
        for(int start = 0, end = 0; end < str.length(); end++){
            // Check current character
            char c = str.charAt(end);
            if(visitedChar.containsKey(c)){
                // Set start if the character is repeated and has a later index than start
                start = Math.max(visitedChar.get(c) + 1, start);
            }
            // Update result
            result = Math.max(result, end - start + 1);
            // Put character to visited Map
            visitedChar.put(c, end);
        }
        return result;
    }

    static boolean findSubarrayGivenSum(int[] nums, int target) {
        // Initialize sum and start
        int sum = 0, start = 0;
        for (int num : nums) {
            // Go through array and add number to sum
            sum += num;
            while (sum >= target) {
                // Return true if sum == target
                if(sum == target) return true;
                // If sum is greater than target, remove numbers from the head
                sum -= nums[start];
                start++;
            }
        }
        // Return false when we went through array
        return false;
    }
}
