package com.oracle.policmgmt.redis;

import java.util.Map;
import java.util.Set;

import com.oracle.policymgmt.model.User;

public interface RedisRepository {

    /**
     * Return all Users
     */
    Map<Object, Object> findAllUsers();

    /**
     * Add key-value pair to Redis.
     */
    void add(User User);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);
    
    /**
     * find a User
     */
    User findUser(String id);
    
}
