class Solution {
    public int evalRPN(String[] tokens) {
        // ["1","2","+","3","*","4","-"]
        int a;
        int b;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if ("+-/*".contains(t)) {
                b = stack.pop();
                a = stack.pop();
                switch (t) {
                    case "+":
                        stack.push(b + a);
                        break;

                    case "-":
                        stack.push(a-b);
                        break;

                    case "*":
                        stack.push(b * a);
                        break;

                    case "/":
                        if(b==0){
                            stack.push(0);
                            break;
                        }
                        stack.push(a/b);
                }
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }
}

