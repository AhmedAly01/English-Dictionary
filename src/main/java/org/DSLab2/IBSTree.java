package org.DSLab2;

interface IBSTree<T extends Comparable <? super T>> {
    public int size();

    public boolean isEmpty();

    public boolean search(T data);

    public boolean insert(T data);

    public boolean delete(T data);

    public int height();


}
