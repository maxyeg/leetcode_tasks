package edu.leetcode.maxeg.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BigInput {

    public static final List<Integer> POTIONS_LIST = new LinkedList<>();
    public static final List<Integer> SPELLS_LIST = new LinkedList<>();
    static {
        URL url = BigInput.class.getResource("/potions.txt");
        File file = new File(url.getPath());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                POTIONS_LIST.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        url = BigInput.class.getResource("/spells.txt");
        file = new File(url.getPath());
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                SPELLS_LIST.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
    }
    public static final int[] POTIONS = new int[POTIONS_LIST.size()];
    public static final int[] SPELLS = new int[SPELLS_LIST.size()];
    static {
        Arrays.setAll(POTIONS, POTIONS_LIST::get);
        Arrays.setAll(SPELLS, SPELLS_LIST::get);
    }
}
