package com.jusan.task.solidbank.classes;

import java.util.List;

public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    void updateAccount(Account account);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    AccountWithdraw getClientAccountWithdraw(String clientID, String accountID);
    Account getClientAccount(String clientID, String accountID);
}
