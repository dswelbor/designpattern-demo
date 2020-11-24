package adapter;

/**
 * USB Adapter is an adapter for 3.5mm headphones to be used on phones that subscribe to the USB-C standard.
 */
public class USBAdapter implements AudioJackIphone{

    USBIphone iphone;

    /**
     * Here more logic could be employed to allow for more than the IPhone10 to be implemented, but this works for this
     * simple example.
     */
    public USBAdapter() {
        this.iphone = new Iphone10();
    }

    @Override
    public void audioPlugin() {
        this.iphone.usbPlugin();
    }
}
