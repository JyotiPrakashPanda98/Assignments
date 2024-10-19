package com.ruleengine;

import java.util.HashMap;
import java.util.Map;

public class RuleEngineTest {

    public static void main(String[] args) {
        RuleParser parser = new RuleParser();

        // Create individual rules
        Node rule1 = parser.createRule("age > 30 AND department = 'Sales'");
        Node rule2 = parser.createRule("salary > 50000 OR experience > 5");

        // Check if rules are created successfully
        if (rule1 == null) {
            System.out.println("Error creating rule1. Please check the createRule method.");
            return;
        } else {
            System.out.println("Successfully created rule1: " + rule1);
        }

        if (rule2 == null) {
            System.out.println("Error creating rule2. Please check the createRule method.");
            return;
        } else {
            System.out.println("Successfully created rule2: " + rule2);
        }

        // Combine the rules
        try {
            Node combinedRule = parser.combineRules(rule1, rule2); // Ensure rule1 and rule2 are not null

            // Print the combined AST for debugging
            System.out.println("Combined AST: " + combinedRule);

            // Create sample data
            Map<String, Object> data = new HashMap<>();
            data.put("age", 35);
            data.put("department", "Sales");
            data.put("salary", 60000);
            data.put("experience", 3);

            // RuleEvaluator evaluates the AST
            RuleEvaluator evaluator = new RuleEvaluator();
            boolean result = evaluator.evaluateRule(combinedRule, data);

            // Output the result
            System.out.println("Evaluation Result: " + result);  // Should print true
        } catch (Exception e) {
            System.out.println("Error while combining rules: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging
        }
        
    }
}
