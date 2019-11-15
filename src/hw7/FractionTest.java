package hw7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFraction() {
		assertEquals("1/5", new Fraction(1,5).toString());
		assertEquals("-1/2", new Fraction(-2,4).toString());
		assertEquals("-2/3", new Fraction(6,-9).toString());
		assertEquals("0", new Fraction(0,-9).toString());
	}

	@Test
	void testAdd() {
		Fraction otherFraction1 = new Fraction(1, 2);
		assertEquals("1", new Fraction(-1, -2).add(otherFraction1).toString());

		Fraction otherFraction2 = new Fraction(1, -3);
		assertEquals("-2/3", new Fraction(-1, 3).add(otherFraction2).toString());

		Fraction otherFraction3 = new Fraction(-4, 20);
		assertEquals("0", new Fraction(1, 5).add(otherFraction3).toString());
	}

	@Test
	void testSubstract() {
		Fraction otherFraction1 = new Fraction(1, 2);
		assertEquals("0", new Fraction(-1, -2).substract(otherFraction1).toString());

		Fraction otherFraction2 = new Fraction(1, 10);
		assertEquals("0", new Fraction(2, 20).substract(otherFraction2).toString());

		Fraction otherFraction3 = new Fraction(-5, -20);
		assertEquals("-1/4", new Fraction(0, 2).substract(otherFraction3).toString());
	}

	@Test
	void testMul() {
		Fraction otherFraction1 = new Fraction(1, 2);
		Fraction otherFraction2 = new Fraction(2, -3);
		Fraction otherFraction3 = new Fraction(3, 6);

		assertEquals("-1/3", (otherFraction1.mul(otherFraction2)).toString());
		assertEquals("1/4", (otherFraction1.mul(otherFraction3)).toString());
		assertEquals("-1/3", (otherFraction2.mul(otherFraction3).toString()));
	}

	@Test
	void testDiv() {
		Fraction otherFraction1 = new Fraction(1, 2);
		Fraction otherFraction2 = new Fraction(1, -3);
		Fraction otherFraction3 = new Fraction(-2, 10);

		assertEquals("-3/2", (otherFraction1.div(otherFraction2)).toString());
		assertEquals("-5/2", (otherFraction1.div(otherFraction3)).toString());
		assertEquals("5/3", (otherFraction2.div(otherFraction3).toString()));
	}

	@Test
	void testDecimal() {
		assertEquals(0.5, new Fraction(2, 4).decimal(), 0.0000001);
		assertEquals(0.33333333333, new Fraction(1, 3).decimal(), 0.0000001);
		assertEquals(0, new Fraction(0, 3).decimal(), 0.0000001);
	}


	@Test
	void testAverageFraction() {
		Fraction otherFraction1 = new Fraction(1, 2);
		Fraction otherFraction2 = new Fraction(2, -3);
		Fraction otherFraction3 = new Fraction(3, 6);
		Fraction otherFraction4 = new Fraction(0, 6);

		assertEquals("-1/12", (otherFraction1.average(otherFraction2)).toString());
		assertEquals("1/2", (otherFraction1.average(otherFraction3)).toString());
		assertEquals("1/4", (otherFraction1.average(otherFraction4).toString()));
	}

	@Test
	void testAverageFractionArray() {

		//first test case with one Fraction
		ArrayList<Fraction> myArrayOfFractions0 = new ArrayList<Fraction>();

		myArrayOfFractions0.add(new Fraction(1, 2));

		Fraction f0 = Fraction.averageOfArray(myArrayOfFractions0);

		assertEquals("1/2", f0.toString());

		//second test case with two Fractions
		ArrayList<Fraction> myArrayOfFractions1 = new ArrayList<Fraction>();

		myArrayOfFractions1.add(new Fraction(1, 2));
		myArrayOfFractions1.add(new Fraction(1, 3));

		Fraction f1 = Fraction.averageOfArray(myArrayOfFractions1);

		assertEquals("5/12", f1.toString());

		//third test case with three Fractions
		ArrayList<Fraction> myArrayOfFractions2 = new ArrayList<Fraction>();

		myArrayOfFractions2.add(new Fraction(1, 2));
		myArrayOfFractions2.add(new Fraction(1, 3));
		myArrayOfFractions2.add(new Fraction(1, 4));

		Fraction f2 = Fraction.averageOfArray(myArrayOfFractions2);

		assertEquals("13/36", f2.toString());


	}

	@Test
	void testAverageIntArray() {
		//first test case with 2 int
		int[] myArrayOfInts0 = new int[2];
		myArrayOfInts0[0] = 1;
		myArrayOfInts0[1] = 2;

		Fraction f0 = Fraction.averageOfInt(myArrayOfInts0);

		assertEquals("3/2", f0.toString());

		//second test case with 3 int
		int[] myArrayOfInts1 = new int[3];
		myArrayOfInts1[0] = 1;
		myArrayOfInts1[1] = 2;
		myArrayOfInts1[2] = 3;

		Fraction f1 = Fraction.averageOfInt(myArrayOfInts1);

		assertEquals("2", f1.toString());

		//third test case with 4 int
		int[] myArrayOfInts2 = new int[4];
		myArrayOfInts2[0] = 1;
		myArrayOfInts2[1] = 2;
		myArrayOfInts2[2] = 3;
		myArrayOfInts2[3] = 4;

		Fraction f2 = Fraction.averageOfInt(myArrayOfInts2);

		assertEquals("5/2", f2.toString());

	}



	@Test
	void testEqualsObject() {
		Fraction otherFraction1 = new Fraction(1, 2);
		Fraction otherFraction2 = new Fraction(2, 4);
		Fraction otherFraction3 = new Fraction(-1, 2);
		Fraction otherFraction4 = new Fraction(0, 2);

		assertTrue(otherFraction1.equals(otherFraction2));
		assertFalse(otherFraction1.equals(otherFraction3));
		assertFalse(otherFraction1.equals(otherFraction4));
	}

	@Test
	void testToString() {
		assertEquals("1/5", new Fraction(1,5).toString());
		assertEquals("-1/2", new Fraction(-2,4).toString());
		assertEquals("-2/3", new Fraction(6,-9).toString());
		assertEquals("0", new Fraction(0,-9).toString());
	}

}
