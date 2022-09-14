
public class InvalidSequenceException extends Exception {

	public InvalidSequenceException() {
		super("Password should not contain more than 2 of the same character in sequence");
	}
}
