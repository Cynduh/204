
public class NoDigitException extends Exception {

	public NoDigitException(){
		super("Password must contain a numeric character");
	}
}
