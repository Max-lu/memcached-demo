package custom;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by max.lu on 2016/3/21.
 */
public class AccountTest {

    private AccountService accountService;

    @Before
    public void loadConfig() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        accountService = applicationContext.getBean("accountService", AccountService.class);
    }

    @Test
    public void testLoadAccount() {
        accountService.loadAccount();
        accountService.loadAccount();

        accountService.evictCache();

        accountService.loadAccount();
        accountService.loadAccount();
    }
}
