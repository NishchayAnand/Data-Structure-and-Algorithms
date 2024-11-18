
/*

    Problem Statement: Given a stack consisting of 'N' integers, sort it in descending order.

                       NOTE: You are not allowed to use any other data structure.

    General Observations:

        -

*/

import java.util.ArrayDeque;

public class SortStack {

    public static void sortStack(ArrayDeque<Integer> stack) {

    }

    public static void main(String[] args) {
        int[] input = {5,-2,9,-7,3};
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int num: input) stack.push(num);
        sortStack(stack);
        System.out.println(stack);

    }
}
