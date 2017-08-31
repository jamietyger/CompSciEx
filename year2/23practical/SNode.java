package t2prac2;

/**
 * Node of a singly linked list, which stores references to its
 * element and to the next node in the list.
 * 
 */

public class SNode {
  // Instance variables:
  private String Person element;
  private SNode next;
  
  /** Creates a node with null references to its element and next node. */
  public SNode() {
    this(null, null);
  }
  /** Creates a node with the given element and next node. */
  public SNode(Person people, SNode n) {
    this.element = people;
    this.next = n;
  }
  /** Creates a node with the given element and next node null. */
  public SNode(Person elemnt) {
    element = elemnt;
    next = null;
  }
  // Accessor methods:
  public Person getElement() {
    return element; 
  }
  public SNode getNext() { 
    return next;
  }
  // Modifier methods:
  public void setElement(Person newElem) { 
    element = newElem; 
  }
  public void setNext(SNode newNext) {
    next = newNext; 
  }
}