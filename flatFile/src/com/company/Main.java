package com.company;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        System.out.println("Flat File");
        File file = new File("members.csv");
        System.out.println("file name: " + file.getName());
        System.out.println("file canRead: " + file.canRead());
        System.out.println("file canWrite: " + file.canWrite());

    }
}
