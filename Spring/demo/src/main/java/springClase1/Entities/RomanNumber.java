package springClase1.Entities;

import java.util.TreeMap;

public class RomanNumber {
    private String message;
    private String roman;
    private String decimal;

    public static RomanNumber convertir(String number){

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        String roman = toRoman(Integer.parseInt(number), map);
        String message = "Success";

        return new RomanNumber(message, number, roman);
    }

    private static String toRoman(int number, TreeMap<Integer, String> map) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l, map);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoman() {
        return roman;
    }

    public void setRoman(String roman) {
        this.roman = roman;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public RomanNumber(String message, String roman, String decimal) {
        this.message = message;
        this.decimal = decimal;
        this.roman = roman;
    }

}
