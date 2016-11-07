# TCPBridge
A multiserver TCP utility library

Usage: Server

Sample Server class

```

import Jesty.TCPBridge.ClientWorker;
import Jesty.TCPBridge.Server;

public class YourServer extends Server {
    public GameServer(int raw_port, int web_port) {
        super(raw_port, web_port);
    }

    @Override
    public void onMessage(ClientWorker clientWorker, String message) {
      //Use this to save client-specific information
      YourClientData clientData = (YourClientData)clientWorker.clientData;
      
      //Send messages to all connected clients
      for (ClientWorker c: clients.getList()) {
            c.sendMessage(message);
      }
      //
    }
    @Override
    public void onClose(ClientWorker clientWorker, int code) {
      //Your code here!
    }
    @Override
    public void onOpen(ClientWorker clientWorker, int code) {
      //Your code here!
    }
    
    public static void main(String[] args) {
      YourServer yourServer = new YourServer(16000, 8080);
      //Begins code execution
      yourServer.start();
    }
}

```

Sample Client Class

```

public class YourClient extends Client {

    public Client(String hostName, int portNumber) {
        super(hostName, portNumber);
    }
    
    @Override
    public void onMessage(String message) {
      //Your code here!
    }
    @Override
    public void onOpen() {
      //Your code here!
    }
    @Override
    public void onClose() {
      //Your code here!
    }
    
    public static void main (String[] args) {
       YourClient client = new YourClient("localhost", 16000);
       client.start();
    }

}

```
