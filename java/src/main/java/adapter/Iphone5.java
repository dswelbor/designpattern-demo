package adapter;

/**
 * Class Iphone 5 implements the AudioJackIphone interface, and allows for connecting headphones that are 3.5mm standard
 * and listening to some music.
 */
public class Iphone5 implements AudioJackIphone {

    /**
     * audioPlugin() Plays music when headphones are plugged in.
     */
    @Override
    public void audioPlugin() {
        System.out.println("Now Listening to music through 3.5mm Audio jack!");
    }
}
