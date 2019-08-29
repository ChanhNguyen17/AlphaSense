package com.alphasense;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Test
    void longestSubstringWithoutRepeating() {
        assertEquals(0, Functions.longestSubstringWithoutRepeating(""));
        assertEquals(1, Functions.longestSubstringWithoutRepeating("z"));
        assertEquals(3, Functions.longestSubstringWithoutRepeating("abcabcbb"));
        assertEquals(1, Functions.longestSubstringWithoutRepeating("bbbbb"));
        assertEquals(3, Functions.longestSubstringWithoutRepeating("pwwkew"));
        assertEquals(9, Functions.longestSubstringWithoutRepeating("AlphaSense is awesome"));
    }

    @Test
    void findSubarrayGivenSum() {
        assertFalse(Functions.findSubarrayGivenSum(new int[]{}, 0));
        assertTrue(Functions.findSubarrayGivenSum(new int[]{9}, 9));
        assertTrue(Functions.findSubarrayGivenSum(new int[]{1,2,3,4}, 7));
        assertFalse(Functions.findSubarrayGivenSum(new int[]{1,2,3,3}, 7));
        assertTrue(Functions.findSubarrayGivenSum(new int[]{1,2,3,3,7}, 7));
    }
}