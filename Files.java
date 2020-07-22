package ru.innopolis.university.mingaleev.homework_3_15;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя текстового файла:");
        String fileName = in.next();
        System.out.println("Введите полный путь");
        String filePath = in.next();
        File directory = new File(filePath);
        File file = new File(directory, fileName + ".txt");

        if (directory.mkdir()) {
            System.out.println("Созданный каталог " + directory.getName());
        }
        while (true) {

            System.out.println("\nЧто Вы хотите сделать? (q выйти)\nсоздать\nпереименовать\nудалить");
            String user = in.next();

            if(user.equals("q"))
                break;
            try{ switch (user) {
                case "создать": {
                    file.createNewFile();
                    System.out.println("Создан файл: " + file.getName());
                }
                break;
                case "переименовать": {
                    System.out.println("Введите новое имя файла: ");
                    String name2 = in.next();
                    File file2 = new File(directory, name2 + ".txt");
                    file.renameTo(file2);
                    System.out.println("Файл переименован в " + name2);
                }
                break;
                case "удалить": {
                    file.delete();
                    System.out.println("Файл был удален.");
                }
                break;
                default:
                    System.out.println("Нужно что то выбрать.");
            }
            }catch (Exception e){
                System.out.println("Exception" + e);
            }
        }
    }
}
