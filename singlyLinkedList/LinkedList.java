public class LinkedList {
    
    private Node head;
    private Node tail;
    private int length;
     
    class Node {
        int value;
        Node next;
     
        Node(int value) {
            this.value = value;
        }
    }
    
    LinkedList(int value){
        Node node = new Node(value);
        head = node ;
        tail = node;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

        public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public void append(int value){
        Node node = new Node(value);
        if(length==0){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    Node removeLast(){
	    if(head==null){
	        return null;
	    }
	    Node temp = head;
	    Node pre = head;
	    while(temp.next != null){
	        pre = temp;
	        temp = temp.next;
	    }
	    tail = pre;
	    tail.next = null;
	    length--;
	    if(length==0){
	        head= null;
	        tail = null;
	    }
	    return temp;
	    
	}

    public void prepend(int value){
	    Node node = new Node(value);
	    if(length==0) {
	        head = node;
	        tail = node;
	    } else {
	        node.next = head;
	        head = node;
	    }
	    length++;
	}

    Node removeFirst(){
        Node temp = head;
        if(length==0){
            return null;
        }
        
        head = head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length)
            return null;
            
        Node temp = head ;
        int count=0;
            
        while(index > count) {
            count ++;
            temp = temp.next ;
        }
        
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp==null)
            return false;
        
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        
        if(index<0 || index>length) return false;
        
        if(index ==0) {
            prepend(value);
        } else if(index == length) {
            append(value);
        } else{
            Node previous = get(index-1);
        Node newNode = new Node(value);
        newNode.next = previous.next ;
        previous.next = newNode ;
        
        length++;
        }
        
        return true;
    }

    public Node remove(int index){
        
        Node temp = null ;
        
        if(index < 0 || index > length){
            return null;
        } else if (index ==0){
            temp = removeFirst();
        } else if (index == length) {
            return removeLast();
        } else {
            Node previous = get(index-1);
            temp = previous.next;
            previous.next = temp.next;
            temp.next = null;
        
        }
        length--;
        return temp;
        
    }

    public void reverse(){
        Node previous = null ;
        Node currentNode = head ;
        Node nextNode = null;
        
        head = tail ;
        tail = currentNode;
        
        for(int i=0; i<length ; i++){
           nextNode = currentNode.next ;
           currentNode.next = previous ;
           previous = currentNode;
           currentNode = nextNode ;
           
        }
    }


}

