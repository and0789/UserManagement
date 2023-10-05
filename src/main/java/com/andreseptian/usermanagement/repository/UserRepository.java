package com.andreseptian.usermanagement.repository;

import com.andreseptian.usermanagement.domain.User;

import java.util.Collection;

public interface UserRepository<T extends User> {
    /* Basic CRUD Operations */
    T create(T data);

    Collection<T> list(int page, int pageSize);

    T get(Long id);

    T update(T data);

    Boolean delete(Long id);

    /* More Complex Operations */
    User getUserByEmail(String email);
}
