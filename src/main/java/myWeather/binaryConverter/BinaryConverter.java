package myWeather.binaryConverter;

/**
 * Created by Андрей on 11.01.2018.
 */
public class BinaryConverter {

    public static String stringToBinary(String s) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            binaryString.append(Integer.toBinaryString(c)).append(' ');
        }
        //System.out.println(binaryString);
        return binaryString.toString();
    }

    public static String binaryToString (String bs){
        StringBuilder stringBinary = new StringBuilder();
        String[] chars = bs.split(" ");
        for (int i = 0; i<chars.length; i++){
            stringBinary.append((char)Integer.parseInt(chars[i],2));
        }
        //System.out.println(stringBinary);
        return stringBinary.toString();
    }

}
