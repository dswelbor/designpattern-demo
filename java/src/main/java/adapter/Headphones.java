package adapter;

/**
 * Headphones class are used to listen to music on a phone. Supports listening on devices that subscribe to the
 * AudioJackIphone standard.
 */
public class Headphones {
    public AudioJackIphone iphone;

    public Headphones() {
        this.iphone = new Iphone5();
    }

    /**
     * Listen to music on your iphone
     */
    public void listen(){
        this.iphone.audioPlugin();
    }



}
