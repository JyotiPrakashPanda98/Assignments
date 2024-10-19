package com.ruleengine;

import java.util.Map;

public class RuleEvaluator {

    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node.getType().equals("operand")) {
            return evaluateCondition(node.getValue(), data);
        }

        boolean leftResult = evaluateRule(node.getLeft(), data);
        boolean rightResult = evaluateRule(node.getRight(), data);

        if (node.getValue().equalsIgnoreCase("AND")) {
            return leftResult && rightResult;
        } else if (node.getValue().equalsIgnoreCase("OR")) {
            return leftResult || rightResult;
        }

        return false;
    }

    private boolean evaluateCondition(String condition, Map<String, Object> data) {
        String[] parts = condition.split(" ");
        String attribute = parts[0];
        String operator = parts[1];
        String value = parts[2];

        Object dataValue = data.get(attribute);

        if (dataValue instanceof Integer) {
            int intValue = Integer.parseInt(value);
            int dataInt = (Integer) dataValue;

            switch (operator) {
                case ">":
                    return dataInt > intValue;
                case "<":
                    return dataInt < intValue;
                case "=":
                    return dataInt == intValue;
            }
        } else if (dataValue instanceof String) {
            if (operator.equals("=")) {
                return dataValue.equals(value.replace("'", ""));
            }
        }

        return false;
    }
}
