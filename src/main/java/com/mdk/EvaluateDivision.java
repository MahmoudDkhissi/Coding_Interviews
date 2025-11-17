package com.mdk;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class EvaluateDivision {

    private List<List<String>> equations;
    private List<Double> values;
    private List<List<String>> queries;

    private Map<String,String> parents;
    private Map<String,Double> weights;

    protected String find(String x) {
        if (!parents.get(x).equals(x)) {
            String parent = parents.get(x);
            parents.put(x,find(parent));
            weights.put(x,weights.get(x)*weights.get(parent));
        }
        return parents.get(x);
    }

    protected void DSU() {
        for (List<String> equation : equations) {
            String a = equation.get(0);
            String b = equation.get(1);
            parents.put(a, a);
            parents.put(b, b);
            weights.put(a, 1.0);
            weights.put(b, 1.0);
        }
        for (int i = 0; i < values.size(); i++) {
            Double value = values.get(i);
            List<String> couple = equations.get(i);
            String a = couple.get(0);
            String b = couple.get(1);
            String pa = find(a);
            String pb = find(b);
            if (pa.equals(pb)) {
                continue;
            }
            parents.put(pa,pb);
            weights.put(pa,weights.get(b)*value/weights.get(a));
        }
        System.out.println(parents);
        System.out.println(weights);
    }

    protected List<Double> getDivisions() {
        List<Double> divisions = new ArrayList<>();
        DSU();
        for (List<String> query : queries) {
            if (!parents.containsKey(query.get(0)) || !parents.containsKey(query.get(1))) {
                divisions.add(-1.0);
            } else if (!find(query.get(0)).equals(find(query.get(1)))) {
                divisions.add(-1.0);
            }
            else {
                divisions.add(weights.get(query.get(0))/weights.get(query.get(1)));
            }
        }
        return divisions;
    }
}
