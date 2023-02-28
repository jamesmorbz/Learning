
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class SecondUDPClient {
   public static void main(String args[]) throws Exception {
      
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      String sentence = "Start Countdown";
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 20001);
      clientSocket.send(sendPacket);
      
      while(true){
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      
      String count = new String(receivePacket.getData());
      System.out.println("COUNTDOWN:" + count);
      if(count.charAt(0) == '0')
    	  break;
      }
      
      clientSocket.close();
   }
}
