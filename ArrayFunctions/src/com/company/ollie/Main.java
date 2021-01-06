package com.company.ollie;

public class Main {
    // this function is used later to print out the array
    static void printThatInt(int[] arreh){
        for (int i = 0; i < arreh.length; i++){
            System.out.println("the index is: " + i + "    the value of that index is: " + arreh[i]);
        }
    }
    //this function is used to insert a chosen value into a chosen position in the array
    static int[] surgery(int[] givenArray, int indexPosition, int insertedValue){
        //this if loop handles an "invalid index position" (the index of where they wanted to put the new value is greater
        // than the index of the array)
        if (indexPosition > givenArray.length || indexPosition < 0) {
            return growthSpurt(givenArray, insertedValue);
        }
        //this chunk of code keeps the array before the selected index, for the chosen value, the same
        int[] arrayToBeOperatedOn = new int[givenArray.length + 1];
        for (int i = 0; i < indexPosition; i++){
            arrayToBeOperatedOn[i] = givenArray[i];
        }
        //this line of code puts the chosen value at the chosen index position
        arrayToBeOperatedOn[indexPosition] = insertedValue;

        // this block of code moves all the values after the new value up one position in the array
        for(int i = indexPosition + 1; i < arrayToBeOperatedOn.length; i++){
            System.out.println(i);
            arrayToBeOperatedOn[i] = givenArray[i - 1];
        }

        return arrayToBeOperatedOn;
    }

    //this function chops off the last value of the end of the array
    static int[] guillotine(int[] givenArray){
        // this loop creates the array and populates it except for the last element
        int[] arrayToBeSmallered = new int[givenArray.length - 1];
        for (int i = 0; i < arrayToBeSmallered.length; i++){
            arrayToBeSmallered[i] = givenArray[i];
        }
        return arrayToBeSmallered;
    }

    // this function adds a value of your choice on the end of the array
    static  int[] growthSpurt(int[] givenArray, int newValue){
        int[] arrayToBeBiggered = new int[givenArray.length + 1];
        for (int i = 0; i < givenArray.length; i++){
            arrayToBeBiggered[i] = givenArray[i];
        }
        arrayToBeBiggered[arrayToBeBiggered.length - 1] = newValue;
        return arrayToBeBiggered;
    }
    // this function demonstrates the above functions
    public static void main(String[] args) {
        int[] integers = new int[10];
        for (int i = 0; i < integers.length; i++){
            integers[i] = i + 1;
        }
    //this prints out the original array
        Main.printThatInt(integers);

    // this prints out the array with the extra value on the end
        integers = growthSpurt(integers, integers.length + 1);
        Main.printThatInt(integers);

    // this prints out the array with the missing value at the end
        integers = guillotine(integers);
        integers = guillotine(integers);
        Main.printThatInt(integers);

    // this prints out the array with a chosen value at a chosen index
        integers = surgery(integers, 3, 40);
        Main.printThatInt(integers);


    }
}
