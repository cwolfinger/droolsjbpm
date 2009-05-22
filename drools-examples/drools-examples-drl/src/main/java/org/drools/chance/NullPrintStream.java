package org.drools.chance;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class NullPrintStream extends PrintStream {

	public NullPrintStream(String fileName) throws FileNotFoundException {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	public void println(String s) {
		
	}

}
