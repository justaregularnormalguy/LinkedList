//Name: Obiefuna Moneme
//Date: 9/21/25
//Description: This contains a list that can be manipulated with different values.
/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)

  //constructors go here
  ListNode head;

public LinkedList (){
  head = null;
}



  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {

    //the list is empty
    if (head == null) {
      head = new ListNode(line, null);
      return head;
    }

    //the list is not empty and we need to add to the front
    if (head != null && head.getValue().compareTo(line)>0) {
      head = new ListNode(line, head);
      return head;
    }

    //add anywhere but the front
    ListNode temp = head;
    //use a loop to find the right spot. then insert the new node.
    //to move temp over use temp = temp.getNext()
    while (temp.getNext() != null && temp.getNext().getValue().compareTo(line) < 0) {
      temp = temp.getNext();
    }
    temp.setNext(new ListNode(line, temp.getNext()));
    
    return temp.getNext();
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    // empty list
    if (head == null) {
      return null;
    }

    // deleting head
    if (head.getValue().equals(line)) {
      ListNode removed = head;
      head = head.getNext();
      removed.setNext(null);
      return removed;
    }

    // traverse keeping track of previous node
    ListNode prev = head;
    ListNode curr = head.getNext();

    // because list is kept in alphabetical order we can stop when curr's value >= target
    while (curr != null && curr.getValue().compareTo(line) < 0) {
      prev = curr;
      curr = curr.getNext();
    }

    if (curr != null && curr.getValue().equals(line)) {
      prev.setNext(curr.getNext());
      curr.setNext(null);
      return curr;
    }

    // not found
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String ret="";

    ListNode temp = head;
    while (temp != null) {
      ret += temp.getValue();
      if (temp.getNext() != null) {
        ret += " ";
      }
      temp = temp.getNext();
    }

    return ret;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
  head = null;
  }

  //precondition: there's at least one element in the list
  //postcondition: all nodes in the list reverse order.
  public void reverse(){
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    head = prev;
    
  }

  //precondition: given some n>1 
  //postcondition: takes groups of "n" elements, reverses them and stiches them back into a linkedList
  public void nReverse(int n){
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    
    
    while (curr != null) {


      for(int i =0; i<n && curr!=null; i++){
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
      }

      //relink the already reversed bit to what you just reversed
  }


}
  }
