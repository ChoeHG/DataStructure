public class SLLTest {
    public static void main(String[] args) {
        Packet example_packet1 = Packet.readPacket("src/file/example_packet1.txt");
        Packet example_packet2 = Packet.readPacket("src/file/example_packet2.txt");
        Packet example_packet3 = Packet.readPacket("src/file/example_packet3.txt");
        Packet example_packet4 = Packet.readPacket("src/file/example_packet4.txt");
        Packet example_packet5 = Packet.readPacket("src/file/example_packet5.txt");
        Packet example_packet6 = Packet.readPacket("src/file/example_packet6.txt");
        Packet example_packet7 = Packet.readPacket("src/file/example_packet7.txt");

//        Packet my_packet1 = Packet.readPacket("src/file/my_packet1.txt");
//        Packet my_packet2 = Packet.readPacket("src/file/my_packet2.txt");
//        Packet my_packet3 = Packet.readPacket("src/file/my_packet3.txt");
//        Packet my_packet4 = Packet.readPacket("src/file/my_packet4.txt");
//        Packet my_packet5 = Packet.readPacket("src/file/my_packet5.txt");
//        Packet my_packet6 = Packet.readPacket("src/file/my_packet6.txt");
//        Packet my_packet7 = Packet.readPacket("src/file/my_packet7.txt");
//        Packet my_packet8 = Packet.readPacket("src/file/my_packet8.txt");
//        Packet my_packet9 = Packet.readPacket("src/file/my_packet9.txt");
//        Packet my_packet10 = Packet.readPacket("src/file/my_packet10.txt");
//        Packet my_packet11 = Packet.readPacket("src/file/my_packet11.txt");

        SinglyLinkedList example_singlyLinkedList = new SinglyLinkedList();
//        SinglyLinkedList my_singlyLinkedList = new SinglyLinkedList();

        try {
            example_singlyLinkedList.insert(example_packet1);
            example_singlyLinkedList.insert(example_packet2);
            example_singlyLinkedList.insert(example_packet3);
            example_singlyLinkedList.insert(example_packet4);
            example_singlyLinkedList.insert(example_packet5);
            example_singlyLinkedList.insert(example_packet6);
            example_singlyLinkedList.insert(example_packet7);

//            my_singlyLinkedList.insert(my_packet1);
//            my_singlyLinkedList.insert(my_packet2);
//            my_singlyLinkedList.insert(my_packet3);
//            my_singlyLinkedList.insert(my_packet4);
//            my_singlyLinkedList.insert(my_packet5);
//            my_singlyLinkedList.insert(my_packet6);
//            my_singlyLinkedList.insert(my_packet7);
//            my_singlyLinkedList.insert(my_packet8);
//            my_singlyLinkedList.insert(my_packet9);
//            my_singlyLinkedList.insert(my_packet10);
//            my_singlyLinkedList.insert(my_packet11);
        } catch (ListOverFlowException e) {
             System.out.println("Warning:");
             System.out.println("Your SLL is full!\n");
        }

//        example_singlyLinkedList.remove(1, 2);
//        example_singlyLinkedList.remove(2, 1);

        System.out.println(example_singlyLinkedList.toString());
//        System.out.println(example_singlyLinkedList);
    }
}










