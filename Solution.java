package stack;

import java.util.Stack;

class Solution {
    public static   int[] finalPrices(int[] prices) {
        Stack<Integer> pr = new Stack<>();
        for(int i =0 ;i<prices.length;i++){
          while (!pr.isEmpty() && prices[i] <= prices[pr.peek()]) prices[pr.pop()]-=prices[i];
          pr.push(i);
    }
        return prices;
}

    public static void main(String[] args) {
        int[] arr = {8,4,6,2,3};
        arr = finalPrices(arr);
        for(int i=0; i<arr.length; i++) System.out.printf(arr[i]+" ");
    }
}