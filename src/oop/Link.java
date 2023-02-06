import java.util.*;
class Link{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            list.addLast(sc.nextInt());
        }
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=25) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}