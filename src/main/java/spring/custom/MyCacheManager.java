package spring.custom;

import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * Created by max.lu on 2016/3/22.
 */
public class MyCacheManager extends AbstractCacheManager {

    Collection<? extends MyCache> caches;

    public void setCaches(Collection<? extends MyCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends MyCache> loadCaches() {
        return caches;
    }
}
