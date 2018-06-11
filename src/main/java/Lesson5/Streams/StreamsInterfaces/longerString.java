package Lesson5.Streams.StreamsInterfaces;

public class longerString  {

    static String betterString(String a1, String a2, betterStringInterface k) {
        return k.returnBetterString(a1,a2) == true ? a1:a2;
    }

    public static void main(String[] args) {
        String a2 = "kot";
        String a1 = "Arkadsiusz";
        System.out.println(betterString(a1,a2,(b,c)->b.charAt(0)>c.charAt(0)));
    }
}
