package B_recursion;

public class FibonacciSeries {
    public static int fib(int n){
        if(n<2) return n;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        int result = fib(8);
        System.out.println(result);
    }
}
