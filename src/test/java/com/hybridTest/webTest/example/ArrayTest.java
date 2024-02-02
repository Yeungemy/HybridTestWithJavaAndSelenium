package com.hybridTest.webTest.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayTest {
    @Test

    public void testRemoveDuplicates() {
        int[] numbers = {1, 1, 2, 2, 3, 4, 5, 5, 6, 6};
        Arrays.sort(numbers);
        int result = removeDuplicates(numbers);

        // Print the results individually or in any desired format
        System.out.println("Total number of element is: " + result);
        Assert.assertEquals(result, 6);
    }

    public int removeDuplicates(int[] nums) {
        int k = 0;

        for(int num : nums){
            if(k == 0 || num != nums[k - 1]){
                nums[k++] = num;
            }
        }
        return k;
    }
}
