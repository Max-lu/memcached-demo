package spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by max.lu on 2016/3/21.
 */
public class AccountTest {

    private AccountService2 accountService2;

    @Before
    public void loadConfig() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config2.xml");
        accountService2 = applicationContext.getBean("accountService2", AccountService2.class);
    }

    @Test
    public void testLoadAccount() {
        System.out.println("first query");
        accountService2.loadAccount();
        System.out.println("second query");
        accountService2.loadAccount();

        accountService2.evictCache();
        System.out.println("third query");
        accountService2.loadAccount();

    }
}
