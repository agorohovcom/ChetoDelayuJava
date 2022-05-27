package Stack_and_Queue;

// https://www.youtube.com/watch?v=X07Y7pkHHJc&ab_channel=SergeyArkhipovJavaTutorials
public class StackTest {
    public static void main(String[] args) {
        testQueue();
        System.out.println("___");
        testStack();
    }

    private static void testQueue(){
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        for(int i = 1; i < 10; i++){
            System.out.println(i);
            queue.add(i);
        }

        System.out.println("\n");

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }

    private static void testStack(){
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        for(int i = 1; i < 10; i++){
            System.out.println(i);
            stack.push(i);
        }

        System.out.println("\n");

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
