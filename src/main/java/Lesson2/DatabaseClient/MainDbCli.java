package Lesson2.DatabaseClient;

import Lesson2.DatabaseClient.DBConnections.Connection;

import java.util.Scanner;

public class MainDbCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Connection dbCli = new DBCli(input).makeConnection();
        dbCli.add();
        dbCli.remove();


    }
}
