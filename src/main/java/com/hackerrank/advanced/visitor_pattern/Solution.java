package com.hackerrank.advanced.visitor_pattern;

import java.util.*;

import static com.hackerrank.advanced.visitor_pattern.Color.GREEN;
import static com.hackerrank.advanced.visitor_pattern.Color.RED;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private final int value;
    private final Color color;
    private final int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private final List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int result = 0;

    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    int result = 1;

    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == RED) {
            result *= node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == RED) {
            result *= leaf.getValue();
        }
    }
}

class FancyVisitor extends TreeVis {

    int nonLeafEvenDeptSum = 0;
    int greenLeafSum = 0;

    public int getResult() {
        //implement this
        return Math.abs(nonLeafEvenDeptSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() == 0 || node.getDepth() % 2 == 0) {
            nonLeafEvenDeptSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

//https://www.hackerrank.com/challenges/java-vistor-pattern/problem
public class Solution {
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] values = new int[n];
            Color[] colors = new Color[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                colors[i] = Color.values()[scanner.nextInt()];
            }

            Map<Integer, Set<Integer>> tree = new HashMap<>(n);
            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                tree.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            }

            Set<Integer> rootChildren = tree.get(0);
            if (rootChildren.isEmpty()) {
                return new TreeLeaf(values[0], colors[0], 0);
            }

            TreeNode root = new TreeNode(values[0], colors[0], 0);
            rootChildren.forEach(child -> addChildRecursive(root, child, tree, values, colors));

            return root;
        }
    }

    private static void addChildRecursive(TreeNode root,
                                          int child,
                                          Map<Integer, Set<Integer>> rawTree,
                                          int[] values,
                                          Color[] colors) {
        Set<Integer> children = rawTree.get(child);
        if (children != null && !children.isEmpty()) {
            TreeNode childNode = new TreeNode(values[child], colors[child], root.getDepth() + 1);
            children.forEach(ch -> addChildRecursive(childNode, ch, rawTree, values, colors));
            root.addChild(childNode);
        } else {
            root.addChild(new TreeLeaf(values[child], colors[child], root.getDepth() + 1));
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
