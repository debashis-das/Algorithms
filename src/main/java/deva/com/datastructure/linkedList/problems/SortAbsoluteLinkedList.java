package deva.com.datastructure.linkedList.problems;

import deva.com.datastructure.linkedList.SLL;
import deva.com.datastructure.linkedList.SLLNode;

public class SortAbsoluteLinkedList {

    SLL sll;

    public static void main(String[] args){
        SortAbsoluteLinkedList sortAbsoluteLinkedList = new SortAbsoluteLinkedList();
        sortAbsoluteLinkedList.execute();
    }

    public void execute(){
        sll = new SLL();
        sll.addNodeAtHead(5);
        sll.addNodeAtHead(4);
        sll.addNodeAtHead(-3);
        sll.addNodeAtHead(2);
        sll.addNodeAtHead(-1);
        sll.addNodeAtHead(0);
        sll.addNodeAtTail(6);
        sll.printNodes();
        sortLinkedList();
        sll.printNodes();
    }

    public void sortLinkedList(){
        SLLNode current = sll.head;
        SLLNode previous = null;
        while(current != null){
            if(current.data < 0 && previous != null){
                previous.next = current.next;
                current.next = sll.head;
                sll.head = current;
                current = previous.next;
            }else {
                previous = current;
                current = current.next;
            }
        }
    }
}
