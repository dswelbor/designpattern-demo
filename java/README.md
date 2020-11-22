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

## Design Pattern Descriptions
More to come on this in future development