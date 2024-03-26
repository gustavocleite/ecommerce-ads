package com.sale.ecommerce.interfaces;

import java.util.List;

public interface IGenericOperations<T,N> {
    T create(T entity);
    List<T> read();

    T read(N id);

    T update(N id, T entity);
    void delete(N id);
}
