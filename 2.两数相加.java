/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       return violence(l1,l2);
    }
    public ListNode violence(ListNode l1,ListNode l2){
        ListNode k1 =new ListNode(0);
        ListNode t1 = k1;
        int b = 0;
        b = add(l1.val,l2.val,k1,0);

        while(l1.next!= null && l2.next != null){
           l1 = l1.next;
           l2 = l2.next; 
           k1.next = new ListNode(0);
           k1 = k1.next;

          b =  add(l1.val,l2.val,k1,b);
          
        }
       b=  link(l1.next,k1,b);
        b= link(l2.next,k1,b);

        if(b!=0){
                   k1.next = new ListNode(b);
               }
        return t1;
   
        }


        public int add(int l1,int l2,ListNode k,int b){
            b = l1 + l2 + b;
            int res=0;
            if(b >= 10){
                k.val = b % 10;
                res = b /10 ;
            }else{
                k.val = b;
            }
            return res;
        }
        public int link(ListNode l1,ListNode k,int b){
            if(l1 == null){
                return b;
            }
            k.next = l1;
            k = k.next;
            b = add(k.val,0,k,b);
            while(b!=0 ){
                if(k.next!=null){
                k = k.next;
                b = add(k.val,0,k,b);
                }else{
                    k.next = new ListNode(b);
                    b = 0;
                }
               } 
               return b;
              
            }
 
        }

// @lc code=end

