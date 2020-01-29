# cs5010_programmingDesignParadigms
This is a repository for my individual and team projects from the course CS 5010 Programming Design Paradigms at Northeastern University--Seattle. Throughout the course, we concentrated on object-oriented program design and the abstractions that support the design of reusable software and libraries using Java.

## Assignment 1
With Assignment 1, I applied the principles of OOD and polymorphism to the problems of designing a transit card system, hierarchy of artists, and hierarchy of publishing materials. The transit card system problem focuses on the design of each class' state and behaviors--responsibilities and interactions with one another. The hierarchy problems deal with the abstractions of the parent-children relations: which state and behaviors should be defined in the parent class and inherited, how each subclass behaves differently, should an intermediate concrete or abstract class be declared, etc.

## Assignment 2 & Refactoring
In Assignment 2, I further applied the concept of polymorphism in designing the solutions for a furniture system (Wardrobe vs. Door). The initial solution seperates the two furniture types into two large concrete parent classes that define shared state and behaviors for their subclasses. The refactored solution further improves on this by adding an abstract class (AbstractFurniture.java) to define the state and behaviors shared by the two parent classes, such that the redundancy is reduced in the class structure.

## Assignment 3 & Refactoring
In Assignment 3, I had the hand-on practice with command line input argument parsing, Java I/O, and regular expressions. The Main class is designed to parse the command line input arguments, the CsvReader reads the given CSV file and returns the data as a List, and the MessageGenerator replaces placeholder items with data from the List and outputs individual messages into txt files. The refactored solution adds an additional option to send email messages in the Main class.

## Assignment 4
In Assignment 4, the challenge is to design a ticketing reservation system to take on individual and group requests. For the problem, I made the simplifying abstraction that the seats in each section in the venue are unassigned to a specific person, such that the venue only needs to keep track of the number of available seats in each section, which group is assigned to which sections, and whether new members for the same group can be added to the same or nearby section.

## Assignment 5 (Group Assignment 1)
In Assignment 5, my team and I applied sequential and concurrency solutions in the file processing problems. In the sequential solution, I used a similar Java I/O solution to Assignment 3. In the concurrency solution, my team and I applied "producer-consumer" design in thread processing, in which multiple producer threads access the input files to process the data and a single consumer thread outputs the processed data into a csv file.

## Assignment 6 (Group Assignment 2)
The Assignment 6 is a build-on project to Assignment 5 with additional data to process. My team and I made the improvement to the structure and implemented a "producer-consumer-writer" design: Multiple producer and consumer threads will access and process data from an input file concurrently and update a shared concurrent map; when the threads are completed with processing, the writer thread reads from the map and writes to an output csv file.
We reasoned not to have the writer writes to the output file concurrently while the producer and consumer threads are updating the concurrent map, because constant reading and writing to file is expensive and we wanted to avoid that.

## Assignment 7 (Group Assignment 3)
In Assignment 7, we were given the task to write a random message generator. We designed it to have a class for processing the grammar requirements in the JSON file and a class for putting together the sentences.

## Assignment 8 (Group Assignment 4)
In Assignment 8, my team and I implemneted the MVC framework to the chatroom-server problem. The server is the monitor (M) that listens to the input from the users, the console is the view (V) that displays each user's messages, and the chat client thread is the controller (C) that processes and sends the user's requests.
