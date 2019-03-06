package com.company.Set;

public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSzie();
    boolean isEmpty();
}
