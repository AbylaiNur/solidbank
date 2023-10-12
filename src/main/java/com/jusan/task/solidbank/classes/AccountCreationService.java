package com.jusan.task.solidbank.classes;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
