package Jesty.TCPBridge;

/**
 * Created by Evan on 10/18/2016.
 *
 * A class used to test the TCPBridge
 */

public class test {

    public test() {
        Server s = new Server(16000, 8080);
        s.start();
        Client c = new Client("localhost", 16000);
        c.start();
    }

    public static void main (String[] args) {
        new test();
    }

}
