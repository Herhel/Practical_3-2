package com.alfa.work1;

import java.io.*;

public class Runner {

    public void run() {
        File file = new File(".\\src\\com\\alfa\\files\\employee.ser");
        Employee employee = new Employee("Sasha", "Odesska str., 7", 35795185, 543);
        writeEmployee(employee, file);
        System.out.println(readEmployee(file));
    }

    public void writeEmployee(Employee employee, File file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(employee);
            System.out.println("Output complete");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee readEmployee(File file) {
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            return (Employee) input.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
