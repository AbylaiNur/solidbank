package com.jusan.task.solidbank.classes;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountsList;

    public MemoryAccountDAO() {
        this.accountsList = new ArrayList<>();
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountsList.stream()
                .filter(account -> account.getClientID().equals(clientID)).toList();
    }

    @Override
    public void createNewAccount(Account account) {
        accountsList.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        Account accountToUpdate = accountsList.stream()
                .filter(account1 -> account1.getClientID().equals(account.getClientID())
                        && account1.getId().equals(account.getId())).findFirst().get();

        accountToUpdate.setBalance(account.getBalance());
        accountToUpdate.setWithdrawAllowed(account.isWithdrawAllowed());
        accountToUpdate.setAccountType(account.getAccountType());
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountsList.stream()
                .filter(account -> account.getClientID().equals(clientID)
                        && account.getAccountType().equals(accountType)).toList();
    }

    @Override
    public AccountWithdraw getClientAccountWithdraw(String clientID, String accountID) {
        return (AccountWithdraw) accountsList.stream()
                .filter(account -> account.getClientID().equals(clientID)
                        && account.getId().equals(accountID)).findFirst().get();
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountsList.stream()
                .filter(account -> account.getClientID().equals(clientID)
                        && account.getId().equals(accountID)).findFirst().get();
    }
}
