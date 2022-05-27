package Tree.BinaryTree;

import Stack_and_Queue.SimpleQueue;
import Stack_and_Queue.SimpleStack;

public class Main {
    public static void main(String[] args) {

        // конструируем дерево
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4,null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));

        // считаем сумму
        System.out.println("Сумма дерева рекурсивным обходом в глубину: " + root.sumRecursive1());
        System.out.println("То же самое, статический метод: " + Tree.sunRecursive2(root));
        System.out.println("Сумма дерева, итеративный обход в глубину через stack LIFO: " + Tree.sumDeepWithStack(root));
        System.out.println("Сумма дерева, итеративный обход в ширину через queue: FIFO" + Tree.sumDeepWihtQueue(root));

    }

    static class Tree {
        int value;
        Tree left, right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        // рекурсивный обход в глубину, вычисление суммы
        // https://www.youtube.com/watch?v=rwjtcJSNpBs
        public int sumRecursive1(){
            int sum = value;
            if( left != null){
                sum += left.sumRecursive1();
            }
            if(right != null){
                sum += right.sumRecursive1();
            }
            return sum;
        }
        // статический вариант рекурсивного обхода в глубину
        public static int sunRecursive2(Tree root){
            int sum = root.value;
            if(root.left != null){
                sum += sunRecursive2(root.left);
            }
            if(root.right != null){
                sum += sunRecursive2(root.right);
            }
            return sum;
        }

        // итеративный обход в глубину через stack
        // https://www.youtube.com/watch?v=pcicxEjCPZY
        public static int sumDeepWithStack(Tree root){
            SimpleStack<Tree> stack = new SimpleStack<>();
            stack.push(root);

            int summ = 0;

            while (!stack.isEmpty()){
                Tree node = stack.pop();
                summ += node.value;

                if(node.right != null){
                    stack.push(node.right);
                }if(node.left != null){
                    stack.push(node.left);
                }

            }
            return summ;
        }

        // итеративный обход в ширину через queue
        // https://www.youtube.com/watch?v=pcicxEjCPZY
        public static int sumDeepWihtQueue(Tree root){
            SimpleQueue<Tree> queue = new SimpleQueue<>();
            queue.add(root);

            int summ = 0;

            while (!queue.isEmpty()){
                Tree node = queue.remove();
                summ += node.value;

                if(node.right != null){
                    queue.add(node.right);
                }if(node.left != null){
                    queue.add(node.left);
                }

            }
            return summ;
        }
    }
}


