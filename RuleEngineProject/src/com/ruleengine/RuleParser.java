package com.ruleengine;
import java.util.Stack;

public class RuleParser {

    public Node createRule(String ruleString) {
       
        String[] tokens = ruleString.split("(?<=\\s)|(?=\\s)");

        // Stack for operands (conditions) and operators (AND, OR)
        Stack<Node> stack = new Stack<>();

        // Iterate through tokens
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim(); // Clean token

            if (token.isEmpty()) {
                continue; // Skip empty tokens
            }

            System.out.println("Processing token: " + token); // Debugging line

            if (token.equalsIgnoreCase("AND") || token.equalsIgnoreCase("OR")) {
                // Ensure there are at least two operands on the stack before applying the operator
                if (stack.size() < 2) {
                    System.out.println("Not enough operands for operator: " + token); // Debugging line
                    return null; // Return null if there aren't enough operands
                }

                // Pop two operands from the stack and create an operator node
                Node right = stack.pop();
                Node left = stack.pop();
                Node operatorNode = new Node("operator", token, left, right);
                stack.push(operatorNode);
            } else {
                // This should be an operand (a condition)
                // Expect the next two tokens for a complete condition
                if (i + 2 < tokens.length) {
                    String condition = token + " " + tokens[++i] + " " + tokens[++i]; // Get complete condition
                    Node operandNode = new Node("operand", condition, null, null);
                    stack.push(operandNode);
                } else {
                    System.out.println("Invalid condition format: " + token); // Debugging line
                    return null; // Return null if the condition is incomplete
                }
            }
        }

        // After parsing, there should be exactly one node on the stack (the root)
        if (stack.size() != 1) {
            System.out.println("Invalid rule: leftover elements in stack. Size: " + stack.size()); // Debugging line
            return null;
        }

        return stack.pop();  // Return the root of the AST
    }

	public Node combineRules(Node... rules) {
    if (rules == null || rules.length == 0) {
        throw new IllegalArgumentException("At least one rule is required to combine.");
    }

    // Start with the first rule as the root
    Node combinedRule = rules[0];

    // Combine subsequent rules with the root using the AND operator
    for (int i = 1; i < rules.length; i++) {
        combinedRule = new Node("operator", "AND", combinedRule, rules[i]);
    }

    return combinedRule;
}

}
