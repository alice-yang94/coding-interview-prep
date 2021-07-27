public class Main {
    public static void main (String[] args) {
        MyStack<String> stack = new MyStack<String>();
        stack.push("aaa");
        stack.push("bbb");
        System.out.println(stack.isEmpty() == false);
        System.out.println(stack.peek() == "bbb");
        System.out.println(stack.pop() == "bbb");
        System.out.println(stack.pop() == "aaa");
        System.out.println(stack.isEmpty() == true);

        MyQueue<String> queue = new MyQueue<String>();
        queue.add("aaa");
        queue.add("bbb");
        System.out.println(queue.isEmpty() == false);
        System.out.println(queue.peek() == "aaa");
        System.out.println(queue.remove() == "aaa");
        System.out.println(queue.remove() == "bbb");
        System.out.println(queue.isEmpty() == true);

    }
}