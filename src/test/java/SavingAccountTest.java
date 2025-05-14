import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private final SavingAccount bankAccount = new SavingAccount(new Person("Paulo", "Cunha", "000-00-0000", "pcunha@gmail.com", "000-000-0000", "XYZ st"), new BigDecimal(100));

    @Test
    void deposit() {
        bankAccount.deposit(new BigDecimal(100));
        assertEquals(BigDecimal.valueOf(205).setScale(2, RoundingMode.HALF_UP), bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(new BigDecimal(100));
        assertEquals(BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP), bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }
}