package Up;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Анастасия on 15.02.2016.
 */
public class Main  {
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Chat chat = new Chat();

        Scanner in1 = new Scanner(System.in);
        while (true) {
            System.out.println("Меню:");
            System.out.println("Если хотите добавить сообщение,нажмите 1");
            System.out.println("Если хотите просмотреть в хронологическом порядке,нажмите 2");
            System.out.println("Если хотите удалить сообщение по id ,нажмите 3");
            System.out.println("Если хотите загрузить сообщения из файла,нажмите 4");
            System.out.println("Если хотите сохранить сообщения в файл ,нажмите 5");
            System.out.println("Если хотите найти сообщение по автору ,нажмите 6");
            System.out.println("Если хотите найти сообщение по ключевому слову ,нажмите 7");
            System.out.println("Если хотите найти сообщение по регулярному выражению ,нажмите 8");
            System.out.println("Если хотите завершить работу программы,нажмите 9");

            int ch=10;

            try{
                ch = new Integer(in1.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Операция введена неверно!");
            }
            switch (ch) {
                case 1:
                    System.out.println("Введите Имя: ");
                    String author = in1.nextLine();
                    System.out.println("Введите текст сообщения: ");
                    String message = in1.nextLine();
                    chat.add( author, message);
                    System.out.println("Ваше сообщение добавлено!" + "\r\n");
                    break;

                case 2:
                    System.out.println("Ваши сообщения: ");
                    chat.printAll();
                    System.out.println("\r\n");
                    break;

                case 3:
                    System.out.println("Введите id для удаления сообщения: ");
                    String id1 = in1.nextLine();
                    chat.delete(id1);
                    System.out.println("Удалено!" + "\r\n");
                    break;

                case 4:
                    System.out.println("Введите название файла: ");
                    String name = in1.nextLine();
                    chat.read(name);

                    break;

                case 5:
                    System.out.println("Введите название файла: ");
                    String name1 = in1.nextLine();
                    chat.write(name1);

                    break;
                case 6:
                    System.out.println("Введите имя автора сообщения: ");
                    String name2 = in1.nextLine();
                    chat.search(name2);
                    break;
                case 7:
                    System.out.println("Введите ключевое слово: ");
                    String name3 = in1.nextLine();
                    chat.search1(name3);

                    break;
                case 8:
                    System.out.println("Введите регулярное выражение: ");
                    String name4 = in1.nextLine();
                    chat.searchRegax(name4);

                    break;

                case 9:
                    System.out.println("Программа завершила работу. ");
                    return;
                case 10:
                    System.out.println("Возможно вы ввели не число. ");
                    break;


                default:
                    System.out.println("Неверно выбрано действие!" + "\r\n");
            }
        }

    }
}
