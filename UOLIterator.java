import java.util.NoSuchElementException;

public class UOLIterator <T> implements CopyableIterator<T> { 

private LinearNode<T> curr;

/*A public constructor to the class that accepts a parameter that is a reference to 
the node in the list where you want to start your iterator (or null if the linked list is empty). Hint:
Usually, the start point will be the first node in the , except when you are 
copying (described in Step 2).*/

//constructor 
UOLIterator(LinearNode<T> startNode) {
    if (startNode != null){
        this.curr = startNode;

    }
}
    //Check if there is a univisted linked node
    public boolean hasNext() {
        //check if current node is null .
        return (curr  != null);

    }

    //Return the next element
     public T next() {
        
        if (!this.hasNext()) {
            //Raise EXCEPTION
            throw new NoSuchElementException("iterator empty");
        }
            //Get the Data and Move the ponter
             T result =this.curr.getData();
            this.curr = this.curr.getNext();
            //return the value
            return   result;
}

    //Copy iterator implemented from CopyableIterator interface
    @Override 
    public CopyableIterator<T> copy() {
        UOLIterator<T> copedIterator = new UOLIterator<>(curr);
        return copedIterator;

    }

    
}
