package org;


import org.controller.Validation;
import org.exception.InvalidCodeException;
import org.exception.NullValueException;
import org.exception.OutOfRangeNumberException;
import org.exception.RepetitionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Validation validation = new Validation();
        try {
            validation.get(new Scanner(System.in).nextLong());
        } catch (OutOfRangeNumberException | NullValueException | InvalidCodeException | RepetitionException | InputMismatchException e) {
            e.printStackTrace();
        }

    }
}
