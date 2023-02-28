

import java.io.*;
import java.net.*;

class SecondUDPServer {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(20001);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];

		while (true) {
			int countdown = 3;
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			InetAddress addr = receivePacket.getAddress();
			int port = receivePacket.getPort();

			System.out.println("RECEIVED datagram from : " + addr + ":"	+ port);

			
			while (countdown >= 0) {
				
				sendData = Integer.toString(countdown).getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, addr, port);
				serverSocket.send(sendPacket);
				countdown--;
				try { // wait one second
					Thread.sleep(1000);
				} catch (InterruptedException ie) {

				}

			}
		}
	}
}