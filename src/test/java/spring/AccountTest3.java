package spring;

import custom.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by max.lu on 2016/3/22.
 */
public class AccountTest3 {

    private AccountService3 accountService3;

    @Before
    public void loadConfig() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config2.xml");
        accountService3 = applicationContext.getBean("accountService3", AccountService3.class);
    }

    @Test
    public void testGetName() {
        Account account1 = new Account("account1");
        Account account2 = new Account("account2");
        System.out.println("--first query--");
        accountService3.getName(account1);
        accountService3.getName(account2);
        System.out.println("--clear cache by key--");
        accountService3.evictCache("account1");
        System.out.println("--second query--");
        accountService3.getName(account1);
        accountService3.getName(account2);
        System.out.println("--clear all cache--");
        accountService3.evictAllCache();
        System.out.println("--third query--");
        accountService3.getName(account1);
        accountService3.getName(account2);
    }
    @Test
    public void testGetPassword(){
        Account account1 = new Account("acc");
        Account account2 = new Account("account2");
        System.out.println("--first query--");
        accountService3.getPassword(account1);
        accountService3.getPassword(account2);
        System.out.println("--second query--");
        accountService3.getPassword(account1);
        accountService3.getPassword(account2);
    }

    @Test
    public void testGetAccount(){
        Account account1 = new Account("account1", "123456");
        Account account2 = new Account("account2", "654321");
        System.out.println("--first query--");
        accountService3.getAccount(account1);
        accountService3.getAccount(account2);
        System.out.println("--second query--");
        accountService3.getAccount(account1);
        accountService3.getAccount(account2);
        System.out.println("--clear cache by key--");
        accountService3.evictCache("account1123456");
        System.out.println("--third query--");
        accountService3.getAccount(account1);
        accountService3.getAccount(account2);
    }
    @Test
    public void testCachePut(){
        accountService3.getAccount2();
        accountService3.getAccount2();
        accountService3.getAccount3();
    }
}
