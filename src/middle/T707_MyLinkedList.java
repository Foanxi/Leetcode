package middle;

import common.ListNode;

public class T707_MyLinkedList {
    ListNode head;
    int size;
    public T707_MyLinkedList() {
        head=new ListNode();
        size=0;
    }

    public int get(int index) {
        if (index>=size)return -1;
        ListNode cur=head.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        head.next= new ListNode(val,head.next);
        size++;
    }

    public void addAtTail(int val) {
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur=head;
        if(index<0)index=0;
        if(index>size)return ;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.next= new ListNode(val,cur.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index>=0&&index<size){
            ListNode cur=head;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            cur.next=cur.next.next;
            size--;
        }
    }

    @Override
    public String toString() {
        String s = "";
        ListNode cur = head.next;
        while (cur!=null){
            s+=cur.val;
            cur=cur.next;
        }
        return s;
    }
}


