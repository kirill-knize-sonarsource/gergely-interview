package eu.sige.daterbackend.service;

import java.util.NoSuchElementException;

public class NoItemInCacheException extends Exception {
    public NoItemInCacheException(NoSuchElementException e) {
        super(e);
    }
}
