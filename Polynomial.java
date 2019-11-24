/*
 * PROJECT II: Polynomial.java
 *
 * This file contains a template for the class Polynomial. Not all methods are
 * implemented. Make sure you have carefully read the project formulation
 * before starting to work on this file.
 *
 * This class is designed to use Complex in order to represent polynomials
 * with complex co-efficients. It provides very basic functionality and there
 * are very few methods to implement! The project formulation contains a
 * complete description.
 *
 * Remember not to change the names, parameters or return types of any
 * variables in this file! You should also test this class using the main()
 * function.
 *
 * The function of the methods and instance variables are outlined in the
 * comments directly above them.
 */

class Polynomial {
    /**
     * An array storing the complex co-efficients of the polynomial.
     */
    Complex[] coeff;

    // ========================================================
    // Constructor functions.
    // ========================================================

    /**
     * General constructor: assigns this polynomial a given set of
     * co-efficients.
     *
     * @param coeff  The co-efficients to use for this polynomial.
     */
    public Polynomial(Complex[] coeff) {
        // You need to fill in this function.
    	Complex zero = new Complex();
    	int NoZeros = 0;
    	for (int i = 0; i < coeff.length; i++) {
    		if (coeff[coeff.length - i - 1] == zero) {
    			NoZeros++;
    		}
    		else {
    			break;
    		}
    	}
    	if ((coeff.length - NoZeros) == 0) {
    		Complex[] newCoeff = new Complex[1];
    		newCoeff[0] = new Complex();
    		
    		this.coeff = newCoeff;
    	}
    	else {
    		Complex[] newCoeff = new Complex[coeff.length - NoZeros];
    	
    		for (int i = 0; i < newCoeff.length; i++) {
    			newCoeff[i] = coeff[i];
    		}
    	
    		this.coeff = newCoeff;
    	}
    }
    
    /**
     * Default constructor: sets the Polynomial to the zero polynomial.
     */
    public Polynomial() {
        // You need to fill in this function.
    	Complex[] coeff = new Complex[1];
    	Complex zero = new Complex();
    	
    	coeff[0] = zero;
    	this.coeff = coeff;
    }

    // ========================================================
    // Operations and functions with polynomials.
    // ========================================================

    /**
     * Create a string representation of the polynomial.
     *
     * For example: (1.0+1.0i)+(1.0+2.0i)X+(1.0+3.0i)X^2
     */
    public String toString() {
        // You need to fill in this function.
    	String Polynomial = "(" + this.coeff[0].toString() + ")";
    	if (this.coeff.length > 1) {
    		Polynomial = Polynomial + "+(" + this.coeff[1].toString() + ")X";
    		if (this.coeff.length > 2) {
    			for (int i = 2; i < this.coeff.length; i++) {
    				Polynomial = Polynomial + "+(" + this.coeff[i].toString() + ")X^" + (i);
    			}
    		}
    	}
    	
    	return Polynomial;
    	
    	
    }

    /**
     * Returns the degree of this polynomial.
     */
    public int degree() {
        // You need to fill in this function.
    	return (this.coeff.length - 1);
    }

    /**
     * Evaluates the polynomial at a given point z.
     *
     * @param z  The point at which to evaluate the polynomial
     * @return   The complex number P(z).
     */
    public Complex evaluate(Complex z) {
        // You need to fill in this function.
    	Complex f = new Complex();
    	Complex xn = new Complex(1);
    	Complex iterm = new Complex();
    	for (int i = 0; i < this.coeff.length; i++) {
    		iterm.setReal(1);
    		iterm.setImag(0);
    		
    		iterm = iterm.multiply(this.coeff[i]);
    		iterm = iterm.multiply(xn);
    		
    		f = f.add(iterm);
    		
    		xn = xn.multiply(z);
    		
    	}
    	
    	return f;
    }
    
    /**
     * Calculate and returns the derivative of this polynomial.
     *
     * @return The derivative of this polynomial.
     */
    public Polynomial derivative() {
        // You need to fill in this function.
    	Complex[] dcoeff = new Complex[this.coeff.length - 1];
    	for (int i = 1; i < this.coeff.length; i++) {
    		dcoeff[i-1] = coeff[i];
    		dcoeff[i-1] = dcoeff[i-1].multiply(i);
    	}
    	
    	Polynomial deriv = new Polynomial(dcoeff);
    	
    	return deriv;
    }
    
    // ========================================================
    // Tester function.
    // ========================================================

    public static void main(String[] args) {
        // You need to fill in this function.
    	Complex[] coeff = new Complex[] {new Complex(), new Complex(), new Complex(), new Complex()};
    	Polynomial f = new Polynomial(coeff);
    	Polynomial df = f.derivative();
    	Complex z = new Complex(1,1);
    	
    	
    	
    	System.out.println("f(" + z.toString() + ") = " + f.toString() + " = " + f.evaluate(z).toString());
    	System.out.println("f'(" + z.toString() + ") = " + df.toString() + " = " + df.evaluate(z).toString());
    	
    }
}