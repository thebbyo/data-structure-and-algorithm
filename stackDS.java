package stack;

public class stackDS {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class stack{
        public static Node head = null;
        public static boolean isEmpty() {
            return head == null;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int pop(){
            if(isEmpty()) return -1;
            Node top = head;
            head = head.next;
            return top.data;
        }
        public static int peek(){
            if(isEmpty()) return -1;
            return head.data;
        }

    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(3);
        s.push(0);
        s.push(55);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());

    }

}
