# Adapter Design Pattern

### Description: 

The adapter design pattern can be used to convert the interface of a class into another interface 
clients expect. The adapter lets classes work together which otherwise could not because of
incompatible interfaces. 

### The Problem

This example uses the semi-recent change in cellphones from having the standard 3.5mm 
audio output port, to just having a USB type C port. Understandably this caused some issues. Now you
have this fancy new phone, but your only headphones are not compatible with it. 

### The Solution

We make an adapter! In the code there is an Iphone5 class which subscribes to the contract
present in the AudioJackIphone. This class represent your old phone, which your headphones work
fine with. However, the Iphone10 class subscribes to the USBIphone contract, and is incompatible
with your headphones. To make our headphones compatible with the new phone, we make an adapter, USBAdapter,
that subscribes to the AudioJackIphone interface, and wraps(contains) an instance of a USBIphone 
object. Now when we call `listen()` on our headphones, in turn calling the `audioPlugIn()` method 
on it's instance of AudioJackIphone, the USBAdapter can now call the correct method in the Iphone10 
class, and we have sweet beautiful music. 


### Conclusion and Take Aways

While this is a simple example, and we could have just bought(read made a USBC Headphone class)
this wont always be the case. The adapter pattern can be used to adapt much more than a single method
of a class simple class, and in fact the adapter pattern can be used to adapt to multiple 
classes. 

The adapter pattern is used to adapt a class you want to use, to make it fit an interface
it does not already conform to. When using the adapter pattern, there should be no need
to change the underlying behaviour of the class you're adapting. 


# Resources

[Christopher Okhravi's Adapter Video](https://www.youtube.com/watch?v=2PKQtcJjYvc)

[DZone page on the Adapter Pattern](https://dzone.com/articles/adapter-design-pattern-in-java)

[Gang of Four Desgn Patterns Book](https://www.amazon.com/Design-Patterns-Object-Oriented-Addison-Wesley-Professional-ebook/dp/B000SEIBB8)

[Head First! Design Patterns](https://www.amazon.com/Head-First-Design-Patterns-Brain-Friendly/dp/0596007124)