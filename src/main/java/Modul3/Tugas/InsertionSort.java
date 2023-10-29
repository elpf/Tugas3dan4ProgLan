package Modul3.Tugas;

import java.util.Arrays;
import java.util.Random;

/**
 * Kelas ini mengimplementasikan algoritma Insertion Sort untuk mengurutkan sebuah array integer.
 */
public class InsertionSort {
    final private int[] array;

    /**
     * Konstruktor untuk objek InsertionSort.
     *
     * @param inputArray Array integer yang akan diurutkan.
     */
    public InsertionSort(int[] inputArray) {
        array = Arrays.copyOf(inputArray, inputArray.length);
    }

    /**
     * Melakukan insertion sort pada array yang telah diberikan saat inisialisasi objek.
     */
    public void performSort() {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Mendapatkan array yang telah diurutkan.
     *
     * @return Array yang telah diurutkan.
     */
    public int[] getSortedArray() {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * Metode utama untuk melakukan insertion sort pada array acak dan mencetak array sebelum diurutkan.
     *
     * @param args Argumen yang diterima dari baris perintah (tidak digunakan dalam contoh ini).
     */
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(100);

        System.out.println("Array sebelum diurutkan: " + Arrays.toString(randomArray));

        System.out.println("Algoritma Insertion Sort: ");
        InsertionSort insertionSort = new InsertionSort(randomArray);

        insertionSort.performSort();

        int[] sortedArray = insertionSort.getSortedArray();
        System.out.println("Array yang telah diurutkan: " + Arrays.toString(sortedArray));

        //ini adalah fitur tambahan yang saya berikan
        long startTime = System.nanoTime(); // Waktu awal

        insertionSort.performSort();

        long endTime = System.nanoTime(); // Waktu akhir

        long executionTime = endTime - startTime;
        System.out.println("Waktu eksekusi Insertion Sort: " + executionTime + " nanoseconds");

    }

    /**
     * Menghasilkan array acak dengan ukuran tertentu.
     *
     * @param size Ukuran array acak yang akan dihasilkan.
     * @return Array acak dengan angka-angka integer.
     */
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
