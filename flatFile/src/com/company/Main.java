package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    static File file;
    static Scanner scanner;
    static Scanner nav;
    static String location;
    static List<Member> members;
    static List<Member> filtered;

    public static void main(String[] args) {
        members = new ArrayList<Member>();
        nav = new Scanner(System.in);
        Path path = Paths.get("list.csv");
        String fileName = "list.csv";
        location = path.toAbsolutePath().toString().replace(fileName, "\\src\\com\\company\\" + fileName);
        process();
        navigation();
    }

    public static void navigation() {
        System.out.println("");
        System.out.println("View (v), Column (col), Age (age), End (e)");
        String option = nav.nextLine();
        switch (option) {
            case "v":
                view();
                break;
            case "e":
                System.out.println("Goodbye");
                break;
            case "age":
                age();
                break;
            case "col":
                column();
                break;
            default:
                navigation();
        }
    }

    public static void process() {
        file = new File(location);
        try {
            scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        boolean header = true;
        while (scanner.hasNextLine()) {
            String[] nextLine = scanner.nextLine().split(",");
            if (!header) {
                members.add(new Member(nextLine));
            }
            header = false;
        }
        scanner.close();
    }

    public static void view() {
        for (Member member : members) {
            System.out.println(member.showData());
        }

        navigation();
    }

    public static void age() {
        System.out.println("Older than? (type an age)");
        int age = nav.nextInt();
        nav.nextLine();
        members
                .stream()
                .filter(a -> a.age > age)
                .forEach(e -> {
                            System.out.println(e.showData());
                        }
                );

        navigation();
    }

    public static void column() {
        System.out.println("id, name, age, member?");
        String col = nav.nextLine();
        System.out.println("value?");
        String val = nav.nextLine();
        members
                .stream()
                .filter(c -> {
                            boolean select = false;
                            if (col.equals("id")) {
                                select = val.equals(Integer.toString(c.id));
                            } else if (col.equals("name")) {
                                select = val.toLowerCase().equals(c.name.toLowerCase());
                            } else if (col.equals("age")) {
                                select = val.equals(Integer.toString(c.age));
                            } else if (col.equals("member")) {
                                select = val.toLowerCase().equals(c.member.toLowerCase());
                            }
                            return select;
                        }
                )
                .forEach(e -> {
                            System.out.println(e.showData());
                        }
                );
        navigation();
    }
}
