package oop;

import java.io.File;
import java.util.Formatter;

class problem {
    public Node head;
    private int size;
    problem(){
        size =0;
    }
   public class Node{
      public   int a;
        public Node next;
        Node(int a){
            this.a = a;
            this.next = null;
            size++;
        }
    }
    public void addFirst(int a){
        Node newNode = new Node(a);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int a){
        Node newNode = new Node(a);
        if(head == null){
            head = newNode;
            return;
        }
        Node curntNode = head;
        while(curntNode.next != null) curntNode = curntNode.next;
        curntNode.next = newNode;
    }
    public  void printList(){
        if(head == null){
            System.out.println("link haven't created");
            return;
        }
        Node curntNode = head;
        while(curntNode != null) {
            System.out.printf(curntNode.a+" ");
            curntNode = curntNode.next;
        }
        System.out.println();
    }
    public int getSize(){
        return size;
    }
    public  int trvrs(int pos){
        Node temp = head;
        for(int i=2;i<=pos;i++) temp = temp.next;
        return temp.a;
    }
//    public void merge(problem a, problem b, problem list){
//        Node temp = a.head;
//        Node tmp = b.head;
//        while(temp!=null && tmp!=null){
//            if(temp.a<tmp.a){
//                list.addLast(temp.a);
//                temp = temp.next;
//            }
//            else{
//                list.addLast(tmp.a);
//                tmp = tmp.next;
//            }
//        }
//        while(temp!=null){
//            list.addLast(temp.a);
//            temp = temp.next;
//        }
//        while(tmp!=null){
//            list.addLast(tmp.a);
//            tmp = tmp.next;
//        }
//    }
    public static void main(String[] args){
        File dir = new File("/home/dell/LinkList");
        dir.mkdir();
        String path = dir.getAbsolutePath();
        File file1 = new File(path+"/file1.txt");
        File file2 = new File(path+"/file2.txt");
        try {
            file1.createNewFile();
            file2.createNewFile();
        }
        catch (Exception e){
            System.out.println(e);
        }
        problem list1 = new problem();
        problem list2 = new problem();
        try {
            Formatter frmt = new Formatter(path+"/file1.txt");
            Formatter frmt2 = new Formatter(path+"/file2.txt");
            int min = 9, max = 100;
            for(int i=0;i<50;i++){
                int x = (int)(Math.random()*(max-min+1)+min);
                list1.addLast(x);
                frmt.format("%d ",x);
            }
            for(int i=0;i<50;i++){
                int x = (int)(Math.random()*(max-min+1)+min);
                list2.addLast(x);
                frmt2.format("%d ",x);
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
//        for(int i=1;i<1000;i+=5) list1.addLast(i);
//        for(int i=2;i<1499;i+=3) list2.addLast(i);
        problem list3 = new problem();
        int l1sz = list1.getSize()+1, l2sz=list2.getSize()+1;
        int l1 = 1, l2= 1;

            Node temp1 = list1.head;
            Node temp2 = list2.head;
            while (temp1 != null && temp2 != null){
                if(temp1.a<= temp2.a){
                    list3.addLast(temp1.a);
                    temp1 = temp1.next;
                }
                else {
                    list3.addLast(temp2.a);
                    temp2 = temp2.next;
                }
            }
            while(temp1 != null){
                list3.addLast(temp1.a);
                temp1 = temp1.next;
            }
            while(temp2 != null){
                list3.addLast(temp2.a);
                temp2 = temp2.next;
            }
//            if(l1sz == l1){
//                list3.addLast(list2.trvrs(l2));
//                l2++;
//            }
//            else if(l2sz == l2){
//                list3.addLast((list1.trvrs(l1)));
//                l1++;
//            }
//            else if(list1.trvrs(l1) <= list2.trvrs(l2)){
//                list3.addLast(list1.trvrs(l1));
//                l1++;
//            }
//            else {
//                list3.addLast(list2.trvrs(l2));
//                l2++;
//            }
//
//        File merge = new File(path+"/merge.txt");
//        try {
//            merge.createNewFile();
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//        try {
//            Formatter frmt = new Formatter(path+"/merge.txt");
//            Node temp = list3.head;
//
//            while(temp.next != null){
//                frmt.format("%d ",temp.a);
//                temp = temp.next;
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
        list1.printList();
        list2.printList();
        list3.printList();

       // System.out.println( list1.trvrs(2));
    }
}
