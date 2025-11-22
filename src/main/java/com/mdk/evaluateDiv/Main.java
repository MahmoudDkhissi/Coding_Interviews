package com.mdk.evaluateDiv;

import java.util.*;


public class Main {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int reste = target - nums[i];
            if(map.containsKey(reste)) {
                result[0] = map.get(reste);
                result[1] = i;
                return result;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return result;
    }



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