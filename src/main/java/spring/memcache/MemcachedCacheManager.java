package spring.memcache;

import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * Created by max.lu on 2016/3/22.
 */
public class MemcachedCacheManager extends AbstractCacheManager {

    Collection<? extends MemcachedCache> caches;

    public void setCaches(Collection<? extends MemcachedCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends MemcachedCache> loadCaches() {
        return caches;
    }

}
