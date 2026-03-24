#include<stdio.h>
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do
        {
            System.out.println("\n1.Add Student\n2.View Students\n3.Update Student\n4.Delete Student\n5.Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    Student s = new Student();

                    System.out.print("Enter ID: ");
                    s.setId(sc.nextInt());

                    System.out.print("Enter Name: ");
                    s.setName(sc.next());

                    System.out.print("Enter Marks: ");
                    s.setMarks(sc.nextDouble());

                    dao.addStudent(s);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();

                    System.out.print("Enter new Marks: ");
                    double marks = sc.nextDouble();

                    dao.updateStudent(id, marks);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Exit");
                    break;
            }
        } while(choice != 5);
    }
}
