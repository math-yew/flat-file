package com.company;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("list.csv");
        String fileName = "list.csv";
        String location = path.toAbsolutePath().toString().replace(fileName, "\\src\\com\\company\\" + fileName);
        File file = new File(location);
        System.out.println("file name: " + file.getName());
        System.out.println("file canRead: " + file.canRead());
        System.out.println("file canWrite: " + file.canWrite());
        System.out.println("file exists: " + file.exists());
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
