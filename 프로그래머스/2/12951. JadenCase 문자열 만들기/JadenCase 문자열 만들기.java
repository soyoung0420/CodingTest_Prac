import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
         String[] words = s.toLowerCase().split(" ", -1);
         StringBuilder sb = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        if (word.length() == 0) {
            sb.append("");
        } else {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
        }

        if (i < words.length - 1) {
            sb.append(" ");
        }
    }

        return sb.toString();
    }
}