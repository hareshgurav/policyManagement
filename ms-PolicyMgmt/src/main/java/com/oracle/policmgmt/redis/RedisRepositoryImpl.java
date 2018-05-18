package com.oracle.policmgmt.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.policymgmt.model.User;

import java.util.Map;
import javax.annotation.PostConstruct;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "User";
    
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    public void add(final User user) {
        hashOperations.put(KEY, "sessionUser" , user.getUserid());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }
    
    public User findUser(final String id){
        return (User) hashOperations.get(KEY, id);
    }
    
    public Map<Object, Object> findAllUsers(){
        return hashOperations.entries(KEY);
    }

  
}
