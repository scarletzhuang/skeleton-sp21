package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private BSTNode root;

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left, right;
        private int size;

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    private boolean containsKey(BSTNode node, K key) {
        if (node == null) return false;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return containsKey(node.left, key);
        } else if (cmp > 0) {
            return containsKey(node.right, key);
        } else {
            return true;
        }
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTNode node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    @Override
    public void put(K key, V value) {
        // consider the case of resetting the root
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode node, K key, V value) {
        if (node == null) {
            return new BSTNode(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Set<K> keySet() {
        return addKeySet(root, new HashSet<>());
    }

    private Set<K> addKeySet(BSTNode node, Set<K> keySet) {
        if (node == null) return keySet;
        keySet.add(node.key);

        addKeySet(node.left, keySet);
        addKeySet(node.right, keySet);

        return keySet;
    }

    @Override
    public V remove(K key) {
        V removedValue = get(key);
        root = remove(root, key); // consider the case of resetting the root
        return removedValue;
    }

    private BSTNode remove(BSTNode node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left =  remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            BSTNode removed = node;
            node = min(removed.right);
            node.right = removeMin(removed.right);
            node.left = removed.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private BSTNode removeMin(BSTNode node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        node.size = size(node.left) + size(node.left) - 1;
        return node;
    }

    private BSTNode min(BSTNode node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    @Override
    public V remove(K key, V value) {
        V removedValue = get(key);
        if (removedValue != value) return null;
        root = remove(root, key);
        return removedValue;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapKeyIterator();
    }

    private class BSTMapKeyIterator implements Iterator<K> {
        private Iterator<K> keySetItr;
        public BSTMapKeyIterator() {
            keySetItr = keySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return keySetItr.hasNext();
        }

        @Override
        public K next() {
            return keySetItr.next();
        }
    }

    public void printInOrder() {
        for (K k: this) {
            System.out.println(k + ": " + get(k));
        }
    }
}

