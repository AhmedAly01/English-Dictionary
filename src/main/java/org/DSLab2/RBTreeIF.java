public interface RBTreeIF<T extends Comparable<T>> {
    RBNode<T> insert(T key);
    RBNode<T> delete(T key);
    RBNode<T> find(T key);
    int size();
    int height();
}
