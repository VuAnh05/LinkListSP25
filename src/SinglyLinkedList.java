public class SinglyLinkedList {
    Node head;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public int getNodeByIndex(int index) {
        if (index < 0) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void addNode1(int index, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(nextNode);
        }
    }

    public void addNode2(int index, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        Node preNode = null;
        for (int i = 0; i < index; i++) {
            preNode = temp;
            temp = temp.getNext();
        }
        newNode.setNext(temp);
        preNode.setNext(newNode);
    }

    public void removeFirst() {
        if (head == null)
            return;
        head = head.getNext();
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        Node temp = head;
        Node preNode = null;
        if (head.getNext() == null) {
            removeFirst();
        }
        while (temp.getNext() != null) {
            preNode = temp;
            temp = temp.getNext();
        }
        preNode.setNext(null);
    }

    public void deleteAtIndex(int index) {
        Node temp = head;
        if (index >= getLength()) {
            return;
        }
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            removeFirst();
            return;
        }
        if (index < 0) {
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        if (temp != null && temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
        }

    }

    public int getLength() {
        Node temp = head;
        int cnt = 0;
        while (temp.getNext() != null) {
            cnt++;
            temp = temp.getNext();
        }
        return cnt;
    }

    public void printListNode() {
        Node temp = head;
        while (temp.getNext() != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList test = new SinglyLinkedList();
        test.addFirst(1);
        test.addFirst(2);
        test.addLast(12);
        test.addFirst(51);
        test.addNode2(3, 4);
        test.printListNode();
        test.deleteAtIndex(1);
        test.printListNode();
        System.out.println(test.getLength());
    }
}
