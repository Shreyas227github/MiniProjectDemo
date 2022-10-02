package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainTest {
	
	public static void main(String[] args) {
		Quiz q = new Quiz();
		q.logic();
		
	}
}
class Quiz {
	
	Scanner scanner = new Scanner(System.in);
	int correctAnsCount = 0;
	int wrongAnsCount = 0;
	
	public void logic() {
	
	Questions q1 = new Questions(" An interface with no fields or methods is known as a ______.",
					"a. Runnable Interface", "b. Marker Interface",
					"c. Abstract Interface", "d. CharSequence Interface");
	Questions q2 = new Questions("Which of these classes are the direct subclasses of the Throwable class?",
					"a. RuntimeException and Error class", "a. RuntimeException and Error class",
					"c. Error and Exception class", "d. IOException and VirtualMachineError class");
	Questions q3 = new Questions("In which memory a String is stored, when we create a string using new operator?",
					"a. Stack", "b. String memory", "c. Heap memory", "d. Random storage space");
	Questions q4 = new Questions("What is the use of the intern() method?",
					"a. It returns the existing string from memory", "b. It creates a new string in the database",
					"c. It modifies the existing string in the database", "d. None of the above");
	Questions q5 = new Questions("Which keyword is used for accessing the features of a package?",
					"a. package", "b. import", "c. extends", "d. export");
	Questions q6 = new Questions("Which of the following is a mutable class in java?",
					"a. java.lang.String", "b. java.lang.Byte", "c. java.lang.Short", "d. java.lang.StringBuilder");
	Questions q7 = new Questions("What is meant by the classes and objects that dependents on each other?",
					"a. Tight Coupling", "b. Cohesion", "c. Loose Coupling", "d. None of the above");
	Questions q8 = new Questions("If a thread goes to sleep",
					"a. It releases all the locks it has.", "b. It does not release any locks",
					"c. It releases half of its locks.", "d. It releases all of its lock except one.");
	Questions q9 = new Questions("What is the return type of the hashCode() method in the Object class?",
					"a. Object", "b. int", "c. long", "d. void");
	Questions q10 = new Questions("Which of the following can be declared as final in java?",
					"a. Class", "b. Method", "c. Variable", "d. All of these");
	
	Map<Questions, Character> hm = new HashMap<>();
	hm.put(q1, 'b');
	hm.put(q2, 'c');
	hm.put(q3, 'c');
	hm.put(q4, 'a');
	hm.put(q5, 'b');
	hm.put(q6, 'd');
	hm.put(q7, 'a');
	hm.put(q8, 'b');
	hm.put(q9, 'b');
	hm.put(q10, 'd');
	
	System.out.println(" Enter  your Name>> ");
	String studentName = scanner.next();
	
	for(Map.Entry<Questions, Character> map:hm.entrySet()) {
		System.out.println(map.getKey().getQuestion());
		System.out.println(map.getKey().getOption1());
		System.out.println(map.getKey().getOption2());
		System.out.println(map.getKey().getOption3());
		System.out.println(map.getKey().getOption4());
		
		System.out.println(" Enter your Answer>> ");
		Character ans = scanner.next().charAt(0);
		
		int cans = Character.compare(ans, map.getValue());
		
		if(cans == 0) {
			System.out.println(" Correct");
			correctAnsCount++;
		}
		else {
			System.out.println(" Wrong");
			wrongAnsCount++;
		}
	}
	
	System.out.println();
	System.out.println(studentName + " Result is>> ");
	System.out.println("Total Questions>> " + hm.size());
	System.out.println("Correct Answered Questions>> " + correctAnsCount);
	System.out.println("Wrong Answered Questions>> " + wrongAnsCount);
	System.out.println("Total Marks>> " + correctAnsCount + "/" + hm.size());
	
	if (correctAnsCount < 5) {
		System.out.println(" Fail");
		System.out.println(" Very Poor Performance and Better Luck Next Time>> ");
	}else if (correctAnsCount <= 5) {
		System.out.println(" Your Grade is>> ");
		System.out.println(" C Grade>> ");
		System.out.println(" Need More Study>> ");
	}else if (correctAnsCount <= 6 || correctAnsCount <= 7 || correctAnsCount <= 8) {
		System.out.println(" Your Grade is>> ");
		System.out.println(" B Grade>> ");
		System.out.println("  Good Performance>> ");
	}else {
		System.out.println(" Your Grade is>> ");
		System.out.println(" A Grade>> ");
		System.out.println(" Impressive And Excellent Performance>> ");
	}
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Shraddha@171995");
	    PreparedStatement ps = connection.prepareStatement("INSERT into studentData (studentName, Marks) VALUES (?, ?)");
	    ps.setString(1, studentName);
	    ps.setInt(2, correctAnsCount);
	    
	    int i = ps.executeUpdate();
	    System.out.println();
	    System.out.println(" Your Test is Submitted>> " + i);
	    System.out.println(" Thanks for Participation>> ");
	    
	    connection.close();
	    ps.close();
	    
	}catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	} 
			
}

}


