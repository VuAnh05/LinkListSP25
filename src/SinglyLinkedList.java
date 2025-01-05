public class SinglyLinkedList {
    Node head;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int getNodeByIndex(int index) {
        if (index < 0) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
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
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
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
            temp = temp.next;
        }
        newNode.next = temp;
        preNode.next = newNode;
    }

    public void removeFirst() {
        if (head == null)
            return;
        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        Node temp = head;
        Node preNode = null;
        if (head.next == null) {
            removeFirst();
        }
        while (temp.next != null) {
            preNode = temp;
            temp = temp.next;
        }
        preNode.next = null;
    }

    public void deleteAtIndex(int index) {
        Node temp = head;
        if (index >= getLength()) {
            return;
        }
        if (head == null) {
            return;
        }
        if (head.next == null) {
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
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            temp = temp.next.next;
        }

    }

    public int getLength() {
        Node temp = head;
        int cnt = 0;
        while (temp.next != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public void printListNode() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList test = new SinglyLinkedList();
        test.addFirst(1);
        test.addFirst(2);
        test.addLast(12);
        test.addLast(30);
        test.addFirst(51);
        // test.addNode2(3, 4);
        test.printListNode();
        test.deleteAtIndex(1);
        test.printListNode();
        System.out.println(test.getLength());
    }
}
