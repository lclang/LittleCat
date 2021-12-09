# Contributing

## Basic Guidelines

### Use an IDE.
Specifically, IntelliJ IDEA. Download the (free) Community Edition of it [here](https://www.jetbrains.com/idea/download/). Some people use other tools, like VS Code, but I would personally not recommend them for Java development.

### Always test your changes.
Do not submit something without at least running to see if it compiles.  

### Do not make large changes before discussing them first.
If you are interested in adding changing large amounts of code, first contact me via [Telegram](https://t.me/levkopo). 

## Style Guidelines

### Follow the formatting guidelines.
This means:
- Short method/variable names (multipleLongWords should be avoided if it's possible to do so reasonably, especially for variables)

### Do not use incompatible Java features (java.util.function, java.awt).
Android and RoboVM (iOS) do not support many of Java 8's features, such as the packages `java.util.function`, `java.util.stream` or `forEach` in collections. Do not use these in your code.  
If you need to use functional interfaces, use the ones in `arc.func`, which are more or less the same with different naming schemes.
  
The same applies to any class *outside* of the standard `java.[n]io` / `java.net` / `java.util` packages: Most of them are not supported.  
`java.awt` is one of these packages: do not use it, ever. It is not supported on any platform, even desktop - the entire package is removed during JRE minimization.
In general, if you are using IntelliJ, you should be warned about platform incompatiblities.


### Do not create methods unless necessary.
Unless a block of code is very large or used in more than 1-2 places, don't split it up into a separate method. Making unnecessary methods only creates confusion, and may slightly decrease performance.  
