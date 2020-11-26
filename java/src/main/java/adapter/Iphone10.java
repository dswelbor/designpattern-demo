package adapter;

/**
 * Iphone10 Subscribes to the new standard of USB-C ports for connections. Sadly, 3.5mm connections are no longer supported
 * on this newer technology.
 */
public class Iphone10 implements USBIphone{

    /**
     * usbPlugin allows for playing music through the devices USB-C port.
     */
    @Override
    public void usbPlugin() {
        System.out.println("Now listening to music through the power of USB-C!");
    }
}
