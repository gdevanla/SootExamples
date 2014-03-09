
public class HelloWorld {

    public String s = "Hello World";

    public HelloWorld() {

    }

    public HelloWorld(String s) {
        this.s = s;
    }

    public void sayHello() {
        System.out.println(s);
    }

    public void sayHello(String s) {

        System.out.println(this.s + "," + s);

    }

    public String getHelloString(int sometimes) {
        String someString = "x";
        if (sometimes > 10) {
            someString = "Greater than 10";
        } else {
            someString = "Less than 10";
        }

        return someString;
    }

    public static void main(String args[]) {

        HelloWorld hw = new HelloWorld("Hey, Chicago");

        hw.getHelloString(10);
        hw.sayHello();
        hw.sayHello("With random string");

        HelloWorld hw1 = new HelloWorld();
        hw1.sayHello();

    }


}
