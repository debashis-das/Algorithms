package deva.com.datastructure.linkedList;

public class SLL {

    public SLLNode head;

    public static void main(String[] args){
        SLL sll = new SLL();
        sll.addNodeAtHead(5);
        sll.addNodeAtHead(4);
        sll.addNodeAtHead(3);
        sll.addNodeAtHead(2);
        sll.addNodeAtHead(1);
        sll.addNodeAtHead(0);
        sll.addNodeAtTail(6);
        sll.printNodes();
    }

    public void addNodeAtHead(int data){
        SLLNode newNode;
        if(head == null){
            newNode = new SLLNode(data,null);
        }else{
            newNode = new SLLNode(data,head);
        }
        head = newNode;
    }

    public void addNodeAtTail(int data){
        SLLNode newNode = new SLLNode(data, null);
        if(head != null) {
            SLLNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }else{
            head = newNode;
        }
    }

    public void printNodes(){
        SLLNode node = head;
        while(node.next != null){
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print(node.data);
        System.out.println();
    }
}
