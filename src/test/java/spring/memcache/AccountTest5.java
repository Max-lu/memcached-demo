package spring.memcache;

import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.DefaultHashAlgorithm;
import net.spy.memcached.FailureMode;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.spring.MemcachedClientFactoryBean;
import net.spy.memcached.transcoders.SerializingTranscoder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by max.lu on 2016/3/22.
 */
public class AccountTest5 {
    private AccountService5 accountService5;

    private MemcachedClient memcachedClient;

    @Before
    public void loadConfig() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config4.xml");
        accountService5 = applicationContext.getBean("accountService5", AccountService5.class);
        memcachedClient = applicationContext.getBean("memcachedClient", MemcachedClient.class);
    }

    @Test
    public void testGetAccount() {
        System.out.println("first query");
        accountService5.getAccount("account1", "123456");
        accountService5.getAccount("account2", "654321");

        System.out.println("second query");
        accountService5.getAccount("account1", "123456");
        accountService5.getAccount("account2", "654321");

        accountService5.evictCache("-376454400");

        System.out.println("third query");
        accountService5.getAccount("account1", "123456");
        accountService5.getAccount("account2", "654321");

    }

    @Test
    public void shutdown() {
        memcachedClient.shutdown();
    }

    @Test
    public void clear() {
        accountService5.evictCache();
    }

    @Test
    public void isServiceStarted() throws Exception {
        MemcachedClientFactoryBean factory = new MemcachedClientFactoryBean();
        factory.setServers("127.0.0.1:11211");
        factory.setOpTimeout(30000);
        factory.setProtocol(ConnectionFactoryBuilder.Protocol.TEXT);
        MemcachedClient memcachedClient = (MemcachedClient) factory.getObject();
        memcachedClient.set("max", 30000, "lu");
        System.out.println(memcachedClient.get("max"));
    }

}
