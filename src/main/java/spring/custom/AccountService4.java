package spring.custom;

import custom.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by max.lu on 2016/3/22.
 */
@Service
public class AccountService4 {

    @Cacheable("account")
    public Account getAccount(String name) {
        System.out.println("query from db...");
        return new Account(name, "123456");
    }

    @CacheEvict(value = "account", allEntries = true, beforeInvocation = true)
    public void evictCache() {
        throw new RuntimeException();
    }
}
