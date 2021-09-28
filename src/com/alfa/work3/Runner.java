package com.alfa.work3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public void run() {
        File file = new File(".\\src\\com\\alfa\\files\\users.ser");
        List<User> users = createUserBase();
        try {
            externalizeUsers(users, file);
        } catch (IOException e) {
            System.out.println("Externalize failed " + e.getMessage());
        }
        try {
            printExternalizeUsers(file);
        } catch (IOException e) {
            System.out.println("Read file error " + e.getMessage());
        }

    }

    private List<User> createUserBase() {
        List<User> users = new ArrayList<>();
        users.add(new User("Kiri", "Ruslan", 18));
        users.add(new User("Simson", "Jon", 21));
        return users;
    }

    private void externalizeUsers(List<User> users, File file) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            for (User user : users) {
                os.writeObject(user);
            }
        }
    }

    private void printExternalizeUsers(File filePath) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            User user;
            while ((user = (User) objectInputStream.readObject()) != null) {
                System.out.println(user);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException ignored) {
        }
    }
}
