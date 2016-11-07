package Jesty.TCPBridge;

import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Evan on 10/19/2016.
 */
public class WebFactory extends WebSocketServer {

    private Clients clients;

    public WebFactory(Clients clients, int port) {
        super(new InetSocketAddress(port));
        this.clients = clients;
    }


    public void onOpen(org.java_websocket.WebSocket client, ClientHandshake handshake) {
        clients.add(client);
    }

    public void onClose (WebSocket client, int code, String reason, boolean remote) {
        System.out.println(code + ", " + reason + ", " + remote);
        clients.get(client).disconnect();

    }

    public void onMessage(WebSocket client, String message) {
        clients.get(client).receiveMessage(message);
    }

    public void onFragment(WebSocket client, Framedata fragment) {

    }

    public void onError(WebSocket client, Exception ex) {
        ex.printStackTrace();
    }

}
