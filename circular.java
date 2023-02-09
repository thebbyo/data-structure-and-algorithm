package oop;
class circular{
    Node head;

    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(String data){

        Node newNode = new Node(data);
        if(head == null){
            newNode.next = newNode;
            head = newNode;
            return;
        }
        Node curntNode  = head;
        while(curntNode.next != head) curntNode = curntNode.next;
        curntNode.next = newNode;
        newNode.next = head;
        head = newNode;
    }
    public void printList(){

        if(head == null){
            System.out.println("link doesn't exist");
            return;
        }
        Node crntNode = head;
        do {
            System.out.printf(crntNode.data+" ");
            crntNode = crntNode.next;
        }while(crntNode != head);
        System.out.println();
    }
    public void addLast(String data){
        if(head == null){
            addFirst(data);
            return;
        }
        Node newNode  = new Node(data);

        Node curntNode  = head;
        while(curntNode.next != head) curntNode = curntNode.next;
        curntNode.next = newNode;
        newNode.next= head;
    }
    public void deleteFirst(){
       Node temp = head;
       while(temp.next != head){
           temp = temp.next;
       }
       temp.next = head.next;
       head = head.next;
    }
    public void deletetation(int pos){
        if(pos ==1){
            deleteFirst();
            return;
        }
        Node temp = head;
        int cnt =1;
        while(cnt != pos -1){
            temp = temp.next;
            cnt++;
        }
        Node todelete = temp.next;
        temp.next = temp.next.next;
    }

    public static void main(String args[]){
        circular list = new circular();
        list.addFirst("is");
        list.addFirst("name");
        list.addLast("Dibbyo");
        list.addFirst("My");
        list.printList();
        list.deletetation(1);
        list.printList();
        list.deletetation(3);
        list.printList();


    }
}