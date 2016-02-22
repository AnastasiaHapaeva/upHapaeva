package Up;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Анастасия on 15.02.2016.
 */
public class Message {
    String id;
    String author;
    Date date;
    long timestamp;
    String message;

    Message(String id,String author, long timestamp,String message){
        this.id=id;
        this.author = author;
        this.timestamp = timestamp;
        this.message = message;
    }

    Message(String author,String message){
        this.id= UUID.randomUUID().toString();
        this.author = author;
        this.message = message;
        this.timestamp = new Date().getTime();
        this.date = new Date(this.timestamp);
    }


    public String getID(){
        return this.id;
    }
    public String getAuthor(){
        return this.author;
    }
    public long getData(){
        return this.timestamp;
    }
    public String getMessage(){
        return this.message;
    }
    public boolean sregax(String name, String name1) {
        Pattern p = Pattern.compile(name);
        Matcher m = p.matcher(name1);
        return m.matches();
    }
    @Override
    public String toString(){
        Date time = new Date(this.timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm zzzz");
        String date1 = sdf.format(time);
        String str = "Author: " + this.getAuthor()+"\nDate:"+ date1+ "\nid: "+ this.getID()+ "\nMessage: "+ this.getMessage();
        return str;
    }
}
