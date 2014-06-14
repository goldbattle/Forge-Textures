Coding Conventions
==============

This file will cover important coding practices that are important to stress when coding this program. Listed below are some of the more important details that should be stressed. Each programmer has his/her own way to deliver code. The importance of having similar coding conventions throughout this program are listed below.

  - 80% of the time spent on a piece of software goes to maintenance.
  - Hardly any software is maintained for its whole life by the original author.
  - Code conventions improve the readability of the software, allowing engineers to understand new code more quickly and thoroughly.
  - If you ship your source code as a product, you need to make sure it is as well packaged and clean as any other product you create.

Note that many of these coding practices are industry wide. If you are interested to seeing what is the recommended what to do things not covered below please read the official Oracle guide. http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html

Conventions
--------------

* Structure
    * Classes should be named with uppercased letters and should resemble what is contained.
    * Classes should only do one specific task, the word *and* should not be needed to discribe it
    * Classes should not just hold methods. In best practice they should be represented as an "object" not a place to store code.
    * Packages should follow the url format. (test.com => com.test.)
    * Packages created without a website should follow the author's or organization’s name
    * Packages should be used to "group" similar objects together, their names should guide where a new class should be places upon creation
    * Package names should be all lowercase, no spaces and be descriptive of what they hold
* Coding
    * There should be minimal spacing between words
    * Long lines of code should **not** be split up unless it provides clarity to the code
    * Comments should be used as much as possible, they should provide clarity to the code, or notes to future developers
    * Comments should start with a space and then a capital letter
    * "TODO:" Comments should be used to note where work by other members and future projects should go
    * "TODO:" Comments should be added to help layout the program flow
    * "TODO:" Comments should be removed upon completion
    * Javadoc double comments should be added to every method to provide clarity when referenced from other classes
    * Javadoc comments should have all return and parameter statements included and explained what their states/purpose is
    * Copyright notices and headers should always be applied to the top of a class if provided
    * Conditional statements should be on one line for clarity and **always** have a comment in a human readable format above it
    * Use the proper logging procedure [Example](http://stackoverflow.com/questions/906233/logging-in-java-and-in-general-best-practices)
    * Never commit anything with "System.out.print" these should only be used inside your development environment, or within a debug mode
    * Initialization of variables should not be in their declaration, but in a constructor or static constructor
    * Declarations should be made on multiple lines, even if they can be shorten to one line. 
    ```java
        // Example Declaration
        BigDecimal foo = new BigDecimal(0), bar = new BigDecimal(0);
        // Corrected
        BigDecimal foo = new BigDecimal(0);
        BigDecimal bar = new BigDecimal(0);
    ```
    * Tabs should be **2 spaces** this allows easy editing and viewing on github
* General Practices
    * A efficiency program will always be of higher priority. Even if something can be done in a day, take the time to make a program/logic that will last more then the time expected, and that will take into accound unseen errors
    * Make your program "flow" it should run from the top to the bottom, a person should be able to read down the page and understand what is happening
    * The main class is for starting the program object, not for creating everything.
    * The main should have the most comments, when someone reads through the main they should be able to understand what the whole program does
    * This repo is for the public, even if it was private a programmer should code to make his code look just as beautiful as it is in functionality
    * Don't write BS code, take the time to make something worth commmiting
    * Have clean commits, if you are going to do formatting, do it in another commit. Other contributors should be able to see clean diffs and understand what is happening
    * Commit messages should be descriptive, while the commit info should have details

Example
--------------

```java
import java.util;

public class Classname {
    
    // Data storage
    public static HashMap<String, Object> client_data;
    
    /**
     *  Default Constructor for the Classname Mod.
     */
    public Classname() {
        // TODO: Load data from local storage if needed
        // Create data hash
        client_data = new HashMap<String, Object>();
        // Defaults
        this.setDataDefaults_All();     
    }

    /**
     * This method starts all listeners that the client uses.
     * Each Listener can be configured in the config
     */
    public void startListeners() {
        // Main display listener
        Main.LOGGER.info("[Mod]: Adding Display Listener");
        new DisplayListener();
        // Data update listeners
        Main.LOGGER.info("[Mod]: Adding Data Listener");
        new DataListener();
        // TODO: Background thread listeners
    }
    
    /**
     * This is just an example method.
     * These should be discriptive
     *
     * @param message What message was received
     * @param noColorMessage What messaged was received minus the color codes
     */
    public static void handleMessage(String message, String noColorMessage) {
        
        // Cancel the event if needed
        if(line_capture != 0){
            line_capture -= 1;
            event.setCanceled(true);
        }

        // Server current update
        if(noColorMessage.contains("You are currently on ")){
            String server = noColorMessage.replace("You are currently on ", "");
            Classname.client_data.put("server", server);
            event.setCanceled(true);
            line_capture += 1;
            return;
        }
        
        return;
    }
```    