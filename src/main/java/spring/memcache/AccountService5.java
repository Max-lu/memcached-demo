package spring.memcache;

import custom.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by max.lu on 2016/3/22.
 */
@Service
public class AccountService5 {

    @Cacheable("account")
    public Account getAccount(String name, String password) {
        System.out.println("query from db...");
        Account account = new Account(name, password);
        System.out.println(account.toString());
        return account;
    }

    @CacheEvict(value = "account", allEntries = true)
    public void evictCache() {
        System.out.println("evict all cache...");
    }

    @CacheEvict(value = "account", key = "#name")
    public void evictCache(String name) {
        System.out.println(String.format("evict cache[key=%s]...", name));
    }

}
