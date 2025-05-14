import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private final BankAccount bankAccount = new BankAccount(new Person("Paulo", "Cunha", "000-00-0000", "pcunha@gmail.com", "000-000-0000", "XYZ st"), new BigDecimal(100));

    @Test
    void deposit() {
        bankAccount.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP),
                bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(BigDecimal.valueOf(100.00));
        assertEquals(BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP),
                bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void validateAmount() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.validateAmount(BigDecimal.valueOf(-100)));
    }

    @Test
    void getBalance() {
        assertEquals(BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP),
                bankAccount.getBalance().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void getAccountHolder() {
        assertEquals("Paulo", bankAccount.getAccountHolder().getFirstName());
        assertEquals("Cunha", bankAccount.getAccountHolder().getLastName());
        assertEquals("000-00-0000", bankAccount.getAccountHolder().getSsn());
        assertEquals("pcunha@gmail.com", bankAccount.getAccountHolder().getEmail());
        assertEquals("000-000-0000", bankAccount.getAccountHolder().getPhone());
        assertEquals("XYZ st", bankAccount.getAccountHolder().getAddress());
    }
}