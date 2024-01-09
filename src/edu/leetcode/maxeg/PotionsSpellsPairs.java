package edu.leetcode.maxeg;

import edu.leetcode.maxeg.utils.BigInput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static edu.leetcode.maxeg.utils.Utils.output;

public class PotionsSpellsPairs {
    public static void main(String[] args) {
        PotionsSpellsPairs psp = new PotionsSpellsPairs();
        output(psp.successfulPairs(BigInput.SPELLS, BigInput.POTIONS, 10000000000L));
        output(psp.successfulPairs(new int[]{15,8,19}, new int[]{38,36,23}, 328));
        output(psp.successfulPairs(new int[]{14}, new int[]{25,19,30,37,14,30,38,22,38,38,26,33,34,23,40,28,15,29,36,39,39,37,32,38,8,17,39,20,4,39,39,7,30,35,29,23}, 317));
        output(psp.successfulPairs(new int[]{5,1,3}, new int[]{5,3,1,2,4}, 7));
        output(psp.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        Map<Integer, Integer> computed = new HashMap<>();
        for (int i = 0; i < spells.length; i++) {
            if (computed.containsKey(spells[i])) {
                result[i] = computed.get(spells[i]);
                continue;
            }
            int l = 0, r = potions.length, m = (l + r) / 2;
            long val = (long) Math.ceil((double) success / spells[i]);
            boolean found = false;
            while (l < r) {
                if (potions[m] == val) {
                    found = true;
                    break;
                }
                if (potions[m] < val) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                m = (l + r) / 2;
            }
            if (found) {
                long tmp = spells[i];
                while (m > 0 && potions[m - 1] * tmp >= success) {
                    m--;
                }
            } else {
                if (m < potions.length) {
                    if ((long)potions[m] * (long)spells[i] < success) {
                        m++;
                    }
                }
            }
            result[i] = potions.length - m;
            computed.put(spells[i], result[i]);
        }
        return result;
    }
}
