package org.account;

import java.util.HashMap;
import java.util.Map;

public class AdvancedBankSystem extends Account {
    // In-memory database simülation
    public static final Map<Integer, Account> database = new HashMap<>();

    public AdvancedBankSystem(int accountNo, double balance, String ownerName) {
        super(accountNo, balance, ownerName );
    }

    // Para Yatırma Metodu (Deposit)
    public static void deposit(int accountNo, double amount) {
        if (database.containsKey(accountNo)) {
            Account acc = database.get(accountNo);
            acc.setBalance(acc.getBalance() + amount);
            System.out.println(acc.getOwnerName() + " adlı kişinin " + accountNo + " nolu hesabına " + amount + " TL yatırıldı.");
        }
    }

    // Para Çekme Metodu (Withdraw)
    public static void withdraw(int accountNo, double amount) {
        Account acc = database.get(accountNo);
        if (acc != null) {
            if (acc.getBalance() >= amount) {
                acc.setBalance(acc.getBalance() - amount);
                System.out.println( acc.getOwnerName() + " adlı kişinin " + accountNo + " nolu hesabından " + amount + " TL çekildi.");
            } else {
                System.out.println("Hata: " + acc.getOwnerName() + " adlı kişinin " + accountNo + " nolu hesabı için yetersiz bakiye!");
                System.out.println( amount+ " TL çekilemez");
                System.out.println("En fazla çekilebilecek tutar: " + acc.getBalance() + " TL");
            }
        }
    }

    // Hesap Silme Metodu (Delete Account)
    public static void deleteAccount(int accountNo) {
        if (database.containsKey(accountNo)) {
            database.remove(accountNo);
            System.out.println(accountNo + " nolu hesap sistemden silindi.");
        } else {
            System.out.println("Hata: Silinmek istenen " + accountNo + " nolu hesap bulunamadı.");
        }
    }

}
