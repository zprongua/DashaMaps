package com.github.zipcodewilmington;

public class SLL<T extends Comparable<T>> {

    private Node<T> head;

    public SLL<T> add(T data) {
        Node<T> add = new Node<>(data);
        if (this.head == null) {
            head = add;
        } else {
            Node<T> temp = head;
            while (temp.hasNext()) {
                temp = temp.getNext();
            }
            temp.setNext(add);
        }
        return this;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        Node<T> temp = this.head;
        if (index == 0) {
            this.head = this.head.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                if (temp.hasNext()) {
                    temp = temp.getNext();
                } else throw new IndexOutOfBoundsException();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Node<T> temp = this.head;
        for (int i = 0; i < index; i++) {
            if (temp.hasNext()) {
                temp = temp.getNext();
            } else throw new IndexOutOfBoundsException();
        }
        return temp.getData();
    }

    public int size() {
        Node<T> temp = this.head;
        int count = 0;
        while (temp != null) {
            count += 1;
            temp = temp.getNext();
        }
        return count;
    }

    public int find(T data) {
        Node<T> temp = this.head;
        int count = 0;
        while (temp != null) {
            if (data.compareTo(temp.getData()) == 0) {
                return count;
            }
            count += 1;
            temp = temp.getNext();
        }
        return -1;
    }

    public boolean contains(T data) {
        return this.find(data) != -1;
    }

    public SLL<T> copy() {
        SLL<T> copyList = new SLL<>();
        Node<T> temp = this.head;
        while (temp != null) {
            copyList.add(temp.getData());
            temp = temp.getNext();
        }
        return copyList;
    }
}