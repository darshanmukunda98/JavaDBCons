package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        while (true) {
            System.out.println("""
                    Enter command:
                    1. CREATE
                    2. INSERT
                    3. SELECT
                    4. EXIT
                    """);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    db.executeCreateQuery();
                    break;
                }
                case 2: {
                    db.executeInsertQuery(new Todo("Study",
                            "Study Java concepts",
                            1,
                            java.sql.Date.valueOf(LocalDate.now())));
                    break;
                }
                case 3: {
                    db.executeSelectQuery();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }
    }
}