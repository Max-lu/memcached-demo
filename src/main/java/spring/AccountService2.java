package spring;

import custom.Account;
import custom.CacheContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by max.lu on 2016/3/21.
 */
@Service
public class AccountService2 {

    @Cacheable("account") //todo private 方法缓存失效？？
    public Account loadAccount() {
        System.out.println("query from db...");
        Account account = new Account();
        account.setName("max");
        account.setPassword("123456");
        return account;
    }

    @CacheEvict("account")
    public void evictCache() {
        System.out.println("evict cache...");
    }
}
