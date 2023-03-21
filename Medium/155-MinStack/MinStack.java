public class MinStack {

    /*

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

    You must implement the functions of the stack such that each function works in constant time complexity.

    Example 1:

    Input
    ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
    [[], [-2], [0], [-3], [], [], [], []]

    Output
    [null, null, null, null, -3, null, 0, -2]

    Explanation

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2

     */

    // Link : https://leetcode.com/problems/min-stack/


    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }

    public int[] stack;
    public int top;
    public int min;

    public MinStack() {

        stack = new int[10000];
        top = -1;
        min = Integer.MAX_VALUE;

    }

    public void push(int val) {

        if(top == stack.length - 1)
            return;

        stack[++top] = val;

        if(val < min)
            min = val;

    }

    public void pop() {

        if(top == -1)
            return;

        if( stack[top] == min ){

            min = Integer.MAX_VALUE;

            for(int i = 0; i < top; i++)
                if(stack[i] < min)
                    min = stack[i];

        }

        top--;

    }

    public int top() {

        if(top == -1)
            return -1;

        return stack[top];

    }

    public int getMin() {

        return min;

    }

}
