package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPConnection {

	private Socket socket;
	
	public TCPConnection(String hostName, int port) {
		try {
			socket = new Socket(InetAddress.getByName(hostName), port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TCPConnection(Socket socket) {
		this.socket = socket;
	}
	
	/**
	 * @return the host name of the destination for this connection.
	 */
	public String getHostName() {
		return socket.getInetAddress().getHostName();
	}
	
	/**
	 * Sends the message to the recipient.
	 */
	public void send(byte[] message) {
		try {
			OutputStream out = socket.getOutputStream();
			out.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Receives a message of the given length. 
	 */
	public byte[] receive(int bufferLength) {
		byte[] buffer = new byte[bufferLength];
		try {
			InputStream message = socket.getInputStream();
			message.read(buffer, 0, bufferLength);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
