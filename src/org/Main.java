package org;


import org.controller.Validation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Validation validation = new Validation();
        validation.get(new Scanner(System.in).nextLong());
        System.out.println("Hello My Name Is Ehsan");
    }
}
