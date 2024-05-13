package com.examples.prefix_tree;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        var root = new TreeNode(' ');
        List<String> sourceData = Stream.of("123456", "123457", "123456", "123458", "123459", "123467", "123468", "123469").toList();
        sourceData.forEach(root::insert);
        sourceData.forEach(s -> System.out.printf("%s contains in the prefixTree: %s%n", s, root.contains(s)));

        System.out.println(root.getAll());
    }

    @RequiredArgsConstructor
    static class TreeNode {
        private final char value;
        private final List<TreeNode> children = new ArrayList<>();

        public void insert(String data) {
            Optional.ofNullable(data)
                    .filter(s -> !s.isEmpty())
                    .ifPresent(this::addChild);
        }

        public boolean contains(String data) {
            var current = this;
            for (char c : data.toCharArray()) {
                current = current.findNodeByChar(c);
                if (current == null) {
                    return false;
                }
            }
            return true;
        }

        public List<String> getAll() {
            return getAll("", new ArrayList<>());
        }

        private List<String> getAll(String path, ArrayList<String> result) {
            if (value != ' ') {
                path += value;
            }
            if (!children.isEmpty()) {
                for (TreeNode child : children) {
                    child.getAll(path, result);
                }
            } else {
                result.add(path);
            }

            return result;
        }

        private void addChild(String s) {
            char c = s.charAt(0);
            var child = findNodeByChar(c);
            if (child == null) {
                child = new TreeNode(c);
                children.add(child);
            }
            child.insert(s.substring(1));
        }

        private TreeNode findNodeByChar(char c) {
            return children.stream().filter(treeNode -> treeNode.value == c).findFirst().orElse(null);
        }
    }
}
