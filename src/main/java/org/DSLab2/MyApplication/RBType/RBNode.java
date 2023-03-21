package org.DSLab2.MyApplication.RBType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RBNode<T extends Comparable<T>> {
    private T value;
    private RBNode<T> parent = null;
    private RBNode<T> leftChild = null;
    private RBNode<T> rightChild = null;
    private boolean color = false; // true -> red, false -> black

    public RBNode(T value) {
        this.value = value;
    }

    public RBNode(T value, RBNode<T> node, boolean color) {
        this.value = value;
        this.color = color;
        this.parent = node;
    }

    public boolean isColor() {
        return color;
    }
}
