class Solution{
  public static char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};
  
  public boolean isOpenTerm(char c){
    for(char[] array: TOKENS){
      if(array[0] == c) return true;
    }
    return false;
  }
  
  public boolean matches(char openTerm, char closedTerm){
    for(char[] array: TOKENS){
      if(array[0] == openTerm){
        return array[1]==closedTerm;
      }
    }
    return false;
  }
  
  
  public static boolean isBalanced(String expression){
  
    Stack<Character> stack = new Stack<Character>();
    
    for(char c : expression.toCharArray()){
      if(isOpenTerm(c)){
        stack.push(c);
      } else{
        if(stack.isEmpty() || !matches(stack.pop(), c){
          return false;
        }
      }
    }
    
    return stack.isEmpty();
  }
}
