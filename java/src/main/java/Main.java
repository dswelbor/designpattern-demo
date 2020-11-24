import adapter.*;
public class Main {

    private static void adapterDemo() {
        System.out.println("You've got an Iphone 5 and wanna listen to music with your 3.5 mm headphones. Easy");
        Headphones headphones = new Headphones();
        headphones.listen();

        System.out.println("\n\nBut now you've upgraded your phone to the Iphone 10. You wanna listen to music");
        System.out.println("Wait... The iphone 10 uses a different interface for headphone connections, it uses USB-C");
        System.out.println("We know Apple isn't exactly friendly to popping open the device and adjusting the hardware" +
                "so what should we do");

        System.out.println("Luckily, we know we can just use an adapter, to adapt to this new interface");
        headphones.iphone = new USBAdapter();
        headphones.listen();
    }

    public static void main(String[] args){
        adapterDemo();
    }

}
