package com.jusan.task.solidbank.classes;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account account;
        String accountNumber = String.format("%03d%06d", bankID, accountID);

        switch (accountType) {
            case SAVINGS:
                account = new SavingAccount(accountType, accountNumber, clientID, 0.0, true);
                break;
            case CHECKING:
                account = new CheckingAccount(accountType, accountNumber, clientID, 0.0, true);
                break;
            case FIXED:
                account = new FixedAccount(accountType, accountNumber, clientID, 0.0, false);
                break;
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
        accountDAO.createNewAccount(account);
    }
}
