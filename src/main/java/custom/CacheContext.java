package custom;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by max.lu on 2016/3/21.
 */
public final class CacheContext<T> {

    private ConcurrentMap<String, T> caches = new ConcurrentHashMap<>();

    public T get(String name) {
        return caches.get(name);
    }

    public void add(String name, T value) {
        caches.putIfAbsent(name, value);
    }

    public void update(String name, T value) {
        caches.put(name, value);
    }

    public void evict(String name) {
        if (caches.containsKey(name)) {
            caches.remove(name);
        }
    }

    public void evictAll() {
        caches.clear();
    }
}
