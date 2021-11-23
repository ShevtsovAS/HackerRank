package com.examples.javarush.html_parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }
        var tag = args[0];
        var html = getHtml();
        new TagFinder(html, tag).find().forEach(System.out::println);
    }

    private static String getHtml() throws IOException {
        var scan = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String file = scan.nextLine();
        scan.close();
        return String.join("", Files.readAllLines(Paths.get(file)));
    }

    private static class TagFinder {
        private final String html;
        private final Pattern tagPattern;
        private final Pattern openTagPattern;

        public TagFinder(String html, String tag) {
            this.html = html;
            this.tagPattern = Pattern.compile(String.format("<%s.*?>|</%s>", tag, tag));
            this.openTagPattern = Pattern.compile(String.format("<%s.*?>", tag));
        }

        public List<String> find() {
            var openTagMatcher = openTagPattern.matcher(html);
            List<String> result = new ArrayList<>();
            while (openTagMatcher.find()) {
                int startIndex = openTagMatcher.start();
                int endIndex = findEndIndex(openTagMatcher.end());
                if (endIndex > startIndex) {
                    result.add(html.substring(startIndex, endIndex));
                }
            }
            return result;
        }

        private int findEndIndex(int fromIndex) {
            var count = 1;
            var tagMatcher = tagPattern.matcher(html);
            while (tagMatcher.find(fromIndex)) {
                var tag = tagMatcher.group();
                if (isOpenTag(tag)) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    return tagMatcher.end();
                }
                fromIndex = tagMatcher.end();
            }
            return -1;
        }

        private boolean isOpenTag(String tag) {
            return openTagPattern.matcher(tag).matches();
        }
    }

}
