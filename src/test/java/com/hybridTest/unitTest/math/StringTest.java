package com.hybridTest.unitTest.math;

import org.testng.annotations.Test;

public class StringTest {
    @Test

    public void reverseStringTest(){
        char[] s = {'h', '1', '2', '3'};
        System.out.print("The original string: ");
        System.out.println(s);
        reverseString(s);
        System.out.print("The reversed string: ");
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        char temp;
        for(int i = 0, j = s.length - 1; i < s.length/2 ; i++, j--){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
