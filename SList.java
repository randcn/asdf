/* 
    Simple linked list implementation for COMPX201, assignment 1
    Author: Yuan (Edward) Wang 
    Student ID: 1144995
*/

class SList {

    // Node for a linked list. Default constructor for a single node links
    // to a null key as a placeholder.
    public class SNode {

        String key;
        SNode next;

        SNode(String k) {
            key = k;
            next = null;
        };
    }

    private SNode head;

    // add a new string to the head of the linked list
    public void add(String key) {

        SNode newNode = new SNode(key);
        newNode.next = head;
        this.head = newNode;
    }

    // loops through the list, returns true if the test key matches the read head
    public boolean has(String testKey) {

        SNode readHead = this.head;
        while (readHead != null) {
            if (readHead.key.equals(testKey)) {
                return true;
            }
            readHead = readHead.next;
        }
        return false;
    }

    // dodgy - how do references work in java??? 
    public void remove(String testKey) {

        SNode readHead = this.head;
        SNode readHeadPlusOne = this.head.next;

        // handle the case of the first node being the removed one
        if (readHead != null) {
            if (testKey.equals(this.head.key)) {
                //  I hope garbage collection works the way I think it does
                this.head = this.head.next;
                return;
            }
        }

        // handle the inductive case
        while (readHeadPlusOne != null) {
            if (testKey.equals(readHeadPlusOne.key)) {
                readHead.next = readHeadPlusOne.next;
                return;
            }
            readHead = readHead.next;
            readHeadPlusOne = readHeadPlusOne.next;
        }
    }

    // adds to a counter each time the list is incremented, then returns at the end
    public int length() {

        int len = 0;
        SNode readHead = this.head;

        while (readHead != null) {
            readHead = readHead.next;
            len++;
        }

        return len;
    }

    public boolean isEmpty() {

        return (this.length() == 0);
    }

    // similar to length, except instead of incrementing a counter, prints the key of the read head
    public void dump() {
        SNode readHead = this.head;

        while (readHead != null) {
            System.out.println(readHead.key);
            readHead = readHead.next;
        }
    }

    // assuming the list is ordered, inserts keys where they belong
    public void insert(String keyToBeInserted) {
        SNode readHead = this.head;

        // creates the node to be inserted
        SNode newNode = new SNode(keyToBeInserted);

        // handles the null case
        if (this.isEmpty()) {
            this.add(keyToBeInserted);
        }

        while (readHead != null) {

            // if we're larger than or equal to the read head key, check the next node's key
            if (readHead.key.compareTo(keyToBeInserted) <= 0) {
                // we're at the end of the list, so insert at the end of the list
                if (readHead.next == null) {
                    readHead.next = newNode;
                    return;
                }
                // else if we're smaller than the next node's key, insert between the two
                if (readHead.next.key.compareTo(keyToBeInserted) > 0) {
                    newNode.next = readHead.next;
                    readHead.next = newNode;
                    return;
                }
            }
            // handles the case where we're smaller than the first key
            if (readHead.key.compareTo(keyToBeInserted) > 0) {
                this.add(keyToBeInserted);
                return;
            }
            readHead = readHead.next;
        }
    }
}