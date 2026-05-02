import java.util.ArrayList;

public class EmployeeHeap {
    private ArrayList<Employee> heap;

    public EmployeeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(Employee employee) {
        heap.add(employee);
        heapifyUp(heap.size() - 1);
    }

    //delete based on employeeNumber
    public boolean delete(int employeeNumber) {
        int index = findEmployee(employeeNumber);

        if (index == -1) {
            return false;
        }

        Employee lastEmployee = heap.remove(heap.size() - 1);

        if (index < heap.size()) {
            heap.set(index, lastEmployee);
            heapifyDown(index);
            heapifyUp(index);
        }

        return true;
    }
    
    //search employee by employeeNumber
    private int findEmployee(int employeeNumber) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).getEmployeeNumber() == employeeNumber) {
                return i;
            }
        }
        return -1;
    }

    //add new largest number
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = parent(index);

            if (heap.get(index).getEmployeeNumber() > heap.get(parentIndex).getEmployeeNumber()) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    //update to accommodate new smallest number
    private void heapifyDown(int index) {
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int largest = index;

            if (left < heap.size() &&
                heap.get(left).getEmployeeNumber() > heap.get(largest).getEmployeeNumber()) {
                largest = left;
            }

            if (right < heap.size() &&
                heap.get(right).getEmployeeNumber() > heap.get(largest).getEmployeeNumber()) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        Employee temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    //return a copy of the heap
    public ArrayList<Employee> getHeapCopy() {
        return new ArrayList<>(heap);
    }

    public void displayHeap() {
        for (Employee employee : heap) {
            System.out.println(employee);
        }
    }
}