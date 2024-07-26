/*
*82. Remove Duplicates from Sorted List II
*Given a sorted linked list, delete all nodes that have duplicate numbers, 
*leaving only distinct numbers from the original list.

    //链表去重，把重复的节点全部删掉
    private ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        //new一个新的头节点，定义一个当前指针，和前一个节点指针
        ListNode fake_head=new ListNode(0),p=head,pre=fake_head;
        fake_head.next=head;
        while(p!=null){
            //找到下一个为不与当前节点重复的节点
            while(p.next!=null&&p.next.val==p.val)
                p=p.next;
            //如果是没有重复的节点，就把pre指针往后移，当前指针也往后移
            if(pre.next==p)
                pre=pre.next;
            else
                //如果有重复的节点，就把pre的next指向当前节点的下一节点，即为不重复的节点
                pre.next=p.next;
            p=p.next;
        }
        return fake_head.next;
    }
    
    //递归法去重
        private ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;    
        //如果头节点和下一个节点重复了，则往后移动头节点，直到下一节点不重复
        if(head.next!=null&&head.val==head.next.val){
            while(head.next!=null&&head.val==head.next.val)
                head=head.next;
            //再进入递归，删除head.next为首的链表
            return deleteDuplicates(head.next);
        }
        //如果不重复，则头节点的后面接上去重后的链表
        else{
            head.next=deleteDuplicates(head.next);
        }

        return head;
    }
