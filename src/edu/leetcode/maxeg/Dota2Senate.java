package edu.leetcode.maxeg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static edu.leetcode.maxeg.utils.Utils.output;

public class Dota2Senate {

    private static String DIRE = "Dire";
    private static String RADIANT = "Radiant";
    public static void main(String[] args) {
        Dota2Senate dota = new Dota2Senate();
        output(dota.predictPartyVictory("RD"));
        output(dota.predictPartyVictory("RDD"));
    }

    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        Character votee = null;
        senate.chars().forEach(i -> queue.add(Character.highSurrogate(i)));
        while (!queue.isEmpty()) {
            if (votee == null) {
                votee = queue.poll();
            } else {

            }
        }
        if ('D' == queue.peek()) return DIRE;
        else return RADIANT;
    }
}
