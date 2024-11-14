import java.util.Arrays;
import java.util.Scanner;

class Item {
    double value, weight;

    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    // Method to get value-to-weight ratio
    public double getRatio() {
        return value / weight;
    }
}

public class fractionalKnapsack {

    // Quick Sort implementation to sort items by value-to-weight ratio
    public static void quickSort(Item[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(Item[] arr, int low, int high) {
        double pivot = arr[high].getRatio();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getRatio() > pivot) { // Sort in descending order
                i++;
                Item temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Item temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Method to calculate the maximum value for the knapsack
    public static double fractionalKnapsack(Item[] items, double capacity) {
        quickSort(items, 0, items.length - 1);
        double totalValue = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.getRatio() * capacity;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            double weight = scanner.nextDouble();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        double maxValue = fractionalKnapsack(items, capacity);
        System.out.printf("Maximum value in Knapsack = %.2f\n", maxValue);

        scanner.close();
    }
}
