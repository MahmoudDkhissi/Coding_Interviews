package com.mdk.maxBombs;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class MaxBombs {

    private List<List<Integer>> bombs;

    protected Map<Integer, List<Integer>> initialize() {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < bombs.size()-1; i++) {
            List<Integer> bombi = bombs.get(i);
            for (int j = i+1; j < bombs.size(); j++) {
                List<Integer> bombj = bombs.get(j);
                double distance = Math.sqrt((bombi.get(0)-bombj.get(0))^2 + (bombi.get(1)-bombj.get(1))^2);
                if (distance < bombi.get(2)) {
                    graph.computeIfAbsent(i, k-> new ArrayList<>()).add(j);
                }
                if (distance < bombj.get(2)) {
                    graph.computeIfAbsent(j, k-> new ArrayList<>()).add(i);
                }
            }
        }
        return graph;
    }

    protected int dfsMaxBombs() {
        int maxDetonations = 0;
        Map<Integer, List<Integer>> graph = initialize();
        for(Integer bomb: graph.keySet()) {
            int detonations = 0;
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> visited = new ArrayList<>();
            queue.offer(bomb);
            visited.add(bomb);
            while (!queue.isEmpty()) {
                for (int j : graph.get(queue.poll())) {
                    detonations++;
                    if (!visited.contains(j)) {
                        queue.offer(j);
                        visited.add(j);
                    }
                }
            }
            maxDetonations = Math.max(maxDetonations, detonations);
        }
        return maxDetonations;
    }
}
