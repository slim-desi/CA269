/*
Author: Joseph Babilu Karippai
MyFancyDataStructure.java - Assignment 4
*/

import java.lang.Comparable;
import java.util.Comparator;

public class MyFancyDataStructure {
    public static void main(String[] args) {

    }
}

// A class representing a value with methods for sorting 
class Value implements Comparable<Value>{
    private final int value;
    private static boolean SORT_LOWER;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "" + this.value;
    }

    public static boolean isSortLower() {
        return SORT_LOWER;
    }

    public static boolean isSortHigher() {
        return !SORT_LOWER;
    }

    public static void setSortLower() {
        SORT_LOWER = true;
    }

    public static void setSortHigher() {
        SORT_LOWER = false;
    }

    // Comparable implementation
    public int compareTo(Value other) {
        if (isSortLower()) {
            if (this.value < other.value) {
                return -1;
            }
            else if(this.value > other.value) {
                return 1;
            }
        }
        else if (isSortHigher()) {
            if (this.value < other.value) {
                return 1;
            }
            else if(this.value > other.value) {
                return -1;
            }
        }

        return 0;
    }
}

// Comparator for preferring lower values
class PreferLowerValues implements Comparator<Value>{
    public int compare(Value v1, Value v2) {
        if (v1.getValue() < v2.getValue()) {
            return -1;
        }
        else if(v1.getValue() > v2.getValue()) {
            return 1;
        }

        return 0;
    }
}

// Comparator for preferring higher values
class PreferHigherValues implements Comparator<Value>{
    public int compare(Value v1, Value v2) {
        if (v1.getValue() < v2.getValue()) {
            return 1;
        }
        else if(v1.getValue() > v2.getValue()) {
            return -1;
        }

        return 0;
    }
}
