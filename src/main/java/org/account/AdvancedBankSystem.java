package org.account;

import java.util.HashMap;
import java.util.Map;

public class AdvancedBankSystem extends Account {
    // In-memory database simülation
    private static final Map<Integer, Account> database = new HashMap<>();

    // Getter for database
    public static Map<Integer, Account> getDatabase() {
        return database;
    }

    public static void addAccount(int no, Account acc) {
        database.put(no, acc);
    }

    // Parametrized Constructor
    public AdvancedBankSystem(int accountNo, double balance, String ownerName) {
        super(accountNo, balance, ownerName);
    }

    // Para Yatırma Metodu (Deposit)
    public static void deposit(int accountNo, double amount) {
        if (database.containsKey(accountNo)) {
            Account acc = database.get(accountNo);
            acc.setBalance(acc.getBalance() + amount);
            System.out.println(
                    acc.getOwnerName() + " adlı kişinin " + accountNo + " nolu hesabına " + amount + " TL yatırıldı.");
        }
    }

    // Para Çekme Metodu (Withdraw)
    public static void withdraw(int accountNo, double amount) {
        Account acc = database.get(accountNo);
        if (acc != null) {
            if (acc.getBalance() >= amount) {
                acc.setBalance(acc.getBalance() - amount);
                System.out.println(acc.getOwnerName() + " adlı kişinin " + accountNo + " nolu hesabından " + amount
                        + " TL çekildi.");
            } else {
                System.out.println("Hata: " + acc.getOwnerName() + " adlı kişinin " + accountNo
                        + " nolu hesabı için yetersiz bakiye!");
                System.out.println(amount + " TL çekilemez");
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

    // Kredi Alma Metodu (Take Loan)
    public static void takeLoan(int accountNo, double amount) {
        if (database.containsKey(accountNo)) {
            Account acc = database.get(accountNo);
            if (amount > 0) {
                double totalDebt = amount * acc.getInterestRate();
                acc.setBalance(acc.getBalance() + amount);
                acc.setDebt(acc.getDebt() + totalDebt);
                System.out.println(acc.getOwnerName() + " " + amount + " TL kredi aldı. (Faizli Toplam Borç: "
                        + totalDebt + " TL)");
            } else {
                System.out.println("Hata: Geçersiz kredi tutarı.");
            }
        } else {
            System.out.println("Hata: " + accountNo + " nolu hesap bulunamadı.");
        }
    }

    // Kredi Ödeme Metodu (Pay Loan)
    public static void payLoan(int accountNo, double amount) {
        if (database.containsKey(accountNo)) {
            Account acc = database.get(accountNo);
            if (amount > 0) {
                if (acc.getBalance() >= amount) {
                    if (acc.getDebt() >= amount) { // Borcun tamamı veya bir kısmı ödeniyor
                        acc.setBalance(acc.getBalance() - amount);
                        acc.setDebt(acc.getDebt() - amount);
                        System.out.println(acc.getOwnerName() + " borcundan " + amount + " TL ödedi. Kalan Borç: "
                                + acc.getDebt() + " TL");
                    } else if (acc.getDebt() > 0) { // Borçtan fazlası ödenmek isteniyor ama borç var
                        System.out.println(acc.getOwnerName() + " borcundan fazla ödeme yapamazsınız. Kalan Borç: "
                                + acc.getDebt() + " TL");
                    } else {
                        System.out.println(acc.getOwnerName() + " zaten borcu yok.");
                    }
                } else {
                    System.out.println("Hata: Yetersiz bakiye.");
                }
            } else {
                System.out.println("Hata: Geçersiz ödeme tutarı.");
            }
        } else {
            System.out.println("Hata: " + accountNo + " nolu hesap bulunamadı.");
        }
    }

}
