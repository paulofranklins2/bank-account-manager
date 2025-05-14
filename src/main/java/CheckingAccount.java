import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckingAccount extends BankAccount {
    private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);
    private static final BigDecimal WITHDRAW_FEE_RATE = BigDecimal.valueOf(1.05);
    public CheckingAccount(Person accountHolder, BigDecimal balance) {
        super(accountHolder, balance);
    }


    @Override
    public void deposit(BigDecimal amount) {
        logger.info("Checking Account - Depositing {}", amount.setScale(2, RoundingMode.HALF_UP));
        logger.info("Old Balance: {}", getBalance());
        super.deposit(amount.setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public void withdraw(BigDecimal amount) {
        var fee = amount.multiply(WITHDRAW_FEE_RATE).subtract(amount).setScale(2, RoundingMode.HALF_UP);
        var totalToWithdraw = amount.add(fee).setScale(2, RoundingMode.HALF_UP);

        logger.info("Checking Account - Withdrawal: {}", amount.setScale(2, RoundingMode.HALF_UP));
        logger.info("Old Balance: {}", getBalance());
        logger.info("Withdraw Fee: {}", fee);

        super.withdraw(totalToWithdraw);
    }

}
