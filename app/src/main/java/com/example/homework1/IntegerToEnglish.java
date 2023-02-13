package com.example.homework1;

import java.util.LinkedList;

public class IntegerToEnglish {
    private final String[] belowTen = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private final String[] belowTwenty = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final String[] belowHundred = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }

        LinkedList<String> parts = new LinkedList<>();
        int billion = num / 1000000000;
        if (billion != 0) {
            parts.addLast(numberToWords(billion) + " billion");
            num -= billion * 1000000000;
        }
        int million = num / 1000000;
        if (million != 0) {
            parts.addLast(numberToWords(million) + " million");
            num -= million * 1000000;
        }
        int thousand = num / 1000;
        if (thousand != 0) {
            parts.addLast(numberToWords(thousand) + " thousand");
            num -= thousand * 1000;
        }
        int hundred = num / 100;
        if (hundred != 0) {
            parts.addLast(numberToWords(hundred) + " hundred");
            num -= hundred * 100;
        }
        if (num < 10) {
            parts.addLast(belowTen[num]);
        } else if (num < 20) {
            parts.addLast(belowTwenty[num - 10]);
        } else {
            int ten = num / 10;
            parts.addLast(belowHundred[ten]);
            if (num % 10 != 0) {
                parts.addLast(belowTen[num % 10]);
            }
        }
        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }
}

