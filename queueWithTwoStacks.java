class Solution{

  public static class MyQueue<T>{
  
    private Stack<T> stackNewestOnTop = new Stack<T>();
    private Stack<T> stackOldestOnTop = new Stack<T>();
  
    public void enqueue(T value){
      stackNewestOnTop.push(value);
    }
    
    private void shiftStacks(){
      if(stackOldestOnTop.isEmpty()){
        while(!stackNewestOnTop.isEmpty()){
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
      }
    }
    
    
    // fetching the oldest!!
    public T peek(){
      //get oldest element to stack old from stack new
      shiftStacks();
      return stackOldestOnTop.peek();
    }
    
    public T dequeue(){
      //move from stacknew if empty
      shiftStacks();
      return stackOldestOnTop.pop();
    }
  }

}
