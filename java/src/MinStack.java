import java.util.*;






class MinStack {

    class MinsStack_2stacks {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinsStack_2stacks() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            Integer min = minStack.isEmpty() ? null : minStack.peek();
            minStack.push((min == null || min > val) ? val : min);
        }
        
        public void pop() {
            stack.pop();
            minStack.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        
        public int getMin() {
            return minStack.peek();
        }
    }


//--------------------------------- HARD, DIDN'T UNDERSTAND WELL


public class MinStack_1stack_byNeetcode {
    long min;
    Stack<Long> stack;

    public MinStack_1stack_byNeetcode() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}


/*

vals=[-2,0,-3, 1] top->  peek > 0  ? (peek + min) : (min)


0, min = -2      (min)


2, min = -2      (peek + min)
0

-1, min = -3      (min)
2
0

4, min = -3       (peek + min)
-1
2
0



pop

-1, min = -3     permanence
2
0

pop

2, min = min - pop = (-3) - (-1) = -2
0




*/

    
}

/*













*/