/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

import java.awt.Color;

/**
 *
 * @author Admin
 */
public class Mandelbrot {
     // return number of iterations to check if c = a + ib is in Mandelbrot set
	/**
	 * 
     * @param z0
     * @param max
     * @return 
	 * @see http://introcs.cs.princeton.edu/java/32class/Mandelbrot.java.html
	 */
    public static int mandelbrot(ComplexNumber z0, int max) {
        ComplexNumber z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }
    
    public static int greyMandelbrotFormula(ComplexNumber z0, int maxIter) {
    	return maxIter - Mandelbrot.mandelbrot(z0, maxIter);
    }
    
    public static int colorMandelbrotFormula(ComplexNumber z0, int maxIter) {
    	if(maxIter - Mandelbrot.mandelbrot(z0, maxIter) == 0) {
    		return maxIter - Mandelbrot.mandelbrot(z0, maxIter);
    	}
    	return Mandelbrot.mandelbrot(z0, maxIter) * 255 / maxIter;
    }
    
    /**
     *
     * @param z0
     * @param maxIter
     * @return
     */
    public static Color blackAndWhiteMandelbrot(ComplexNumber z0, int maxIter) {
    	int colorValue = Mandelbrot.greyMandelbrotFormula(z0, maxIter);
        return new Color(colorValue, colorValue, colorValue);
    }
    
    /**
     *
     * @param z0
     * @param maxIter
     * @return
     */
    public static Color greyMandelbrot(ComplexNumber z0, int maxIter) {
    	int colorValue = Mandelbrot.colorMandelbrotFormula(z0, maxIter);
        return new Color(colorValue, colorValue, colorValue);
    }
    
    /**
     *
     * @param z0
     * @param maxIter
     * @param c
     * @return
     */
    public static Color redMandelbrot(ComplexNumber z0, int maxIter, Color c) {
    	int colorValue = Mandelbrot.colorMandelbrotFormula(z0, maxIter);
        return new Color(colorValue, c.getGreen(), c.getBlue());
    }
    
    /**
     *
     * @param z0
     * @param maxIter
     * @param c
     * @return
     */
    public static Color greenMandelbrot(ComplexNumber z0, int maxIter, Color c) {
    	int colorValue = Mandelbrot.colorMandelbrotFormula(z0, maxIter);
        return new Color(c.getRed(), colorValue, c.getBlue());
    }
    
    public static Color blueMandelbrot(ComplexNumber z0, int maxIter, Color c) {
    	int colorValue = Mandelbrot.colorMandelbrotFormula(z0, maxIter);
        return new Color(c.getRed(), c.getGreen(), colorValue);
    }
}
