package ro.pub.cs.systems.eim.lab06.singlethreadedserver.network;

import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import ro.pub.cs.systems.eim.lab06.singlethreadedserver.general.Constants;
import ro.pub.cs.systems.eim.lab06.singlethreadedserver.general.Utilities;

public class CommunicationThread extends Thread {

    private Socket socket;
    private EditText serverTextEditText;

    public CommunicationThread(Socket socket, EditText serverTextEditText) {
        this.socket = socket;
        this.serverTextEditText = serverTextEditText;
    }

    @Override
    public void run() {
        try {
            // TODO exercise 5c
            // simulate the fact the communication routine between the server and the client takes 3 seconds
            Thread.sleep(3000);

            PrintWriter printWriter = Utilities.getWriter(socket);
            printWriter.println(serverTextEditText.getText().toString());
            socket.close();
        } catch (InterruptedException | IOException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
