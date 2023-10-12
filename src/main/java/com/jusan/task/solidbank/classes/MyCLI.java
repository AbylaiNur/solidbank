package com.jusan.task.solidbank.classes;

import java.util.Arrays;
import java.util.Scanner;

public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        System.out.println("Enter amount: ");
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            throw new RuntimeException("Invalid amount");
        }
    }

    public String requestClientAccountNumber() {
        System.out.println("Enter account number: ");
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException("Invalid account number");
        }
    }

    public AccountType requestAccountType() {
        System.out.println("Choose account type");
        System.out.println(Arrays.toString(AccountType.values()));

        String accountType = scanner.nextLine();
        boolean isAccountTypeValid = false;

        while (!isAccountTypeValid) {
            try {
                AccountType.valueOf(accountType);
                isAccountTypeValid = true;
            } catch (Exception e) {
                System.out.println("Invalid account type. Enter again.");
                accountType = scanner.nextLine();
            }
        }
        return AccountType.valueOf(accountType);
    }

    public Scanner getScanner() {
        return scanner;
    }
}
