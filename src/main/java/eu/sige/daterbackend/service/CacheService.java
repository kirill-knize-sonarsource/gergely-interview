package eu.sige.daterbackend.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CacheService<T> {

    // Just a hint, can be more.
    public static final int CACHE_CAPACITY = 2;

    private final Deque<T> cache;

    public CacheService() {
        this.cache = new ArrayDeque<>(CACHE_CAPACITY);
    }

    public void add(T t) {
        cache.add(t);
    }

    public T getAndRemoveElement() {
        return cache.pop();
    }

    public int getActualSize() {
        return cache.size();
    }

}
