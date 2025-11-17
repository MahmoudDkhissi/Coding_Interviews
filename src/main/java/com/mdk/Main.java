package com.mdk;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>(new ArrayList<>());
        List<Double> values = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        Map<String,String> parents = new HashMap<>();
        Map<String,Double> weights = new HashMap<>();

        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        values.add(2.0);
        values.add(3.0);
        queries.add(Arrays.asList("a","c"));

        EvaluateDivision evaluateDivision = new EvaluateDivision(equations, values, queries, parents, weights);

        List<Double> results = evaluateDivision.getDivisions();

        System.out.println(results);
    }
}