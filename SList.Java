/* 
    Simple linked list implementation for COMPX201, assignment 1
    Author: Yuan (Edward) Wang 
    Student ID: 1144995
*/

class SList {

    // Node for a linked list. Default constructor for a single node links
    // to a null key as a placeholder.
    public class SNode {

        public String key;
        public SNode next;

        public SNode(String key) {
            key = key;
            next = null;
        };
    }

    private SNode head = null;
    
    // add a new string to the head of the linked list
    public void add(String key) {

        SNode newNode = new SNode(key);
        newNode.next = head;
    }

    public Bool has(String key) {

        if ( search(key, head) != null ){
            return true;
        }
        return false;
    }

    //dodgy 
    public void remove(String testKey) {

        SNode readHead = this.head;
        SNode readHeadPlusOne = this.head.next;
        
        // handle the case of the first node being the removed one
        if readHead != null{
            if testKey.equals(this.head.key){
                //  I hope garbage collection works the way I think it does
                this.head = this.head.next;
                return
            }
        }

        // handle the inductive case
        while readHeadPlusOne != null {
            if testKey.equals(readHeadPlusOne.key){
                readHead.next = readHeadPlusOne.next;
                return
            }
            readHead = readHead.next;
            readHeadPlusOne = readHeadPlusOne.next;
        }
    }

    public int length() {

        int len = 0;
        SNode readHead = this.head;

        while readHead != null {
            readHead = readHead.next;
            len++;
        }
        
        return len;
    }

    public Bool isEmpty(String key) {

        return ( this.length() == 0 );        
    }

    public void dump() {

        SNode readHead = this.head;
        while readHead != null {
            readHead = readHead.next;
            System.out.println(readHead.key);
        }
    }

    // TODO: reduce repetition of the while loop using this method?
    private SNode search(String testKey, SNode readHead) {

        SNode readHead = this.head;
        while readHead != null {
            readHead = readHead.next;
            if testKey.equals(node.key){
                return node;
            }
        }
        return null;
    }

} 
