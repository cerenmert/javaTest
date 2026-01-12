import org.account.Account;
import org.account.AdvancedBankSystem;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTest {

    @BeforeMethod
    public void setUp() {
        // Reset the database before each test to ensure isolation
        AdvancedBankSystem.getDatabase().clear();

        // Populate with initial test data
        AdvancedBankSystem.addAccount(111, new Account(111, 5000.0, "Carol"));
        AdvancedBankSystem.addAccount(222, new Account(222, 12500.0, "Bob"));
        AdvancedBankSystem.addAccount(333, new Account(333, 400.0, "Dennis"));
    }

    @Test
    public void testDeposit() {
        AdvancedBankSystem.deposit(111, 1500.0);
        Account acc = AdvancedBankSystem.getDatabase().get(111);
        Assert.assertEquals(acc.getBalance(), 6500.0, "Balance should increase by 1500");
    }

    @Test
    public void testWithdrawSuccess() {
        AdvancedBankSystem.withdraw(222, 3000.0);
        Account acc = AdvancedBankSystem.getDatabase().get(222);
        Assert.assertEquals(acc.getBalance(), 9500.0, "Balance should decrease by 3000");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        AdvancedBankSystem.withdraw(222, 20000.0);
        Account acc = AdvancedBankSystem.getDatabase().get(222);
        Assert.assertEquals(acc.getBalance(), 12500.0, "Balance should remain unchanged due to insufficient funds");
    }

    @Test
    public void testDeleteAccount() {
        AdvancedBankSystem.deleteAccount(333);
        Assert.assertFalse(AdvancedBankSystem.getDatabase().containsKey(333), "Account 333 should be deleted");
    }

    @Test
    public void testDeleteNonExistentAccount() {
        int initialSize = AdvancedBankSystem.getDatabase().size();
        AdvancedBankSystem.deleteAccount(999);
        Assert.assertEquals(AdvancedBankSystem.getDatabase().size(), initialSize,
                "Database size should not change when deleting non-existent account");
    }

    @Test
    public void testTakeLoan() {
        Account acc = AdvancedBankSystem.getDatabase().get(111);
        double initialBalance = acc.getBalance();
        double loanAmount = 1000.0;
        double expectedDebt = 1050.0; // 1000 * 1.05

        AdvancedBankSystem.takeLoan(111, loanAmount);

        Assert.assertEquals(acc.getBalance(), initialBalance + loanAmount, "Balance should include loan amount");
        Assert.assertEquals(acc.getDebt(), expectedDebt, "Debt should include interest");
    }

    @Test
    public void testPayLoanPartial() {
        // Setup loan first
        AdvancedBankSystem.takeLoan(111, 1000.0); // Debt: 1050

        AdvancedBankSystem.payLoan(111, 500.0);

        Account acc = AdvancedBankSystem.getDatabase().get(111);
        Assert.assertEquals(acc.getDebt(), 550.0, "Debt should reduce by payment amount");
    }

    @Test
    public void testPayLoanFull() {
        AdvancedBankSystem.takeLoan(111, 1000.0); // Debt: 1050
        // Balance: 5000 + 1000 = 6000

        AdvancedBankSystem.payLoan(111, 1050.0);

        Account acc = AdvancedBankSystem.getDatabase().get(111);
        Assert.assertEquals(acc.getDebt(), 0.0, "Debt should be fully paid");
        Assert.assertEquals(acc.getBalance(), 4950.0, "Balance should decrease by payment amount");
    }

    @Test
    public void testPayLoanOverpayment() {
        AdvancedBankSystem.takeLoan(111, 1000.0); // Debt: 1050

        // Try to pay 2000
        AdvancedBankSystem.payLoan(111, 2000.0);

        Account acc = AdvancedBankSystem.getDatabase().get(111);
        // Debt should remain 1050 because payment was rejected
        Assert.assertEquals(acc.getDebt(), 1050.0, "Debt should remain unchanged if overpayment is attempted");
    }
}
