package org.academiadecodigo.bootcamp.containers;


public class LinkedList {

    private Node head;
    private int length = 0;
    //private int index = -1;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        Node iterator = head;
        int cont=0;
        int data=0;
        while (iterator.getNext()!=null)
        {
            iterator = iterator.getNext();
            if(iterator.getData()!=null) {
                data = (int) iterator.getData();
            }
            while (data != cont) {
                if (indexOf(data) == index) {
                    return data;
                }
                cont+=1;
            }
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        Node iterator = head;
        int cont=0;
        while (iterator.getNext() != null){
            iterator=iterator.getNext();
            if(iterator.getData().equals(data)){
                return cont;
            }
            cont++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

        Node iterator = head;
        Node iteratorA;
        int cont=0;

        int trueData = indexOf(data);

            if (trueData ==0) {
                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
                if (cont == (trueData-1)){
                    iteratorA=iterator;
                    iteratorA.setNext(iterator.getNext().getNext());
                    length--;
                    return true;
                }
                cont++;
            }

        return false;

    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}
