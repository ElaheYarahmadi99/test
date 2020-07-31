package org;


import org.controller.Validation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long code = scanner.nextLong();
        Validation validation = new Validation();
        validation.get(code);
    }
}
