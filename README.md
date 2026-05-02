# Employee Heap Management System (CS3345 Assignment 5)

A Java application that implements a max-heap data structure for managing employee records. This assignment demonstrates core data structures concepts including heap operations, heap sort, and interactive menu-driven applications.

## Project Structure

- **Employee.java** - Simple data class representing an employee with ID and hourly rate
- **EmployeeHeap.java** - Implements a max-heap using ArrayList for efficient employee management
- **HeapSort.java** - Implements heap sort algorithm for sorting employees by ID
- **Main.java** - Interactive menu-driven application for testing heap operations
- **records.txt** - Sample employee data file (employee number and hourly rate pairs)

## Features

- **Insert Employee** - Add new employees to the heap (maintains max-heap property)
- **Delete Employee** - Remove employees by ID while maintaining heap structure
- **Display Heap** - View all employees currently in the heap
- **Display Sorted List** - Show employees sorted by ID using heap sort

## How to Run

### Compile
```bash
cd src
javac *.java
```

### Run
```bash
java Main
```

The program will automatically load employee records from `records.txt`. Follow the on-screen menu to interact with the heap:
- Enter `1` to insert an employee
- Enter `2` to delete an employee
- Enter `3` to display the heap
- Enter `4` to display employees sorted by ID
- Enter `5` to exit

## Data Format (records.txt)

The `records.txt` file should contain space-separated pairs of employee number and hourly rate:
```
12345 25.50
67890 30.00
54321 22.75
```

## Key Operations


- Uses **max-heap** based on employee number
- Parent-child relationship: for index i, parent = (i-1)/2, left child = 2i+1, right child = 2i+2
- Heap operations: `heapifyUp()` and `heapifyDown()` maintain the heap properties
