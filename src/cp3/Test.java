package cp3;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(886, 04, 22223344);

        System.out.println(phoneNumber);

        Object o = new Object();
        String[] s ;

        phoneNumber.clone();


        int[] a = {1,3,3};
        int[] b = a.clone();

        System.out.println(Arrays.toString(b));
    }
}
