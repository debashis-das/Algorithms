package deva.com.datastructure.test;

import java.util.*;

public class RuleContainer {
    private Map<Rule, String> ruleContainers = new HashMap();
    private Set<Rule> rules  = new HashSet();

    public RuleContainer() {
        addRule(i -> i % 25 == 0, "FizzBuzz");
        addRule(i -> i % 3 == 0, "Fizz");
        addRule(i -> i % 5 == 0, "Buzz");
    }

    public void addRule(Rule rule, String res) {
        rules.add(rule);
        ruleContainers.put(rule, res);
    }

    public String getValue(int i) {
        for (Rule rule : rules) {
            if (rule.apply123(i)) {
                return ruleContainers.get(rule);
            }
        }
        return String.valueOf(i);
    }

    //then the origin code should be as follows:
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        for(int i = 1; i <= n; i++){
            res.add(getValue(i));
        }
        return res;
    }
}
