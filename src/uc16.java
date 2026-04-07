class PassengerBogieSorter {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            // Track if any swap happens (optimization)
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swap → already sorted
            if (!swapped) break;
        }
    }

    // Method to display array
    public static void display(int[] capacities) {
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Example input
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        display(capacities);

        // Perform Bubble Sort
        bubbleSort(capacities);

        System.out.println("After Sorting:");
        display(capacities);
    }
}
