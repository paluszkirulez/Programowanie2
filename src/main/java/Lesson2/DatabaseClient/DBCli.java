package Lesson2.DatabaseClient;

import Lesson2.DatabaseClient.DBConnections.*;

import java.util.regex.Pattern;

public class DBCli{
    private String type;
    private String ipType;
    private String port;
    private static final Pattern IPPATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final Pattern PORTPATTERN = Pattern.compile("\\d{1,5}");
    private void setDBTypes(String type){
        this.type = type;
    }
    private void setIpType(String IpAdress){
        if(IPPATTERN.matcher(IpAdress).matches()){
            this.ipType = IpAdress;
        }

    }
    private void setPort(String port){
        if(PORTPATTERN.matcher(port).matches()){
            this.port = port;
        }
    }

    public DBCli(String adress){
        String type = adress.substring(0,adress.indexOf(':'));
        String ipAdress = adress.substring(adress.indexOf(':')+3,adress.lastIndexOf(':'));
        String port = adress.substring(adress.lastIndexOf(':')+1);
        System.out.println(type);
        System.out.println(ipAdress);
        System.out.println(port);
        setDBTypes(type);
        setIpType(ipAdress);
        setPort(port);

    }

    public DBCli() {
    }

    public Connection makeConnection() throws HostNotFound{
        if(type == null){
            return null;
        }
        if(type.toLowerCase().equals("oracle")){

            return new OracleCli(type,ipType,port);
        }
        else if(type.toLowerCase().equals("cassandra")){

            return new CassandraCli(type,ipType,port);
        }
        else if(type.toLowerCase().equals("mongo")){

            return new MongoCli(type,ipType,port);
        }
        else if(type.toLowerCase().equals("mysql")){

            return new MySqlCli(type,ipType,port);
        }
        else if(type.toLowerCase().equals("redis")){
            //new RedisCli().connection(type,ipType,port);
            return new RedisCli(type,ipType,port);
        }
        else  {
            throw new HostNotFound();

        }
    }

}
