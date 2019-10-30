package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class openLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int index = 0;
        //BSF
        while (!queue.isEmpty()){
            int size = queue.size();

            while (size > 0){
                String s = queue.poll();

                if (dead.contains(s)){
                    size--;
                    continue;
                }

                if (s.equals(target)){
                    return index;
                }

                for (int i = 0; i < 4; i++) {
                    char c = s.charAt(i);
                    //增
                    String s1 = s.substring(0,i) + (c=='9'?0:c-'0'+1) + s.substring(i+1);
                    //减
                    String s2 = s.substring(0,i) + (c=='0'?9:c-'0'-1) + s.substring(i+1);
                    if (!visited.contains(s1) && !dead.contains(s1)){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !dead.contains(s2)){
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
        index++;
        }
        return -1;
    }
}
