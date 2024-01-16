import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Shell Sort");

        // Get user choice
        int choice = scanner.nextInt();

        // Input 10 numbers
        int[] numbers = new int[10];
        System.out.println("Enter 10 numbers:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Display unsorted numbers
        System.out.println("Entered nums: " + Arrays.toString(numbers));

        // Perform the chosen sorting algorithm
        switch (choice) {
            case 1:
                insertionSort(numbers);
                System.out.println("Sorted using Insertion Sort.");
                break;
            case 2:
                selectionSort(numbers);
                System.out.println("Sorted using Selection Sort.");
                break;
            case 3:
                bubbleSort(numbers);
                System.out.println("Sorted using Bubble Sort.");
                break;
            case 4:
                shellSort(numbers);
                System.out.println("Sorted using Shell Sort.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
        }

        // Display the sorted array
        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }

    // Insertion Sort
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Bubble Sort
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Shell Sort
    private static void shellSort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
