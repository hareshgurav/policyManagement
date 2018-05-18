package com.oracle.policmgmt.redis;

public interface MessagePublisher {

    void publish(final String message);
}
