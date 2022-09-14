/**
 * Description: application that will check for valid passwords
 * @author Johnathan Duong
 * 
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * class to validate the password
 */
public class PasswordCheckerUtility extends Object{

	/**
	 * default constructor
	 */
	PasswordCheckerUtility(){
		
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		
		if(!password.equals(passwordConfirm)) {
			
			throw new UnmatchedException();
		}
		
	}
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @return true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {					
		if(password.equals(passwordConfirm)) {
			return true;
			
		}
		else
			return false;
	}
	
	/**
	 * Checks the password length requirement - The password must be at least 6 characters long
	 * @param password
	 * @return true if meets minimum length requirement
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException{
		
		if(password.length() <6) {
			throw new LengthException();
		}
		else
			return true;		
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		
		int count = 0;
		char letter;
		
		for(int i=0; i< password.length();i++) {
			letter = password.charAt(i);
			if(letter >= 65 && letter <=90) {
				count++;
			}
				
		}
		
		if(count > 0) {
				return true;
			}
		
		else
			throw new NoUpperAlphaException();
			
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * @param password
	 * @return true if meets lowercase requirement
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		
		int count = 0;
		char letter;
		
		for(int i = 0; i< password.length(); i++) {
			letter = password.charAt(i);
			if(letter >= 97 && letter <= 122) {
				count++;
			}
			
		}
		
		if(count <=0) {
			throw new NoLowerAlphaException();
		}
		
		else
			return true;
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password
	 * @return true if meet Digit requirement
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		
		int count =0;
		char letter;
		for(int i =0; i < password.length(); i++) {
			letter = password.charAt(i);
			if(letter >=48 && letter<=57) {
				count++;
			}
			
		}
		
		if(count>0) {
			return true;
		}
			
		else
			throw new NoDigitException();
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
	    Matcher matcher = pattern.matcher(password);
	    if (matcher.find()) {
	    	return true;
	    }
	    else
	    	throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks the password Sequence requirement - 
	 * Password should not contain more than 2 of the same character in sequence
	 * @param password
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		
		for(int i =0; i < password.length(); i++) {
			
			if(i>=2) {
				if(password.charAt(i-1)==password.charAt(i)){		
					if(password.charAt(i-1)==password.charAt(i-2)) {
						throw new InvalidSequenceException();
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Return true if valid password (follows all the following rules), returns false if an invalid password 
	 * 1. At least 6 characters long - 2. At least 1 numeric character- 3. At least 1 uppercase alphabetic character - 
	 * 4. At least 1 lowercase alphabetic character - 5. At least 1 special character - 
	 * 6. No more than 2 of the same character in a sequence
	 * @param password
	 * @return true if valid password (follows all rules from above), false if an invalid password
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword​(String password)  
			throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		
		if (!PasswordCheckerUtility.isValidLength(password) )
			throw new LengthException();
		
		else if (!PasswordCheckerUtility.hasUpperAlpha(password) )
			throw new NoUpperAlphaException();
		
		else if (!PasswordCheckerUtility.hasLowerAlpha(password) )
			throw new NoLowerAlphaException();
		
		else if (!PasswordCheckerUtility.hasDigit(password) )
			throw new NoDigitException();
		
		else if (!PasswordCheckerUtility.hasSpecialChar(password)) 
			throw new NoSpecialCharacterException();
			
		else if (!PasswordCheckerUtility.NoSameCharInSequence(password))
			throw new InvalidSequenceException();
		
			return true;
		
	}
	
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		if(password.length() >= 6 && password.length() <= 9) {
			return true;
		}		
		else
			return false;
	}
	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		
			
			if(PasswordCheckerUtility.hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException();
			}
			else {
				return true;
			
			}		
	}
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the 
	 * status of any invalid passwords (weak passwords are not considered invalid). The ArrayList of invalid 
	 * passwords will be of the following format: password BLANK message of the exception thrown
	 * @param passwords
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) 
	{
		
		ArrayList<String> inValidPasswords = new ArrayList<>();
		
		for (int i=0; i< passwords.size(); i++)
		{
			try
			{
				PasswordCheckerUtility.isValidPassword​( passwords.get(i));
			}
			catch (LengthException| NoUpperAlphaException| NoLowerAlphaException|
									NoDigitException| NoSpecialCharacterException| InvalidSequenceException e)
			{
				inValidPasswords.add(passwords.get(i)+ " -> " +e.getMessage());
			}
			catch(Exception e)
			{
				inValidPasswords.add(passwords.get(i)+ " -> " +e.getMessage()); 
			}
		}
		return inValidPasswords;
	}
		
}