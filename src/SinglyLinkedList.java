public class SinglyLinkedList {
    Node head;

    public void addLast(int data){
        Node newNode = new Node(data);
        if ( head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if ( head == null){
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public int getNodeByIndex(int index){
        if ( index < 0){
            return -1;
        }
        Node temp = head;
        for ( int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void printListNode(){
        Node temp = head;
        while ( temp.getNext() != null){
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
        test.printListNode();
    }
}
