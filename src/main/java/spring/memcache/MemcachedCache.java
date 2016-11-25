package spring.memcache;

import net.spy.memcached.MemcachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * Created by max.lu on 2016/3/22.
 */
public class MemcachedCache implements Cache {

    private String name;
    private MemcachedClient memcachedClient;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.memcachedClient;
    }

    @Override
    public ValueWrapper get(Object o) {
        String key = getKey(o);
        Object o1 = memcachedClient.get(key);
        if (o1 != null) {
            return new SimpleValueWrapper(o1);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Object o, Class<T> aClass) {
        String key = getKey(o);
        return (T) memcachedClient.get(key);
    }

    @Override
    public void put(Object o, Object o1) {
        String key = getKey(o);
        memcachedClient.set(key, 360000, o1);
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object o) {
        memcachedClient.delete(getKey(o));
    }

    private String getKey(Object o) {
        if (o instanceof SimpleKey) {
            SimpleKey simpleKey = (SimpleKey) o;
            return this.name + "-" + simpleKey.hashCode();
        }
        return this.name + "-" + o.toString();
    }

    @Override
    public void clear() {
        memcachedClient.flush();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }
}
