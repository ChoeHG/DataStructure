import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Packet {
    private String data;
    private int messageNumber;
    private int packetNumber;
    private int length;

    public Packet(int packetNumber, int messageNumber, String data,int length) {
        this.packetNumber = packetNumber;
        this.messageNumber = messageNumber;
        this.data = data;
        this.length = length;
    }

    public Packet(int packetNumber, int messageNumber, String data) {
        this(packetNumber, messageNumber, data, data.length());
    }

    public static Packet readPacket(String path) {
        File file = new File(path);
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            String str;
            ArrayList<String> lineList = new ArrayList();

            while ((str = in.readLine()) != null) {
                lineList.add(str);
            }

            return new Packet(Integer.parseInt(lineList.get(0)), Integer.parseInt(lineList.get(1)), lineList.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public int getPacketNumber() {
        return packetNumber;
    }

    public void setPacketNumber(int packetNumber) {
        this.packetNumber = packetNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "{packetNumber: " + this.getPacketNumber() + ", messageNumber: " + this.getMessageNumber()
                + ", data: \"" + this.getData() + "\", length: " + this.length + "}";
    }
}
