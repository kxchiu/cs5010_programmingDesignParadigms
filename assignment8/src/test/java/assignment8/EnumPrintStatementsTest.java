package assignment8;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class EnumPrintStatementsTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void printString() {
		EnumPrintStatements.UNKNOWN_COMMAND.printString();
		assertEquals("Unknown command. Please respond again.", outContent.toString().trim());
	}
}