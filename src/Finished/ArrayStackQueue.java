package Finished;

public class ArrayStackQueue {
    public static void main(String[] args) {
        /*Finished.Stack ss = new Finished.Stack(3);
        System.out.println(ss.peek());
        System.out.println(ss.push(10));
        System.out.println(ss.peek());
        System.out.println(ss.push(20));
        System.out.println(ss.push(30));
        System.out.println(ss.pop());
        System.out.println(ss.push(40));
        System.out.println(ss.push(50));
        System.out.println(ss.pop());
        System.out.println(ss.peek());*/
        Queue ss = new Queue(3);
        System.out.println(ss.add(10));
        System.out.println(ss.peek());
        System.out.println(ss.add(20));
        System.out.println(ss.add(30));
        System.out.println(ss.remove());
        System.out.println(ss.add(40));
        System.out.println(ss.add(50));
        System.out.println(ss.remove());
        System.out.println(ss.peek());
        System.out.println(ss.remove());System.out.println(ss.remove());


    }
}
class Stack {
    int size;
    int[] arr;

    public Stack(int size) {
        this.size = 0;
        this.arr = new int[size];
    }
    public boolean push(int val){
        if (size < arr.length){
            arr[size++] = val;
            return true;
        }
        else return false;
    }
    public int pop(){
        try {
            return arr[--size];
        }
        catch (ArrayIndexOutOfBoundsException e){
            if (size < 0 ) size++;
            throw e;
        }
    }
    public int peek(){
        try {
            if (size > 0)  return arr[size -1 ];
            else return arr[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            throw e;
        }
    }

}
class Queue {
    int size;
    int[] arr;
    int start;
    public Queue(int capacity) {
        this.size = 0;
        this.arr = new int[capacity];
        this.start = 0;
    }
    public boolean add(int val){
        if (size < arr.length){
            arr[(start+(size++))%arr.length] = val;
            return true;
        }
        else return false;
    }
    public int remove(){
        if (size == 0) throw new ArrayIndexOutOfBoundsException();
        else {
            int return_val = arr[start];
            start = (start+1)%arr.length;
            size--;
            return return_val;
        }
    }
    public int peek(){
        if (size > 0)  return arr[start];
        else throw new ArrayIndexOutOfBoundsException();

    }

}