//disclaimer: I uploaded my work to github through eclipese's built-in github integration. 
//But the project somehow disappeared from my local file directory when I tried to upload to canvas.
//So I had to copy and paste everything I had to a text editor. Then create a brand new project in Eclipse and paste them back.
//if the timestamps (if there are timestamps) look weird, it's because of the last minute copy and pasting. I definitely did not copy other people's work...


package hw7;

import java.util.ArrayList;

public class Fraction {
	private int numerator, denominator;

    /**
     * helper function. this computes the greatest common divisor of two integers.
     * @param a, b
     * @return The greatest common divisor of a and b.
     */
    private int gcd(int a, int b) {
    	a = Math.abs(a);
    	b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    private static int gcdStatic(int a, int b) {
    	a = Math.abs(a);
    	b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        else {
            return gcdStatic(b, a % b);
        }
    }

	/**The constructor to create a Fraction with the given numerator and denominator.
 		The constructor should set the numerator and denominator instance variables in the Fraction class.
		The constructor should also properly format negative fractions. The convention is that negative fractions have the negative in the numerator.
 		For example:
 		Creating a new Fraction(4, 16) would set the numerator to 4 and the denominator to 16
 		Creating a new Fraction(4, -16) would set the numerator to -4 and the denominator to 16
 		Creating a new Fraction(-1, -2) would set the numerator to 1 and the denominator to 2
	 *
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator) {

		// in the prompt, already assuming no user will input denominator = 0
		if (denominator < 0) {
			this.numerator = numerator * -1;
			this.denominator = denominator * -1;
		} else {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		reduceToLowestForm(this.numerator, this.denominator);

	}

	/**Reduce the current fraction by eliminating common factors.
	 * That is, turn a fraction like 4/16 into 1/4 and a fraction like 320/240 into 4/3.
	 * Remember, the convention is that negative fractions have the negative in the numerator.
	 * For example:
	 * o A fraction like 4/16 would reduce to 1/4
	 * o A fraction like 10/-15 would reduce to -2/3
	 * o The reduced form of any fraction that represents 0 is 0/1
	 * 	e.g. 0/4 reduces to 0/1
	 */

	public void reduceToLowestForm(int numerator, int denominator) {
		int gcd = gcd(numerator, denominator);

		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;

	}

	public static Fraction reduceToLowestFormStatic(int numerator, int denominator) {
		int gcd = gcdStatic(numerator, denominator);

		numerator = numerator / gcd;
		denominator = denominator / gcd;

		return new Fraction(numerator, denominator);
	}


	/**Add the current fraction to the given otherFraction.
	 * Returns a new Fraction that is the sum of the two Fractions.
	 * The returned Fraction must be in reduced/lowest form.
	 * For example:
	 *	o Adding the fraction 3/5 to the fraction 1/4 reduces to 17/20
	 *	o Adding the fraction -1/2 to the fraction 2/-3 reduces to -7/6
	 * @param otherFraction
	 * @return
	 */
	public Fraction add(Fraction otherFraction) {
		return new Fraction(this.numerator * otherFraction.denominator + this.denominator * otherFraction.numerator,
	            this.denominator * otherFraction.denominator);

	}


	/**Subtract the given otherFraction from the current fraction.
	 * That is, thisFraction - otherFraction.
	 * Returns a new Fraction that is the difference of the two Fractions.
	 * The returned Fraction must be in reduced/lowest form.
	 * For example:
	 * o Subtracting the fraction 3/9 from the fraction 5/9 reduces to 2/9
	 * o Subtracting the fraction 5/16 from the fraction 4/16 reduces to -1/16
	 * @param otherFraction
	 * @return
	 */
	public Fraction substract(Fraction otherFraction) {
		return new Fraction(this.numerator * otherFraction.denominator - this.denominator * otherFraction.numerator,
	            this.denominator * otherFraction.denominator);

	}

	/**Multiply the current fraction by the given otherFraction.
	 * Returns a new Fraction that is the product of this fraction and the otherFraction.
	 * The returned Fraction must be in reduced/lowest form.
	 * For example:
	 * o Multiplying the fraction 1/2 by the fraction 2/3 reduces to 1/3
	 * @param otherFraction
	 * @return
	 */
	public Fraction mul(Fraction otherFraction) {
		return new Fraction(this.numerator * otherFraction.numerator, this.denominator * otherFraction.denominator);

	}


	/**Divide the current fraction by the given otherFraction.
	 * That is, thisFraction / otherFraction.
	 * Returns a new Fraction that is the quotient of this fraction and the otherFraction.
	 * The returned Fraction must be in reduced/lowest form.
	 * For example:
	 *	o Dividing the fraction 4/16 by the fraction 5/16 reduces to 4/5
	 * @param otherFraction
	 * @return
	 */

	public Fraction div(Fraction otherFraction) {
		return new Fraction(this.numerator * otherFraction.denominator, this.denominator * otherFraction.numerator);

	}


	/**Return this fraction in decimal form.
	 * For example:
	 *	o For the fraction 2/4, this method should return the value 0.5
	 *	o For the fraction 1/3, this method should return the approximate value 0.3333333333333333
	 *		▪ Note, to unit test double values like this, use assertEquals with a delta (see the lecture on Unit Testing)
	 * @return
	 */
	public double decimal() {

		return ((double)this.numerator / this.denominator);

	}


	/**Square the current fraction.
	 * This method modifies the current fraction and reduces it to lowest form.
	 * For example:
	 *	o A fraction like 2/3 will become 4/9
	 *	o A fraction like 4/16 will become 1/16
	 */
	public void sqr() {
		int numSqr = this.numerator * this.numerator;
		int deSqr = this.denominator * this.denominator;

		this.numerator = numSqr;
		this.denominator = deSqr;

		reduceToLowestForm(this.numerator, this.denominator);

	}


	/**Average the current fraction with the given otherFraction.
	 * Return a new Fraction that is the average of this fraction and the otherFraction.
	 * The returned Fraction must be in reduced/lowest form.
	 * For example:
	 *	o Averaging the fraction 5/8 with the fraction -12/16 reduces to -1/16
	 * @param otherFraction
	 * @return
	 */
	public Fraction average(Fraction otherFraction) {

		return new Fraction(this.numerator * otherFraction.denominator + this.denominator * otherFraction.numerator,
	            this.denominator * otherFraction.denominator * 2);

	}


	/**
	//	 *  Static method to average all of the fractions in the given array.
	//o Note, you don’t need to create an instance of the Fraction class in order
	//to call a static method
	//o For example, you should be able to call this method with the class name
	//(note upper-case in “Fraction”)
	//     Fraction f = Fraction.average(myArrayOfFractions);
	//• Do not include the current fraction in the average.
	//• Return the average of the array.
	//• The returned Fraction must be in reduced/lowest form.
	//• If the array is empty, return a new Fraction that equals 0. That is 0/1.
	//• For example:
	//o The average of the fractions 3/4, 3/5, and 3/6 reduces to 37/60
	 *
	 * @param myArrayOfFractions
	 * @return
	 */

	// In FractionTest.java, when this and the previous method had the same name (average), it's always automatically
	// pointing to the other method and giving me errors. So I changed the name of this static method.
	public static Fraction averageOfArray(ArrayList<Fraction> myArrayOfFractions) {

		//iterate, get sum first. then divide by number of Fractions in the array


		Fraction iterateFraction = myArrayOfFractions.get(0);

		// get the sum
		for (int i = 1; i < myArrayOfFractions.size(); i++) {

			int newNumerator = iterateFraction.numerator * myArrayOfFractions.get(i).denominator + iterateFraction.denominator * myArrayOfFractions.get(i).numerator;
			int newDenominator = iterateFraction.denominator * myArrayOfFractions.get(i).denominator;

			iterateFraction.numerator = newNumerator;
			iterateFraction.denominator = newDenominator;

			iterateFraction = reduceToLowestFormStatic(iterateFraction.numerator, iterateFraction.denominator);
		}

		iterateFraction.denominator = iterateFraction.denominator * myArrayOfFractions.size();

		return iterateFraction;


	}

	/**Static method to average all the integers in the given array.
	//o Again, you don’t need to create an instance of the Fraction class in order
	//to call a static method
	//o For example, you should be able to call this method with the class name
	//(note upper-case in “Fraction”)
	//     Fraction f = Fraction.average(myArrayOfInts);
	//• Do not include the current fraction in the average.
	//• Return the average of the array as a new Fraction.
	//• The returned Fraction must be in reduced/lowest form.
	//• If the array is empty, return a new Fraction that equals 0. That is 0/1.
	//• For example:
	//o The average of the ints 1, 2, 3, and 4 reduces to 5/2
	 *
	 * @param ints
	 * @return
	 */

	//same reason, changed the method name to averageOfInt
	public static Fraction averageOfInt(int[] ints) {

		int numerator = 0;
		int denominator = ints.length;

		//iterate and get the sum
		for (int i = 0; i < ints.length; i++) {
			numerator += ints[i];
		}

		Fraction returnFraction = new Fraction (numerator, denominator);

		returnFraction = reduceToLowestFormStatic(returnFraction.numerator, returnFraction.denominator);

		return returnFraction;
	}


	/**Overriden method to compare the given object (as a fraction) to the current fraction, for equality.
	 * Two fractions are considered equal if they have the same numerator and same denominator, after eliminating common factors.
	 * This method does not (permanently) reduce the current fraction to lowest form.
	 * For example:
	 *	o The fraction 2/3 is equal to the fraction 2/3
	 *	o The fraction 4/16 is equal to the fraction 1/4, but the fraction 4/16 is not reduced to lowest form.
	 */
	@Override
	public boolean equals(Object object) {
		// not permanently reduced, so cannot use this method
//		reduceToLowestForm(this.numerator, this.denominator);

		int gcd = gcd(numerator, denominator);

		Fraction otherFraction = (Fraction) object;


		if ((this.numerator)/gcd == otherFraction.numerator && (this.denominator)/gcd == otherFraction.denominator) {
			return true;
		} else {
			return false;
		}


	}


	/**Overriden method to return a string representation of the current fraction.
	 * A fraction like 2/3 will be represented in string form as “2/3”.
	 * There is a no whitespace in this string.
	 * If the fraction is negative, it will be expressed as “-2/3”, not “2/-3”.
	 */
	@Override
	public String toString() {
		if (denominator != 1) {
			return (numerator + "/" + denominator);
		} else {
			return Integer.toString(numerator);
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


