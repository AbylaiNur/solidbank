package com.jusan.task.solidbank;

import com.jusan.task.solidbank.classes.AccountBasicCLI;
import com.jusan.task.solidbank.classes.MyCLI;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SolidbankApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        MyCLI myCLI = context.getBean(MyCLI.class);

        String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
        System.out.println("Welcome to CLI bank service");
        System.out.println("Enter operation number");
        System.out.println(helpMessage);

        boolean isRunning = true;
        String clientID = "1";

        while (isRunning) {
            switch(myCLI.getScanner().nextLine()){
                case "1":
                    accountBasicCLI.getAccounts(clientID);
                    break;

                case "2":
                    accountBasicCLI.createAccountRequest(clientID);
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "6":
                    System.out.println(helpMessage);
                    break;

                case "7":
                    System.out.println("Application Closed");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Command not recognized!");
                    break;
            }
        }
        myCLI.getScanner().close();
        context.close();
    }
}
