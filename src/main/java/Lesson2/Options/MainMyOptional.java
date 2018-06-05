package Lesson2.Options;

public class MainMyOptional {
    public static void main(String[] args) {
        MyOptional emptyOptional = new MyOptional();

        //System.out.println(emptyOptional.get());
        emptyOptional = new MyOptional("brak");
        System.out.println(emptyOptional.isSet());
        System.out.println(emptyOptional.get());
        emptyOptional.setMyOptional("kawa");
        System.out.println(emptyOptional.get());

        emptyOptional.getOrDefault(new MyOptional("gra"));
        emptyOptional = MyOptional.empty();
        emptyOptional.getOrDefault(new MyOptional("gra").get());
        emptyOptional.isSet();
        System.out.println(emptyOptional.get());

    }
}
