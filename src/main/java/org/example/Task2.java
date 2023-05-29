package org.example;



import java.util.ArrayList;
import java.util.List;

    public class Task2 {

        public static void Run() {
            System.out.println("Task2");
            String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
            List<MyStruct> studentsList = parseJsonString(jsonString);
            printGrades(studentsList);


        }

        public static List<MyStruct> parseJsonString(String jsonString) {
            List<MyStruct> list = new ArrayList<>();
            jsonString = jsonString.replace("},{", ";");
            jsonString = jsonString.replaceAll("[\\[\\]{} \"]", "");
            String[] students = jsonString.split(";");
            for (String student : students) {
                String[] oneStudent = student.split(",");
                MyStruct one = new MyStruct();
                one.surName = oneStudent[0].split(":")[1];
                one.grade = oneStudent[1].split(":")[1];
                one.theme = oneStudent[2].split(":")[1];
                list.add(one);
            }
            return list;
        }

        public static void printGrades(List<MyStruct> studentsList) {
            for (MyStruct myStruct : studentsList) {
                String result = "Студент " + myStruct.surName +
                        " получил " +
                        myStruct.grade +
                        " по предмету " +
                        myStruct.theme +
                        ".";
                System.out.println(result);
            }
        }
    }

class MyStruct {
    String surName;
    String grade;
    String theme;
}