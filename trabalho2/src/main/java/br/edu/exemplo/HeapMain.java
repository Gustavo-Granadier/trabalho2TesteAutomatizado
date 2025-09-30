package br.edu.exemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapMain {
   
    public static void main(String[] args) {
        System.out.println("Forneça as strings a serem postas em ordem.\nUma por linha.");
        System.out.println("Uma linha vazia encerra a leitura:");

        String[] a = HeapMain.readStrings();
        Heap.sort(a);
        System.out.println(Heap.show(a));
    }

    public static String[] readStrings() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[5];
        int itemsRead = 0;
        String oneLine;

        try {
            while ((oneLine = in.readLine()) != null && !oneLine.equals("")) {
                if (itemsRead == array.length) {
                    array = resize(array, array.length * 2);
                }
                array[itemsRead++] = oneLine;
            }
        } catch (IOException e) {
            System.out.println("Unexpected IO Exception has shortened amount read");
        }

        return resize(array, itemsRead);
    }

    public static String[] resize(String[] array, int newSize) {
        String[] original = array;
        int numToCopy = Math.min(original.length, newSize);

        array = new String[newSize];
        for (int i = 0; i < numToCopy; i++) {
            array[i] = original[i];
        }
        return array;
    }
}
