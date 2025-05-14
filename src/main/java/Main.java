import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        Faker faker = new Faker();
        var x = new ArrayList<BankAccount>();

        //        x.add(new CheckingAccount(new Person("Paulo", "Cunha", "000-00-0000", "pcunha@gmail.com", "000-000-0000", "XYZ st"), new BigDecimal(100)));
        //        x.add(new CheckingAccount(new Person("Wilmer", "Garcia", "999-99-9999", "wgarcia@gmail.com", "999-999-9999", "XYZ st"), new BigDecimal(200)));
                x.add(new SavingAccount(new Person("Samantha", "Rivera", "888-88-888", "sRivera@gmail.com", "888-888-8888", "XYZ st"), new BigDecimal(300)));

//        for (int i = 0; i < 10; i++) {
//            x.add(new CheckingAccount(new Person(faker.name().firstName(), faker.name().lastName(), faker.idNumber().ssnValid(),
//                    faker.name().lastName() + "@gmail.com".toLowerCase(), faker.phoneNumber().phoneNumber(), faker.address().streetAddress()),
//                    BigDecimal.valueOf(faker.number().randomDouble(2, 100, 10000)).setScale(2, RoundingMode.HALF_UP)));
//        }

        System.out.println();
        x.getFirst().withdraw(new BigDecimal("20"));
        System.out.println();
        x.getFirst().deposit(new BigDecimal(20));

        System.out.println();
        for (BankAccount account : x) {
            logger.info("AccountType: {},AccountHolder: {}, Balance: {}, Address: {}, Phone: {}, Email: {}",
                    account.getClass().getSimpleName(), account.getAccountHolder().getFirstName() + " " + account.getAccountHolder().getLastName(),
                    account.getBalance(), account.getAccountHolder().getAddress(), account.getAccountHolder().getPhone(), account.getAccountHolder().getEmail());

        }

    }

}
