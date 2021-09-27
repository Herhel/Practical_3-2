package com.alfa.work2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public void run() {
        File file = new File(".\\src\\com\\alfa\\files\\user.txt");
        List<User> users = createUserBase();
        boolean writeResult = writeUsersList(file, users);
        if (writeResult) {
            System.out.println("Пользователи записаны");
        } else {
            System.out.println("База пользователей пуста. Запись не сделана.");
        }
        readUsers(file);

    }

    private List<User> createUserBase() {
        List<User> users = new ArrayList<>();
        users.add(new User("Kiri", "Ruslan", 18));
        users.add(new User("Simson", "Jon", 21));
        return users;
    }

    private boolean writeUsersList(File file, List<User> users) {
        if (!users.isEmpty()) {
            for (User user : users) {
                writeUser(file, user);
            }
            return true;
        } else {
            return false;
        }
    }

    private void writeUser(File file, User user) {
        System.out.println("Чтение пользователей из файла:");
        try (RandomAccessFile out = new RandomAccessFile(file, "rw")) {
            long endPointFile = out.length();
            out.seek(endPointFile);
            out.writeBytes(user.toString() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void readUsers(File file) {
        try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
            String user;
            while ((user = in.readLine()) != null) {
                System.out.println(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
