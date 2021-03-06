package com.erikriosetiawan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Set<Integer> uniqueColorType = new HashSet<>();
        List<Integer> colorType = new ArrayList<>();

        for (int i = 0; i < n; i++)
            uniqueColorType.add(ar[i]);

        colorType.addAll(uniqueColorType);

        for (int i = 0; i < colorType.size(); i++) {
            int colorTypeTotal = 0;

            for (int j = 0; j < n; j++) {
                if (colorType.get(i) == ar[j]) {
                    colorTypeTotal++;
                }
            }

            if (colorTypeTotal == 1)
                colorType.remove(i);
        }

        int total = 0;

        for (int i = 0; i < colorType.size(); i++) {
            int totalType = 0;
            for (int j = 0; j < n; j++) {
                if (colorType.get(i) == ar[j])
                    totalType++;
            }
            total += totalType / 2;
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}