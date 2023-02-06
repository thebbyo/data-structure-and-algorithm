package oop;
class LL{
    Node head;
    private int size ;
    LL(){
        size =0;
    }
    class Node{
     String data;
     Node next;
     Node(String data){
     this.data = data;
     this.next = null;
     size++;
     }
    }
    public void addFirst(String data){
       Node newNode = new Node(data);
       if(head == null){
           head = newNode;
           return;
       }
       newNode.next = head;
       head = newNode;
    }
    public void printList(){
        if(head == null){
            System.out.println("link doesn't exist");
            return;
        }
        Node crntNode = head;
        while(crntNode != null){
            System.out.printf(crntNode.data+" ");
            crntNode= crntNode.next;
        }
        System.out.println();
    }
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curntNode = head;
        while (curntNode.next != null) curntNode = curntNode.next;
        curntNode.next = newNode;
    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("link doesn't exist");
            return;
        }
        size--;
        head = head.next;
    }
    public void deleteLast(){
        if(head == null){
            System.out.println("lint doesn't exist");
        }
        size--;
       Node secondLast = head;
       Node lastNode = head.next;
       if(head.next == null) {
           head = null;
           return;
       }
       while (lastNode.next != null){
           secondLast = secondLast.next;
           lastNode = lastNode.next;
       }
       secondLast.next = null;
    }
    public int getSize(){
        return size;
    }
    public static void main(String args[]){
        LL list = new LL();
        list.addFirst("is");
        list.addFirst("name");
        list.addLast("Dibbyo");
        list.addFirst("My");
        list.printList();
        System.out.println(list.getSize());
        list.deleteLast();
        list.printList();
        System.out.println(list.getSize());
    }
}