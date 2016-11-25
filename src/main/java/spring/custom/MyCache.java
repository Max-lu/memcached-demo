package spring.custom;

import custom.Account;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by max.lu on 2016/3/22.
 */
public class MyCache implements Cache {

    private String name;
    private Map<String, Account> cache = new HashMap<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return cache;
    }

    @Override
    public ValueWrapper get(Object o) {
//        System.out.println("get value wrapper");
        ValueWrapper valueWrapper = null;
        Account account = cache.get(o.toString());
        if (account != null) {
            account.setPassword("change password:" + account.getPassword());
            valueWrapper = new SimpleValueWrapper(account);
        }
        return valueWrapper;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Object o, Class<T> aClass) {
//        System.out.println("get T");
        return (T) cache.get(o.toString());
    }

    @Override
    public void put(Object o, Object o1) {
        if (!(o1 instanceof Account)) {
            return;
        }
        cache.put((String) o, (Account) o1);
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        if (!(o1 instanceof Account)) {
            throw new RuntimeException();
        }
        Account result = cache.put((String) o, (Account) o1);
        return new SimpleValueWrapper(result);
    }

    @Override
    public void evict(Object o) {
        String name = (String) o;
        if (cache.containsKey(name)) {
            cache.remove(name);
        }
    }

    @Override
    public void clear() {
        cache.clear();
    }

    public void setName(String name) {
        this.name = name;
    }
}
