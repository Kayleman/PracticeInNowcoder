package sword_refers_to_offer;

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/

/*
 * 题目描述:
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * 解题思路:
 * 把链表的节点先都复制一遍,例如A->B->C 复制成A->A'->B->B'->C->C'
 * 1.由于节点有next和random连个指针,所以要分别复制
 * 2.先复制next节点
 * 3.复制完next节点之后,可以知道原节点的next是原节点的复制,应该把这个复制的random
 *   指向原节点random之后的next节点,因为random之后的next节点是这个random节点的复制节点
 * 4.最后来进行节点的拆分,即新的head为pHead的后一个节点
 * */
public class CloneRandomLinkedList {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
        	return null;
        }
        
        RandomListNode pCur = pHead;
        //复制所有节点
        while(pCur != null) {
        	RandomListNode copyNode = new RandomListNode(pCur.label);
        	copyNode.next = pCur.next;
        	pCur.next = copyNode;
        	pCur = copyNode.next;
        }
        
        pCur = pHead;
        //将所有复制节点的random节点进行链接
        while(pCur != null) {
        	if(pCur.random != null) {
        		pCur.next.random = pCur.random.next;
        	}
        	pCur = pCur.next.next;
        }
        
        RandomListNode head = pHead.next;
        RandomListNode hCur = head;
        pCur = pHead;
        //拆分节点
        while(pCur != null) {
        	pCur.next = pCur.next.next;
        	if(hCur.next != null) {
        		hCur.next = hCur.next.next;
        	}
        	pCur = pCur.next;
        	hCur = hCur.next;
        }
        
        return head;
    }
}