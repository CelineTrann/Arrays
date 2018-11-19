package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here


        int [][] array = {
            {1, 4, 3, 2, 5},
            {4, 5, 3, 2, 9},
            {4, 7, 8, 1, 4}};

        int sum = 0;
        int mean = 0;
        int median = 0;
        double variance = 0;
        double sdev = 0;           //Standard deviation

        //Make 2d array into 1d array
        int [] list = new int [array.length * array[0].length];

        int listnum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                list[listnum++] = array [i][j];
            }
        }

        //This is used to find the SUM
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        System.out.println("This is the sum: " + sum);

        //MEAN
        mean = sum/list.length;
        System.out.println("Mean: " + mean);

        //This is used to find the MEDIAN
        Arrays.sort(list);

        int middle = (list.length / 2);
        if (list.length % 2 == 0) {
            int medium1 = list[middle];
            int medium2 = list[middle - 1];
            median = (medium1 + medium2) / 2;
        } else {
            median = list[middle + 1];
        }
        System.out.println("The MEDIAN is: " + median);


        //This is the mode
        int[] frequencies = new int[10]; // all zero
        for(int [] row : array){
            for(int val : row){
                frequencies[val]++;
            }
        }

        // scan for the largest value
        int largest = 0;
        int mode = -1;
        for (int i = 0; i < 10; ++i) {
            if (frequencies[i] > largest) {
                largest = frequencies[i];
                mode = i;
            }
        }System.out.println("Mode: " + mode);



        //VARIANCE
        double temp = 0;
        for (double a : list) {
            temp += (a - mean) * (a - mean);
        }
        variance = temp / list.length;
        System.out.println("Variance:" + variance);

        //Standard deviation
        sdev = Math.sqrt(variance);
        System.out.println("Standard Deviation: " + sdev);
    }
}
