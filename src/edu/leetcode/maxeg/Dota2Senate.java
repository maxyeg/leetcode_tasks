package edu.leetcode.maxeg;

import java.util.LinkedList;
import java.util.Queue;

import static edu.leetcode.maxeg.utils.Utils.output;

public class Dota2Senate {

    public static void main(String[] args) {
        Dota2Senate dota = new Dota2Senate();
        output(dota.predictPartyVictory("RD"));
        output(dota.predictPartyVictory("RDD"));
        output(dota.predictPartyVictory("RDDDRDRRDR"));
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>(),d =new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'D') {
                d.add(i);
            } else {
                r.add(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            if (r.peek() < d.peek()) {
                r.add(n++);
            } else {
                d.add(n++);
            }
            r.poll();
            d.poll();
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
