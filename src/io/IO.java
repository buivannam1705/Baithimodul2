package io;

import manager.Manager;
import menu.MenuManager;
import model.Student;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IO  {
    static String file = "Student.csv";
    public static void write(ArrayList<Student> Student) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Student);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Lỗi");


        }

    }


    public static ArrayList<Student> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Student>) objectInputStream.readObject();
        } catch (Exception e) {

            return new ArrayList<>();
        }

    }

}
