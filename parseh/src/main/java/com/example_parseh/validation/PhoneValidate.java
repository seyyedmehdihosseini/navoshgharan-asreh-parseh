package com.example_parseh.validation;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class PhoneValidate {
    public static boolean validationPhoneNumber(String phoneNumber){
        String[] array = phoneNumber.split("");
        byte[] arr = phoneNumber.getBytes(StandardCharsets.UTF_8);

        if (array.length==11){
            if (array[0].equals("0")&&array[1].equals("9")){
                return true;
            }else return false;
        }else return false;
    }
}
