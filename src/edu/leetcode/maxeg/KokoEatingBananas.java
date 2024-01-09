package edu.leetcode.maxeg;

import java.util.Arrays;

import static edu.leetcode.maxeg.utils.Utils.output;

public class KokoEatingBananas {
    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();
        output(keb.minEatingSpeed(new int[]{1000000000,1000000000}, 3));
        output(keb.minEatingSpeed(new int[]{312884470}, 312884469));
        output(keb.minEatingSpeed(new int[]{3,6,7,11}, 8));
        output(keb.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        output(keb.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        output(keb.minEatingSpeed(new int[]{30,21,22,22,20}, 6));
        output(keb.minEatingSpeed(new int[]{873375536,395271806,617254718,970525912,634754347,824202576,694181619,20191396,886462834,442389139,572655464,438946009,791566709,776244944,694340852,419438893,784015530,588954527,282060288,269101141,499386849,846936808,92389214,385055341,56742915,803341674,837907634,728867715,20958651,167651719,345626668,701905050,932332403,572486583,603363649,967330688,484233747,859566856,446838995,375409782,220949961,72860128,998899684,615754807,383344277,36322529,154308670,335291837,927055440,28020467,558059248,999492426,991026255,30205761,884639109,61689648,742973721,395173120,38459914,705636911,30019578,968014413,126489328,738983100,793184186,871576545,768870427,955396670,328003949,786890382,450361695,994581348,158169007,309034664,388541713,142633427,390169457,161995664,906356894,379954831,448138536}, 943223529));
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 0, r = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > r) {
                r = piles[i];
            }
        }
        if (h == piles.length) return r;
        int m = 0;
        int lastKnown = 0;
        while (l < r) {
            m = (l + r) / 2;
            int count = count(piles, m);
            if (count > h) {
                l = m + 1;
            } else if (count < h) {
                r = m - 1;
                lastKnown = m;
            } else {
                //move left
                while (m > 0 && count(piles, m - 1) <= h) {
                    m--;
                }
                return m;
            }
        }
        int a = count(piles, l);
        int b = count(piles, lastKnown);
        return (lastKnown == 0 || (a <= h && a > b)) ? l : lastKnown;
    }

    private int count(int[] piles, int m) {
        int result = 0;
        for (int i = 0; i < piles.length; i++) {
            result += Math.ceil((double) piles[i] / m);
        }
        return result;
    }
}
