package com.scuec.dao;

import java.util.List;

public interface BaseDao<T> {

    void add(T t);

    void update(T t);

    void delete(T t);

    T getByEamil(String email);

    List<T> getList();
}
