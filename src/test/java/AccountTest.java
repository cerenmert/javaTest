import org.account.Account;
import org.testng.annotations.Test;

import static org.account.AdvancedBankSystem.*;

public class AccountTest {

    @Test
    public static void main(String[] args) {
        // First, populate the in-memory database with some accounts for testing
        addAccount(111, new Account(111, 5000.0, "Carol"));
        addAccount(222, new Account(222, 12500.0, "Bob"));
        addAccount(333, new Account(333, 400.0, "Dennis"));
        System.out.println("\nFirst Balances of Accounts:");
        getDatabase().forEach((id, acc) -> System.out.println("No: " + id + " -> " + acc));
        System.out.println("\n--- Bank Operation Simulation ---");

        // 1. Para Yatırma İşlemi
        deposit(111, 1500.0);

        // 2. Para Çekme İşlemi
        withdraw(222, 3000.0);

        // 3. Hesap Silme İşlemi
        deleteAccount(333);
        deleteAccount(444); // Olmayan hesap testi

        withdraw(222, 20000.0); // Yetersiz bakiye testi

        // Son durumu göster
        System.out.println("\nLast Balances of Accounts:");
        getDatabase().forEach((id, acc) -> System.out.println("No: " + id + " -> " + acc));
    }
}
