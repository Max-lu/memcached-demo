package spring;

import custom.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by max.lu on 2016/3/22.
 */
@Service
public class AccountService3 {

    //spEL
    @Cacheable(value = "account", key = "#account.getName()")
    public void getName(Account account) {
        System.out.println(String.format("query from db [key=%s]...", account.getName()));
    }

    @CacheEvict(value = "account", key = "#name")
    public void evictCache(String name) {
        System.out.println(String.format("evict cache [key=%s]...", name));
    }

    @CacheEvict(value = "account", allEntries = true)
    public void evictAllCache() {
        System.out.println("evict all cache...");
    }

    @Cacheable(value = "account", key = "#account.getName()", condition = "#account.getName().length() <= 4")
    public void getPassword(Account account) {
        System.out.println(String.format("query from db [key=%s, nameLength=%s]...", account.getName(), account.getName().length()));
    }

    @Cacheable(value = "account", key = "#account.getName().concat(#account.getPassword())")
    public void getAccount(Account account) {
        System.out.println(String.format("query from db [key=%s]...", account.getName().concat(account.getPassword())));
    }

    @CachePut(value = "account")
    public void getAccount2() {
        System.out.println("query from db...[cacheput]");
    }

    @Cacheable(value = "account")
    public void getAccount3() {
        System.out.println("query from db...[cacheable]");
    }

}
