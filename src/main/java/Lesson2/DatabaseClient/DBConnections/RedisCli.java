package Lesson2.DatabaseClient.DBConnections;

public class RedisCli  implements Connection {
    private String type;
    private String ipAdress;
    private String port;

    public RedisCli(String type, String ipAdress, String port) {
        this.type = type;
        this.ipAdress = ipAdress;
        this.port = port;
        this.connection();
    }

    @Override
    public void connection() {
        System.out.println("Połączono z bazą danych : "+type+". Pod adresem "+ipAdress+":"+port);
    }


    @Override
    public void get() {
        System.out.println("pobieranie danych z bazy "+type);
    }

    @Override
    public void remove() {
        System.out.println("usuwanie danych z bazy "+type);
    }

    @Override
    public void add() {
        System.out.println("dodawanie danych do bazy" +type);
    }
}
