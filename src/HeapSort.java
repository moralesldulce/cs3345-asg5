import java.util.ArrayList;

public class HeapSort {

    public static void heapSort(ArrayList<Employee> list) {
        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(list, n, i);
        }

        for (int end = n - 1; end > 0; end--) {
            swap(list, 0, end);
            heapifyDown(list, end, 0);
        }
    }

    //reorder nodes into correct order
    private static void heapifyDown(ArrayList<Employee> list, int size, int index) {
        int largest = index;

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size &&
                list.get(left).getEmployeeNumber() > list.get(largest).getEmployeeNumber()) {
                largest = left;
            }

            if (right < size &&
                list.get(right).getEmployeeNumber() > list.get(largest).getEmployeeNumber()) {
                largest = right;
            }

            if (largest != index) {
                swap(list, index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    //helper function to swap values when necessary
    private static void swap(ArrayList<Employee> list, int i, int j) {
        Employee temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}