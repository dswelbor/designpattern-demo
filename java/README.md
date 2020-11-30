# Java Design Patterns
Design Patterns have been implemented in Java to help build understanding 
around the nuances for this language's feature set and its limitations. 
In particular, there is often some misunderstanding around the usage of interfaces 
with design patterns and the language specific Interface feature in Java. 
Sometimes it is appropriate to implement a proper Interface while other times 
an Abstract class can be appropriate. Oftentimes this will be more dependant on 
specific project requirements than components of a design pattern. 

## Gradle
For usability and to make the examples as platform independant as possible, Gradle 
is used for build automation. This build tool was chosen over alternatives such as 
Apache Ant or Maven for a variety of reasons including:
- Build scripts are written in Groovy rather than XML and are more human readable
- Gradle is the default build tool for Google Android projects
- Gradle is in active development and features active community support

## Testing and Continuous Integration
A comprehensive collection of unit tests run against code in continuous integration is 
a crucial component in maintaining project health. While there are plans to implement 
this in the future, at this time, unit tests and ci are currently unsupported. More to 
come on this in the future feature enhancements.

## Running Design Pattern Examples
Using gradle, we've configured the project to run with some simple cli args. Using 
default settings you can run everything using:

`gradle run`

Alternatively, the following commandline arguments are available:
- `-adapter`
- `-decorator`
- `-factory`

These can be passed via gradle as well. For example, to run just the adapter example, 
you would enter the following:

`gradle run --args="-adapter"`

and to run just factory and decorator, you would enter:

`gradle run --args="-decorator -factory"`

<br><br>
## Design Pattern Descriptions
Below are summaries for the various Design Patterns that have been implemented. We've 
tried to summarize the high level description of each pattern and how it is implemented. 
More documentation can be found in the `<repo_root>/docs/java` folder.

### Adapter Pattern
The adapter design pattern converts the interface of a class into another interface 
clients expect. This allows classes tp work together that otherwise could not due to
incompatible interfaces.

The provided example uses an Adapter to wrap the new usb-based interface and make 
both versions of the Iphone (IPhone5 and Iphone10) work with the Headphones - which
uses the AudioJackIphone interface. More info can be found in the folder:
`/docs/java/adapter` 

### Decorator Pattern
The decorator pattern is a structural design pattern that abstracts how to enhance 
or "decorate" existing functionality for something. It both "is-a" something and 
"has-a" or decorates or wraps something. This is useful for enhancing or enriching 
the default output for something while retaining the same interface and leaving the 
state of what's being decorated untouched. This is also useful when side effects are 
desirable - such as wrapping a method with logging.

In the java-based example we provide, CoffeeBase "is" Coffee as are CoffeeDecorators. 
These decorators are abstracted as children of the CoffeeDecoratorAbstract parent class, 
which serves to both enforce the common Coffee interface and bake in common shared 
attributes. More information about this pattern and how it is used can be found at: 
`/docs/java/decorator` including a spec sheet pdf for the pattern as well 
as a uml diagram specific to this example.

### Factory Pattern
The Factory Pattern - and more specifically here, the Factory Method Pattern - provide 
the building blocks for abstracting the creation of new objects - Animals in this case. 
Specifically, factories implement a shared create() method, and the interface abstracts 
implementation details from users. 

This java-based implementation is initially somewhat naive with room for Refactoring 
improvements a la Martin Fowler. Specifically, Iterators for getting names and descriptions 
in the AquaticPetFactory can be improved by injecting iterator algorithms and abstracting 
configuration details with either json or yaml config files. However, for the purpose of 
this example, it meets the criteria. More documentation on this pattern can be found 
at: `/docs/java/factory`

New and improved Factory Pattern is Coming Soon!