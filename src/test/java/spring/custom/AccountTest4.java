package spring.custom;

import custom.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by max.lu on 2016/3/22.
 */
public class AccountTest4 {

    private AccountService4 accountService4;

    @Before
    public void loadConfig() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config3.xml");
        accountService4 = applicationContext.getBean("accountService4", AccountService4.class);
    }

    @Test
    public void testGetAccount() {
        System.out.println("first query");
        Account account1 = accountService4.getAccount("account1");
        System.out.println(account1.getPassword());
        Account account2 = accountService4.getAccount("account2");
        System.out.println(account2.getPassword());

        System.out.println("second query");
        Account account3 = accountService4.getAccount("account1");
        System.out.println(account3.getPassword());
        Account account4 = accountService4.getAccount("account2");
        System.out.println(account4.getPassword());
    }

    @Test
    public void evictCacheFail() {
        System.out.println("first query");
        accountService4.getAccount("account1");

        try {
            accountService4.evictCache();
        } catch (Exception e) {
            System.out.println("evict cache fail...");
        }

        System.out.println("second query");
        accountService4.getAccount("account1");
    }
}
