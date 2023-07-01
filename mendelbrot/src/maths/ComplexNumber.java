/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

/**
 *
 * @author Admin
 */
public class ComplexNumber {
    private final double re; // the real part
	private final double im; // the imaginary part

	// create a new object with the given real and imaginary parts
	public ComplexNumber(double real, double imag) {
		re = real;
		im = imag;
	}

	// return a string representation of the invoking Complex object
	public String toString() {
		if (im == 0)
			return re + "";
		if (re == 0)
			return im + "i";
		if (im < 0)
			return re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}

	// return abs/modulus/magnitude and angle/phase/argument
	public double abs() {
//		return Math.hypot(re, im);
		//Faster to use Math.sqrt() than Math.hypot()
		//@see: https://stackoverflow.com/questions/3764978/why-hypot-function-is-so-slow/3764993#3764993
		return Math.sqrt(re*re + im*im);
	} // Math.sqrt(re*re + im*im)

	public double phase() {
		return Math.atan2(im, re);
	} // between -pi and pi

	// return a new Complex object whose value is (this + b)
	public ComplexNumber plus(ComplexNumber b) {
		ComplexNumber a = this; // invoking object
		double real = a.re + b.re;
		double imag = a.im + b.im;
		return new ComplexNumber(real, imag);
	}

	// return a new Complex object whose value is (this - b)
	public ComplexNumber minus(ComplexNumber b) {
		ComplexNumber a = this;
		double real = a.re - b.re;
		double imag = a.im - b.im;
		return new ComplexNumber(real, imag);
	}

	// return a new Complex object whose value is (this * b)
	public ComplexNumber times(ComplexNumber b) {
		ComplexNumber a = this;
		double real = a.re * b.re - a.im * b.im;
		double imag = a.re * b.im + a.im * b.re;
		return new ComplexNumber(real, imag);
	}

	// scalar multiplication
	// return a new object whose value is (this * alpha)
	public ComplexNumber times(double alpha) {
		return new ComplexNumber(alpha * re, alpha * im);
	}

	// return a new Complex object whose value is the conjugate of this
	public ComplexNumber conjugate() {
		return new ComplexNumber(re, -im);
	}

	// return a new Complex object whose value is the reciprocal of this
	public ComplexNumber reciprocal() {
		double scale = re * re + im * im;
		return new ComplexNumber(re / scale, -im / scale);
	}

	// return the real or imaginary part
	public double re() {
		return re;
	}

	public double im() {
		return im;
	}

	// return a / b
	public ComplexNumber divides(ComplexNumber b) {
		ComplexNumber a = this;
		return a.times(b.reciprocal());
	}

	// return a new Complex object whose value is the complex exponential of
	// this
	public ComplexNumber exp() {
		return new ComplexNumber(Math.exp(re) * Math.cos(im), Math.exp(re)
				* Math.sin(im));
	}

	// return a new Complex object whose value is the complex sine of this
	public ComplexNumber sin() {
		return new ComplexNumber(Math.sin(re) * Math.cosh(im), Math.cos(re)
				* Math.sinh(im));
	}

	// return a new Complex object whose value is the complex cosine of this
	public ComplexNumber cos() {
		return new ComplexNumber(Math.cos(re) * Math.cosh(im), -Math.sin(re)
				* Math.sinh(im));
	}

	// return a new Complex object whose value is the complex tangent of this
	public ComplexNumber tan() {
		return sin().divides(cos());
	}

	// a static version of plus
	public static ComplexNumber plus(ComplexNumber a, ComplexNumber b) {
		double real = a.re + b.re;
		double imag = a.im + b.im;
		ComplexNumber sum = new ComplexNumber(real, imag);
		return sum;
	}

	// sample client for testing
	public static void main(String[] args) {
		ComplexNumber a = new ComplexNumber(5.0, 6.0);
		ComplexNumber b = new ComplexNumber(-3.0, 4.0);

		System.out.println("a            = " + a);
		System.out.println("b            = " + b);
		System.out.println("Re(a)        = " + a.re());
		System.out.println("Im(a)        = " + a.im());
		System.out.println("b + a        = " + b.plus(a));
		System.out.println("a - b        = " + a.minus(b));
		System.out.println("a * b        = " + a.times(b));
		System.out.println("b * a        = " + b.times(a));
		System.out.println("a / b        = " + a.divides(b));
		System.out.println("(a / b) * b  = " + a.divides(b).times(b));
		System.out.println("conj(a)      = " + a.conjugate());
		System.out.println("|a|          = " + a.abs());
		System.out.println("tan(a)       = " + a.tan());
	}
    
}
