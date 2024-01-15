package edu.leetcode.maxeg.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static edu.leetcode.maxeg.utils.Utils.output;

public class KeysAndRooms {
    public static void main(String[] args) {
        KeysAndRooms kar = new KeysAndRooms();
        output(kar.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        output(kar.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0))));
        output(kar.canVisitAllRooms(List.of(List.of(1,3), List.of(), List.of(1), List.of(2))));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>(Set.of(0));
        Set<Integer> visited = new HashSet<>();
        return visit(keys, visited, rooms);
    }

    private boolean visit(Set<Integer> keys, Set<Integer> visited, List<List<Integer>> rooms) {
        if (visited.size() == rooms.size()) return true;
        if (keys.isEmpty()) return false;
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            visited.add(key);
            it.remove();
            keys.addAll(rooms.get(key).stream().filter(x -> !visited.contains(x)).toList());
            return visit(keys, visited, rooms);
        }
        return false;
    }
}
