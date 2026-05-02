import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        EmployeeHeap heap = new EmployeeHeap();

        try {
            Scanner fileScanner = new Scanner(new File("records.txt"));

            while (fileScanner.hasNextInt()) {
                int employeeNumber = fileScanner.nextInt();
                double hourlyRate = fileScanner.nextDouble();

                heap.insert(new Employee(employeeNumber, hourlyRate));
            }

            fileScanner.close();
        } catch (FileNotFoundException e){ //exception in case file does not exist
            System.out.println("records.txt was not found.");
            return;
        }

        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            //display menu to test various aspects of the program's heap
            System.out.println("\n1. Insert employee");
            System.out.println("2. Delete employee");
            System.out.println("3. Display the heap");
            System.out.println("4. Display sorted list");
            System.out.println("5. Exit");
            System.out.print("Choose an option(1-5): ");

            choice = keyboard.nextInt();

            if (choice == 1) {
                System.out.print("Enter the employee number: ");
                int number = keyboard.nextInt();

                System.out.print("Enter hourly rate: ");
                double rate = keyboard.nextDouble();

                heap.insert(new Employee(number, rate));
                System.out.println("Employee inserted.");
            } 
            else if (choice == 2) {
                System.out.print("Enter employee number to delete: ");
                int number = keyboard.nextInt();

                if (heap.delete(number)) {
                    System.out.println("Employee deleted.");
                } else {
                    System.out.println("Employee not found.");
                }
            } 
            else if (choice == 3) {
                System.out.println("\nCurrent Heap:");
                heap.displayHeap();
            } 
            else if (choice == 4) {
                ArrayList<Employee> sortedList = heap.getHeapCopy();
                HeapSort.heapSort(sortedList);

                System.out.println("\nSorted employee list:");
                for (Employee employee : sortedList) {
                    System.out.println(employee);
                }
            } 
            else if (choice == 5) {
                System.out.println("Program exiting.");
            } 
            else {
                System.out.println("Invalid option, try again.");
            }
        }

        keyboard.close();
    }
}