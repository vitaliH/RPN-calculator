# A high-level description of solution
Based on the need from the user and business model, a high-level design hypothesis looks like command line client to RPN calculator. It was done some architecture work prior to sketching the design, i.e. an evaluation of different options of how the solution would look like, the best option was decided to use Stack as data structure for RPN calculator. 

* The design hypothesis is a solution with this functionality
1. User is able to enter unlimited about of numbers
2. User is able use the following operations : addition, subtraction, multiplication, division
3. It should  be possible in future to extend operation list


# Reasoning behind technical choices, including architectural
Stack is the best option as data structure to operation on top of all data container, in this case its possible to avoid redunant lines of code to perform serching of operation. 

# Trade-offs 
It should be implemented web version of the project with a nice UI and tutorial for users how to use RPN calculator.

# Run Instructions 
* Download project
* In case of command line running :
1. enter project folder 
2. run command `mvn clean package`
3. run command `java -jar target/rpn-calculator-1.0.jar`

* In case of using IDE just import this project as Maven project and run it from  `com.rpn.Application` class.

