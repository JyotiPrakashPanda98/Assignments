package com.ruleengine;

public class Node {
    private String type;  // "operator" or "operand"
    private Node left;    // left child
    private Node right;   // right child
    private String value; // value of the operand (e.g., "age > 30")

    public Node(String type, String value, Node left, Node right) {
        this.type = type;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getType() {
        return type;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

