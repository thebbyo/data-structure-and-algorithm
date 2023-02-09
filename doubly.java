package oop;
class doubly{
    Node head;
    private int size ;
    doubly(){
        size = 0;
    }
    class Node{
        String data;
        Node next;
        Node prev;
        Node(String data){
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }
    public void addFirst(String data){

        Node newNode  = new Node(data);
        newNode.next = head;
        if(head != null) head.prev = newNode;
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
            crntNode = crntNode.next;
        }
        System.out.println();
    }
    public void addLast(String data){

        Node newNode = new Node(data);
        if(head == null){
            addFirst(data);
            return;
        }
        Node currntNode = head;
        while(currntNode.next != null) currntNode = currntNode.next;
        currntNode.next = newNode;
        newNode.prev = currntNode;
    }
    public void deleteFirst(){
        Node todelete =head;
        head = head.next;
        head.prev = null;
    }
    public void deletation(int pos){
        if(pos == 1){
            deleteFirst();
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count != pos){
            temp = temp.next;
            count++;
        }
        temp.prev.next= temp.next;
        if(temp.next != null) temp.next.prev= temp.prev;
    }
    public int getSize(){
        return size;
    }
    public static void main(String args[]){
        doubly list = new doubly();
        list.addFirst("is");
        list.addFirst("name");
        list.addLast("Dibbyo");
        list.addFirst("My");
        list.printList();
        System.out.println(list.getSize());
        list.printList();
        System.out.println(list.getSize());
        list.addFirst("hello!!");
        list.printList();
        list.deletation(2);
        list.printList();
        list.deletation(1);
        list.printList();
    }
}