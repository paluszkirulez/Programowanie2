package Lesson3.ListOfUsers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ListOfUSers {
    private  int listOfUsers;
    //private ListOfUSers(){};


    private final List<String> users;
    private final Date date;
    private static int count = 0;
    private final Integer id;
    private final String teacher;

    public ListOfUSers(List<String> users, Date date, String teacher) {

            listOfUsers = 1;
        this.users = users;
        this.date = date;
        this.teacher = teacher;
        this.id = ++count;


    }

    public List<String> getUsers() {
        return new ArrayList<>(users);
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public int getId() {
        return id;
    }

    public String getTeacher() {
        return teacher;
    }
}
