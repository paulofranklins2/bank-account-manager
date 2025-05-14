import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingAccount extends BankAccount {
    private static final Logger logger = LoggerFactory.getLogger(SavingAccount.class);
    private static final BigDecimal BONUS_MULTIPLIER = BigDecimal.valueOf(1.05);

    public SavingAccount(Person accountHolder, BigDecimal balance) {
        super(accountHolder, balance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        logger.info("SavingAccount: Depositing {}", amount.setScale(2, RoundingMode.HALF_UP));
        logger.info("Old Balance: {}", getBalance());
        BigDecimal amountWithBonus = amount.multiply(BONUS_MULTIPLIER).setScale(2, RoundingMode.HALF_UP);
        super.deposit(amountWithBonus);
        logger.info("New Balance: {}", getBalance());
    }

    @Override
    public void withdraw(BigDecimal amount) {
        logger.info("SavingAccount: Withdrawing {}", amount.setScale(2, RoundingMode.HALF_UP));
        logger.info("Old Balance: {}", getBalance());
        super.withdraw(amount.setScale(2, RoundingMode.HALF_UP));
        logger.info("New Balance: {}", getBalance());
    }
}
