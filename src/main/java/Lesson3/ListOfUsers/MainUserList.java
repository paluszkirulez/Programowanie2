package Lesson3.ListOfUsers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class MainUserList{
    public static void main(String[] args) {
        List<String> userlist = new ArrayList<>();
        userlist.add("Bartek");
        userlist.add("Krzysiek");


        ListOfUSers listOfUSers = new ListOfUSers(userlist,Date.valueOf(LocalDate.now()),"Pawel");
        listOfUSers = new ListOfUSers(userlist,Date.valueOf(LocalDate.now()),"waclaw");
        ListOfUSers listOfUSers1 = new ListOfUSers(userlist,Date.valueOf(LocalDate.now()),"waclaw");

        System.out.println(listOfUSers.getId());
        System.out.println(listOfUSers.getTeacher());
        System.out.println(listOfUSers1.getId());

    }
}
