import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {
    private final CheckingAccount bankAccount = new CheckingAccount(new Person("Paulo", "Cunha", "000-00-0000", "pcunha@gmail.com", "000-000-0000", "XYZ st"), new BigDecimal(100));

    @Test
    void deposit() {
        bankAccount.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(BigDecimal.valueOf(95));
        assertEquals(BigDecimal.valueOf(0.25).setScale(2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP), bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }
}