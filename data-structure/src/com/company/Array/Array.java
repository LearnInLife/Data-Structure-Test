package com.company.Array;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(1);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组的容量
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        //如果数组已满,进行扩容
        if (index == data.length)
            resize(2 * data.length);

        
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newElement = (E[]) new Object[newCapacity];

        System.arraycopy(data, 0, newElement, 0, Math.min(data.length, newCapacity));

        data = newElement;
    }
}
