package Up;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;
/**
 * Created by Анастасия on 15.02.2016.
 */
public class Chat {
    ArrayList<Message> chat;

    public Chat() {
        chat = new ArrayList<Message>();
    }


    public void add( String author, String message){
        Message message1 = new Message(author, message);
        chat.add(message1);

    }

    public void read(String name) throws IOException {
        try {
            FileReader fr = new FileReader(name);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Message>>() {}.getType();
            ArrayList<Message> chat = gson.fromJson(fr, collectionType);
            this.chat.addAll(chat);
            System.out.println("Готово!" + "\r\n");
        }
        catch(FileNotFoundException e){
            System.out.println("Ошибка!Файл не найден.");
        }

    }
    public void write(String name){
        try{
            FileWriter fw = new FileWriter(name);
            Gson gson = new Gson();
            fw.write(gson.toJson(chat));
            fw.close();
            System.out.println("Готово!" + "\r\n");
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Ошибка!");
        }

    }

    public void delete(String id){
        Iterator<Message> message = chat.iterator();
        while (message.hasNext()) {
            if (message.next().getID().equals(id)) {
                message.remove();
            }
        }
    }
    public void printAll(){
        Collections.sort(chat, new Comparator<Message>(){
            @Override
            public int compare(Message a, Message b) {
                return Long.compare(b.getData(), a.getData());
            }
        });

        for (int i = 0; i < chat.size(); i++) {
            System.out.println(chat.get(i));
        }

    }
}
