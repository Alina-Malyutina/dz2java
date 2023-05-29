package org.example;


public class Task1 {
    public static void Run() {
        System.out.println("Task1");

        String SQL = "select * from students where ";
        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        System.out.println("SQL: " + SQL);
        System.out.println("JSON string: " + jsonString);

        String finishSQL = SQL + method(jsonString);

        System.out.println("Res: " + finishSQL);
    }

    public static String method(String jsonString) {
        String student = jsonString.replaceAll("[{} \"]", "");
        String[] id_name = student.split(",");

        StringBuilder where = new StringBuilder();
        boolean addAdd = false;

        for (String std: id_name) {
            String[] str = std.split(":");
            if (str[1].equals("null")) continue;
            if (addAdd) {
                where.append(" AND ");
            } else {
                addAdd = true;
            }
            where.append(str[0]);
            where.append(" = '");
            where.append(str[1]);
            where.append("'");
        }

        return where.toString();
    }
}