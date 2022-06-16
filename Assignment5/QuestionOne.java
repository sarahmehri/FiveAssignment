package Assignment5;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 *  The Next greater Element for an element x is the first greater element on the right side of x in array.
 *  Elements for which no greater element exist, consider next greater element as -1.
 */
public class QuestionOne {

    static int[] arr = { 11, 13, 21, 3 };

    public static void printNGE()
    {
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (!s.empty())
            {
                while (!s.empty()
                        && s.peek() <= arr[i])
                {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] +
                    " --> " + nge[i]);
    }


    public static void main(String[] args)
    {
        printNGE();
    }
}
