package string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by aman on 5/29/17.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        System.out.println("hello");

        //1.Initializtion
        String sample1 = new String("hello");
        String sample2 = "hello2";
        char[] charsample = {'a', 'b', 'c'};
        String sample3 = new String(charsample);
        String sample4 = new String();
        byte[] byteArray = new byte[]{87, 79, 87, 46, 46, 46, 30, 59, 3};

        String value = new String(byteArray);
        String value3 = new String(byteArray, "UTF-8");

        System.out.println(value);
        System.out.println(value3);

        StringBuilder builder = new StringBuilder("ibytecode.com");
        String s9 = new String(builder);
        System.out.println("s9 = " + s9);

        StringBuffer sb = new StringBuffer("theopentutorials.com");
        String s8 = new String(sb);
        System.out.println("s8 = " + s8);

        byte bytes[] = {'w', 'o', 'r', 'l', 'd'};
        String s4 = new String(bytes);
        System.out.println("s4 = " + s4);


        String s = "hello";
        System.out.println("string length=" + s.length());

        //Modification
        String s1 = "hello ram ";

        System.out.println("replace char:" + s1.replace('h', 'r'));
        System.out.println("replace charsequence:" + s1.replace("he", "she"));
        System.out.println("replace all:" + s1.replaceAll("a", "b"));
        System.out.println("replace a" + s1.replaceFirst("l", "k"));

        System.out.println("concat:" + s1.concat("sita is your gf"));
        System.out.println("substring:" + s1.subSequence(3, 5));
        System.out.println("trim:" + s1.trim());
        //search
        System.out.println("index of l:" + s1.indexOf("l"));
        System.out.println("index of lo:" + s1.indexOf("lo"));
        System.out.println("last index of l :" + s1.lastIndexOf("l"));
        System.out.println("index of hel" + s1.lastIndexOf("el"));
        System.out.println("last index of hel:" + s1.lastIndexOf("hel"));


        //Case
        System.out.println("uppercase" + s1.toUpperCase());
        System.out.println("lowercase" + s1.toLowerCase());
        Locale locale = Locale.ENGLISH;
        System.out.println("upsercase locale" + s1.toUpperCase(Locale.FRANCE));
        //Extraction
        System.out.println("charAt" + s1.charAt(3));

        String source = "This is a demo";
        char[] target = new char[15];
        target[0] = '*';
        target[1] = '/';
        source.getChars(5, source.length(), target, 2);
        System.out.println(Arrays.toString(target));


        System.out.println(Arrays.toString("@test string".getBytes()));
        System.out.println(Arrays.toString("@test string".getBytes("US-ASCII")));
        System.out.println(Arrays.toString("@test string".getBytes(Charset.forName("UTF-8"))));


        // String declaration
        String stringValue = "This is a sample string";
        // Convert String to char array
        char[] charArray = stringValue.toCharArray();
        // array printing of character array
        System.out.println(Arrays.toString(charArray));
        System.out.println();

        //comparision
        // String object initialization
        String stringExample = "example startswith";

        // sample check using the startswith method
        if (stringExample.startsWith("exam")) {
            System.out.println("The string " + stringExample
                    + " starts with exam");
        } else {
            System.out.println("starts with argument return false");
        }

        if (stringExample.startsWith("a", 10)) {
            System.out.print("Success check in using offset");
        } else {
            System.out.println("No match at all");
        }

//ENDS WITH
        String stringExample1 = "This is sample string";
        // Check if the string is ends with ing
        if (stringExample1.endsWith("ing")) {
            System.out.println("String ends with 'ing'");
        } else {
            System.out.println("It does not match at all");
        }

        //VALUE OF

        // declare a sample string value
        String strValue = "Will Smith-Male-USA";
        // check if String value contains a specific string
        boolean bool = strValue.contains("Male");
        // print the string equivalent of our boolean check
        System.out.println(String.valueOf(bool));
//
        //comparte to
        System.out.println("bc".compareTo("bac"));
        System.out.println("e".compareTo("test"));
        System.out.println("test".compareTo("tests"));
        String firstString = "Hello";
        String str = new String("ew");
        System.out.println(firstString.compareTo(str));
        //hash code
        String stringExample3 = "This is sampel String";
        System.out.println("Hash Code:" + stringExample.hashCode());

        //other
        String input = "This is example demo of isEmpty method";
        if (input.isEmpty()) {
            System.out.println("String input is empty with length " + input.length());
        } else {
            System.out.println("String input is not empty with length " + input.length());
        }
        System.out.println("".isEmpty());


        String str3 = "JAVA";
        System.out.println("String = " + str3);

        // codepoint at index 1
        int retval = str3.codePointAt(1);

        // prints character at index1 in string
        System.out.println("Character(unicode point) = " + retval);

        String joinString1 = String.join("-", "welcome", "to", "javatpoint");
        System.out.println(joinString1);

        String sr = new String("hello");
        String sx = new String("hello");
        System.out.println(sr == sx);
        System.out.println(sr.hashCode());
        String s2 = "hello";
        System.out.println(s2.hashCode());
        String s3 = sr.intern();//returns string from pool, now it will be same as s2
        System.out.println(sr == s2);//false because reference is different
        System.out.println(s2 == s3);//true because reference is same
        System.out.println(sr.equals(s2));
        System.out.println(sr.intern() == s2.intern());
        System.out.println(sr == s2);


        //diffrent obj
        String test2 = new String("raj");
        String intern = test2.intern();
        String test = "raj";
        System.out.println(test == intern);
        System.out.println(test2.intern()==test2);
        System.out.println(test.intern()==test);

        test.wait();
    }
}
