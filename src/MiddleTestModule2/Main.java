package MiddleTestModule2;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> studentList = new ArrayList<>();

    static void display(){
        System.out.println(".................");
        System.out.println("Chon mot chuc nang");
        System.out.println(".................");
        System.out.println("1. Hien thi danh sach");
        System.out.println("2. Them vao danh sach");
        System.out.println("3. Xoa danh sach");
        System.out.println("4. Chinh sua");
        System.out.println("5. Chon bat ky so nao de ket thuc chuong trinh");
        System.out.println(".................");
    }

    static boolean chooseFunction(int number){
            switch (number) {
                case 1:
                    list();
                    return true;
                case 2:
                    add();
                    return true;
                case 3:
                    delete();
                    return true;
                case 4:
                    edit();
                    return true;
                default:
                    System.out.printf("Yeu cau chon lai");
                    display();
                    return false;
                   // break;
            }
    }

    static void list(){
        for (Student student: studentList) {
            System.out.println("Danh sach sinh vien la:");
            System.out.printf("ID:%d, Name:%s, Age:%d",student.getId(),student.getName(),student.getAge());
            System.out.println("");
        }
        System.out.println("...............");
        display();
        recallFunction();
    }

    static void add() throws NullPointerException{
        int id = 0;
        Student student;
        if(studentList.size() == 0){
            id = 0;
        } else {
            id = studentList.get(studentList.size() -1 ).getId() + 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhap ten:");
        String name = scanner.next();
        System.out.printf("Nhap Tuoi:");
        int age = scanner.nextInt();
        student = new Student(id,name,age);
        if( studentList.add(student) ){
            System.out.printf("Add thanh cong");
        } else {
            System.out.printf("Add khong thanh cong");
        }
        display();
        recallFunction();
    }

    static void recallFunction(){
        boolean nextStep = false;
        while (!nextStep) {
            Scanner scannerNext = new Scanner(System.in);
            int chooseNumber = scannerNext.nextInt();
            nextStep = chooseFunction(chooseNumber);
        }
    }

    static void delete(){
        System.out.println("Chon id de xoa:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        boolean check = false;
        for(int i = 0; i < studentList.size(); i++){
            int idCheck = studentList.get(i).getId();
            if(idCheck == id){
                check = true;
                break;
            }
        }
        if (check) {
            Student removed = studentList.remove(id);
            if (removed != null) {
                System.out.println("Xoa thanh cong");
            } else {
                System.out.println("Xoa bi loi");
            }
        } else {
            System.out.println(" Tim khong thay");
        }
        display();
        recallFunction();
    }

    static void edit(){

    }

    public static void main(String[] args) {
        display();
        recallFunction();
    }
}
