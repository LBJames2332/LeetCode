package Finished;

public class replace {
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    public static void main(String[] args) {
        System.out.println(new replace().replaceSpace("We are happy."));
    }
}
