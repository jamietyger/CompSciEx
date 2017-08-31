/*
     			A Solution for SLinkedList class
 */ 
//----------------------------------------------------------------------

public class LinkedQueue 
{
	
	private SNode head, tail;
	
	// Constructors
	public LinkedQueue()
	{
		head = null;
		tail = null;
	}
	
	public LinkedQueue(SNode head)
	{
		this.head = head;
		tail = null;
	}

	public LinkedQueue(SNode newHead, SNode newTail)
	{
		head = newHead;
        tail = newTail;
	}
	
	// Accessors
	public SNode getHead()
	{
		return head;
	}

	public SNode getTail()
	{
		return tail;
	}
	
	// Mutators
	public void setHead(SNode newHead)
	{
		head = newHead;
	}
	
	public void setTail(SNode newTail)
	{
		tail = newTail;
	}
	
	// Boolean methods
	public boolean isEmpty()
	{
		if(getHead() == null)
            return true;
		else
			return false;
	}
	
	public String toString()
	{
		SNode currnt = getHead();
        String strng = "[";
		if (currnt == null)			   // an empty list!
			strng += " ]";
		
            
        while (currnt != null) 
        {
			if(currnt == getTail())
			   strng += currnt.getElement() + "]";
			else
			   strng += currnt.getElement() + ", ";
			currnt = currnt.getNext();                
		}
        return strng;
	}
	
	public int getSize()
	{
		SNode currnt = getHead();
        int siz = 0;
        while (currnt != null) 
        {
			siz += 1;                        
			currnt = currnt.getNext();                
		}
		return siz;
	}
	
	public void insertAtHead(SNode nodeA)
	{
		if(isEmpty())
		{
			setHead(nodeA);
			setTail(nodeA);
		}
		else
		{
			nodeA.setNext(getHead());
			setHead(nodeA);
		}            
	}
	
	public void insertAtTail(SNode nodeB)
	{
		if(isEmpty())
		{
			setHead(nodeB);
            setTail(nodeB);
		}            
        else
        {
			SNode temp = getTail();                
			temp.setNext(nodeB);
			setTail(nodeB);
		}
	}

	public SNode removeAtHead()
	{
		if(isEmpty())
			return null;
		else
		{
			SNode temp = getHead();
			head = head.getNext();
			if (getSize() == 1)
				setTail(head);
			return temp;
		}
	}
	
	public SNode removeAtTail()
	{
		SNode currnt = head;
		SNode node = tail;
		
		while (currnt != null) 
		{
			if(currnt.getNext() == tail)
			{                                        
				currnt.setNext(null);
				tail = currnt;
				if (getSize() == 1)
					head = tail;
			}                          
			currnt = currnt.getNext();                
		}
		return node;
	}

	public static void main(String[] args)
	{
		// creating 7 free standing nodes
		SNode node1 = new SNode("Abongile");
		SNode node2 = new SNode("Benazir");
		SNode node3 = new SNode("Cader");
		SNode node4 = new SNode("Dawood");
		SNode node5 = new SNode("Erfaan");
		SNode node6 = new SNode("Faried");
		SNode node7 = new SNode("Xoliswa");
                
		// creating a linked list with head and tail nodes                
		LinkedQueue list = new LinkedQueue(node3, node4);

	    // displaying linked list
		System.out.println("list after creation : "+list.toString());
		
		// perform operations on linkedlist
	 
		list.insertAtHead(node2);
		list.insertAtHead(node1);
		list.insertAtTail(node5);
		list.insertAtTail(node6);
		list.insertAtTail(node7);
		list.removeAtHead();
		list.removeAtTail();
		list.insertAtHead(node1);
		list.insertAtTail(node7);

		// display final linked list
		System.out.println("Final linked list : "+list.toString());
		System.out.println("Size of linked list: "+list.getSize());
	}	
}
