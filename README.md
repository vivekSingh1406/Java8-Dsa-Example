
        # What are the main features introduced in Java 8?

        Lambda expressions, Functional interfaces, Stream API, Default methods in interfaces
        Optional class, New Date and Time API


        # What is a Lambda expression?

        A Lambda expression is a concise way to represent an anonymous function (a function without a name)
         that can be passed around. It consists of parameters, the arrow token ->, and a body.


        # What is a Functional Interface?

        A Functional Interface is an interface that contains exactly one abstract method.
        It can have multiple default or static methods. An example is Runnable or Callable.

        # What is the Stream API?

        The Stream API allows for functional-style operations on streams of elements, such as sequences
        of data. It supports operations like filter, map, and reduce, enabling efficient data processing.


        # What are Default Methods in Interfaces?

        Default methods allow you to add new methods to interfaces without breaking existing implementations.
        They are defined using the default keyword.


        # What is the Optional class?

        The Optional class is a container object which may or may not contain a non-null value.
        It is used to avoid NullPointerExceptions.

        Common Methods:
            isPresent(), get(), orElse(T other), ifPresent(Consumer<? super T> action)



        # How do you handle checked exceptions inside stream operations (like in lambda expressions)

        Use Optional class we can handle null pointer exception
           Use Try-Catch Inside Lambda (For Unchecked or Rare Checked Exceptions)

        # Difference between Collectors.toList() and toSet()
         toList() allows duplicates and maintains order.
         toSet() removes duplicates and does not maintain order.

        # How do you parallelize streams in Java 8

        A parallel stream splits the source data into multiple parts and processes them
          concurrently using the ForkJoinPool (common thread pool). It uses divide-and-conquer internally.

          Sequential	list.stream()	    Single Thread
          Parallel	list.parallelStream()	Multiple Threads

          Parallel streams split tasks across threads to leverage multicore CPUs,
          improving performance for stateless, large datasets. However, they introduce
          thread-safety concerns and may not suit I/O-heavy or order-sensitive operations.


        # What is Lazy Evaluation in Java Streams
        
        Lazy evaluation means that intermediate operations in a stream (like map(), filter(), sorted())
        are not executed immediately when the stream is created or transformed.

        Java streams are lazy, meaning intermediate operations (e.g., map, filter, sorted) are not executed
        immediately. Execution happens only when a terminal operation is called, like collect(), count(), or forEach().

        Intermediate Operations: return a new stream (e.g., filter(), map(), sorted())
        Terminal Operations: produce a result or a side effect (e.g., collect(), forEach(), reduce())

        # What is the Stream API in Java
        
        The Stream API, introduced in Java 8, is used for processing collections (like Lists, Sets) in a functional and 
        declarative style. Streams support operations like filter, map, reduce, collect, etc.

        # What are default and static methods in interfaces?

        default methods provide a default implementation.
        static methods belong to the interface class and are not inhe

