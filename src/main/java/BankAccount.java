import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class BankAccount {
    private final Person accountHolder;
    private BigDecimal balance;

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    public BankAccount(Person accountHolder, BigDecimal balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);
        balance = balance.add(amount);
        logger.info("Deposited: {}. New Balance: {}", amount, balance);
    }

    public void withdraw(BigDecimal amount) {
        validateAmount(amount);
        if (balance.compareTo(amount) < 0) throw new IllegalArgumentException("Insufficient balance for withdrawal");
        else {
            balance = balance.subtract(amount);
            logger.info("Withdrew {}. Balance: {}", amount, balance);
        }
    }

    public void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }
}
