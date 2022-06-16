package Assignment5;

import java.util.Stack;

/**
 * Implement a Stack in which you can get
 * min element in O(1) time and O(1) space.
 */
public class QuestionFour{
    Stack<Node> s;

    class Node{
        int val;
        int min;
        public Node(int val,int min){
            this.val=val;
            this.min=min;
        }
    }

    public QuestionFour() {
        this.s=new Stack<Node>();
    }
    public void push(int x) {
        if(s.isEmpty()){
            this.s.push(new Node(x,x));
        }else{
            int min=Math.min(this.s.peek().min,x);
            this.s.push(new Node(x,min));
        }
    }
    public int pop() {

        return this.s.pop().val;
    }
    public int top() {

        return this.s.peek().val;
    }
    public int getMin() {

        return this.s.peek().min;
    }
}


class DriverClass {



    public static void main (String[] args) {
        QuestionFour s=new QuestionFour();
        s.push(-1);
        s.push(10);
        s.push(-4);
        s.push(0);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.getMin());


    }
}

