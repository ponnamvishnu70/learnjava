package learnjava.practice.regex;
//(470)-767-3679
//4707673689
//470.767.3689
//470-767-3689
/*
. - Any Character Except New Line
\d - Digit (0-9)
\D - Not a Digit (0-9)
\w - Word Character (a-z, A-Z, 0-9, _)
\W - Not a Word Character
\s - Whitespace (space, tab, newline)
\S - Not Whitespace (space, tab, newline)

\b - Word Boundary
\B - Not a Word Boundary
^ - Beginning of a String
$ - End of a String

[] - Matches Characters in brackets
[^ ] - Matches Characters NOT in brackets
| - Either Or
( ) - Group

Quantifiers:
* - 0 or More
+ - 1 or More
? - 0 or One
{3} - Exact Number
{3,} -  n or more occurrences 
{3,4} - Range of Numbers (Minimum, Maximum)


#### Sample Regexs ####

[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+

*/


public class RegexExample {
	boolean isvalidPhoneNumber(){
		String phonenumber= "1234567890";
		String phonenumberwithhypens= "123-456-7890";
		String phonenumberwithbracketshypens= "(123)-456-7890";
		String phonenumberwithbrackets= "(123)456-7890";
		
		System.out.println(phonenumber.matches("[(]?[\\d]{3}[).-]*[\\d]{3}[.-]*[\\d]{4}"));
		System.out.println(phonenumberwithhypens.matches("[(]?[\\d]{3}[).-]*[\\d]{3}[.-]*[\\d]{4}"));
		System.out.println(phonenumberwithbracketshypens.matches("[(]?[\\d]{3}[).-]*[\\d]{3}[.-]*[\\d]{4}"));
		System.out.println(phonenumberwithbrackets.matches("[(]?[\\d]{3}[).-]*[\\d]{3}[.-]*[\\d]{4}"));
		String ssn="123-45-6789";
		System.out.println(ssn.matches("[(]?[\\d]{3}[).-]*[\\d]{2}[.-]*[\\d]{4}"));
		String decimalnumber="12345";
		System.out.println(decimalnumber.matches("[\\d]+(\\.[\\d]{1,2})?"));
		String email ="vishnu+ponnam@gm1.ydu";
		System.out.println(email.matches("[a-zA-Z0-9+.]+@[a-zA-Z0-9]+\\.[a-zA-Z]+"));
		
		String line = "This order was placed for QT3000!  123 OK?";
		System.out.println(line.matches("(.*)(\\d+)(.*)"));
		String randomStr ="Yabxabs 123423";
		System.out.println("randomStr"+randomStr.matches("(abx|abs|abxabs)\\s[\\d]+"));
		String randomStr1 ="Yabxabs      123423";
		System.out.println("randomStr"+randomStr1.matches("[^\\d]+\\s[\\d]+"));
		
		return false;
	}
	public static void main(String[] args) {
		RegexExample rex= new  RegexExample();
		rex.isvalidPhoneNumber();
		
				
	}

}
