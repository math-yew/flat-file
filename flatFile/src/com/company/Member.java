package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.*;

public class Member {
    public int id;
    public String name;
    public int age;
    public String member;

    public Member(String[] row) {
        this.id = Integer.parseInt(row[0]);
        this.name = row[1];
        this.age = Integer.parseInt(row[2]);
        this.member = row[3];
    }

    public String showData(){
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
//            System.out.println(field.getName());
        }

        String info = Integer.toString(id) + " " + name + " " + Integer.toString(age) + " " + member;
        return info;

    }


}
