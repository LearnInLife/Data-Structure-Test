package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(12);
        ArrayList list = new ArrayList();
        Set set = new HashSet();
        set.size();
        String str = "abs";

//        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(minAddToMakeValid("((("));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set set = new HashSet();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<word.length();i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<S.length();i++) {
            Character c = S.charAt(i);
            if ('(' == c) {
                stack.push(c);
            } else if (')' == c) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    Character peek = stack.peek();
                    if ('(' == peek) {
                        stack.pop();
                    } else if (')' == peek){
                        stack.push(c);
                    }
                }
            }
        }
        return stack.size();
    }
}
