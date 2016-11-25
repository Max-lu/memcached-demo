package memcached;

import net.spy.memcached.MemcachedClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by max.lu on 2016/3/22.
 */
public class TestMemcached {
    MemcachedClient memCachedClient;

    @Before
    public void beforeTest() {

        ApplicationContext atx = new ClassPathXmlApplicationContext("/memcached.xml");
        memCachedClient = (MemcachedClient) atx.getBean("memcachedClient");
    }


    @Test
    public void TestMem() {
        memCachedClient.add("name", 360000, "han");
        System.out.println(memCachedClient.get("name"));
    }
}
