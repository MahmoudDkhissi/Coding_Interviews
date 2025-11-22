package com.mdk.loudAndRich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudAndRich {

    // Graph adjacency list where g[i] contains all people richer than person i
    private List<Integer>[] graph;
    // Total number of people
    private int numberOfPeople;
    // Array storing quietness values for each person
    private int[] quietnessValues;
    // Array storing the answer - quietest person among all richer or equally rich people
    private int[] result;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // Initialize instance variables
        numberOfPeople = quiet.length;
        this.quietnessValues = quiet;
        graph = new List[numberOfPeople];
        result = new int[numberOfPeople];

        // Initialize result array with -1 to indicate unvisited nodes
        Arrays.fill(result, -1);

        // Initialize adjacency list for each person
        Arrays.setAll(graph, index -> new ArrayList<>());

        // Build the graph: if person a is richer than person b (richer[i] = [a, b])
        // then add a to the adjacency list of b
        for (int[] richRelation : richer) {
            int richerPerson = richRelation[0];
            int poorerPerson = richRelation[1];
            graph[poorerPerson].add(richerPerson);
        }

        // Perform DFS for each person to find their quietest richer person
        for (int person = 0; person < numberOfPeople; person++) {
            dfs(person);
        }

        return result;
    }

    /**
     * Depth-first search to find the quietest person among all people
     * who are richer than or equal to person i
     * @param currentPerson the person we're currently processing
     */
    private void dfs(int currentPerson) {
        // If already computed, return early (memoization)
        if (result[currentPerson] != -1) {
            return;
        }

        // Initially, the quietest person is the current person themselves
        result[currentPerson] = currentPerson;

        // Explore all people richer than the current person
        for (int richerPerson : graph[currentPerson]) {
            // Recursively compute the quietest person for the richer person
            dfs(richerPerson);

            // Update if we found a quieter person through the richer person's network
            if (quietnessValues[result[richerPerson]] < quietnessValues[result[currentPerson]]) {
                result[currentPerson] = result[richerPerson];
            }
        }
    }
}
