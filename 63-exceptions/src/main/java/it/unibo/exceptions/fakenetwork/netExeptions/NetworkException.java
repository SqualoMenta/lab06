package it.unibo.exceptions.fakenetwork.netExeptions;

import java.io.IOException;

public class NetworkException extends IOException {
    public NetworkException(){
        super("Network error: no response");
    }

    public NetworkException(final String input){
        super("Network error while sending message: " + input);
    }
}
