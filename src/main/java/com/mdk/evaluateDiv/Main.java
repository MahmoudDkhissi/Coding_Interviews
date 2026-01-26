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



    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while(i<=j) {
            if(nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                }
                else {
                    k++;
                    nums[i] = nums[j];
                    nums[j] = val;
                    i++;
                    j--;
                }
            }
            else {
                k++;
                i++;
            }
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        while(j<n) {
            if (nums[i] == nums[j]) {
                j++;
            }
            else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public int majorityElementMoyerBoore(int[] nums) {
        int counter = 0;
        int majority = nums[0];
        for (int num : nums) {
            if (counter == 0) {
                majority = num;
                counter = 1;
            }
            else if (num == majority) {
                counter++;
            }
            else {
                counter--;
            }
        }
        return majority;
    }


        //other version different from boyer-moore majority vote algorithm
    public int majorityElement(int[] nums) {
        int n = nums.length/2;
        Map<Integer, Integer>  map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > n) {
                    return num;
                }
            }
            else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }


    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int current = map.get(s.charAt(i));
            if (i+1 < n && current < map.get(s.charAt(i+1))) {
                result-=current;
            }
            else {
                result+=current;
            }
        }
        return result;
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            if (elements.contains(num)) {
                return true;
            }
            else {
                elements.add(num);
            }
        }
        return false;
    }

    /**
     * Determines whether two strings are anagrams of each other.
     * An anagram is a word or phrase formed by rearranging the letters of another,
     * using all the original letters exactly once.
     *
     * @param s the first string to be compared
     * @param t the second string to be compared
     * @return {@code true} if the two strings are anagrams, {@code false} otherwise
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map_t.put(t.charAt(i), map_t.getOrDefault(t.charAt(i), 0) + 1);
        }
        return map_s.equals(map_t);
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