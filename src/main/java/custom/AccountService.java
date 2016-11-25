package custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by max.lu on 2016/3/21.
 */
@Service
public class AccountService {

    @Autowired
    private CacheContext<Account> cacheContext;

    public Account loadAccount() {
        if (cacheContext.get("account") != null) {
            System.out.println("query from cache...");
            return cacheContext.get("account");
        }
        Account account = getAccount();
        cacheContext.add("account", account);
        return account;
    }

    private Account getAccount() {
        System.out.println("query from db...");
        Account account = new Account();
        account.setName("max");
        account.setPassword("123456");
        return account;
    }

    public void evictCache() {
        cacheContext.evict("account");
        System.out.println("clear cache...");
    }
}
