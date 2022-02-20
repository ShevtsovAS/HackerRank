package com.examples.javarush.files_copy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//https://javarush.ru/tasks/com.javarush.task.task31.task3101
public class Solution {
    public static void main(String[] args) throws IOException {
        List<File> files = getSourceFiles(args[0], args[1]);
        File destinationFile = createDestinationFile(args[1]);
        readFilesAndWriteToDestinationFile(files, destinationFile);
    }

    private static List<File> getSourceFiles(String path, String dest) {
        List<File> files = new ArrayList<>();
        Queue<File> folders = new LinkedList<>();
        File destFile = Paths.get(dest).toFile();
        folders.add(new File(path));
        int maxFileSize = 50;
        while (!folders.isEmpty()) {
            File dir = folders.poll();
            File[] listFiles = Optional.ofNullable(dir.listFiles())
                    .orElseGet(() -> new File[0]);
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    folders.add(file);
                } else {
                    if (file.length() <= maxFileSize && !file.equals(destFile)) {
                        files.add(file);
                    }
                }
            }
        }
        return files;
    }

    private static File createDestinationFile(String dest) throws IOException {
        File destFile = Paths.get(dest).toFile();
        File renamedDestFile = Paths.get(destFile.getParent(), "allFilesContent.txt").toFile();
        if (renamedDestFile.exists()) {
            Files.delete(renamedDestFile.toPath());
        }
        if (destFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            destFile.renameTo(renamedDestFile);
        } else {
            Files.createDirectories(renamedDestFile.toPath().getParent());
        }
        return renamedDestFile;
    }

    private static void readFilesAndWriteToDestinationFile(List<File> files, File destinationFile) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(destinationFile, true)) {
            for (File file : files) {
                try (InputStream fis = new FileInputStream(file)) {
                    fis.transferTo(fos);
                    fos.write("\n".getBytes());
                }
            }
        }
    }
}
