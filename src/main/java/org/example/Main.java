package org.example;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Database db = new Database();
//        db.executeCreateQuery();
        /*db.executeInsertQuery(new Todo("Study",
                "Study Java concepts",
                1,
                java.sql.Date.valueOf(LocalDate.now())));*/
        db.executeSelectQuery();


    }
}