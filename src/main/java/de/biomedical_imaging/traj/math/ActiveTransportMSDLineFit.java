package de.biomedical_imaging.traj.math;

import ij.measure.CurveFitter;
import de.biomedical_imaging.traJ.TrajectoryUtil;

/**
 * Fits the msd data to the function
 * msd(dt) = (v*dt)^2 + 4*D*dt
 * @author Thorsten Wagner
 *
 */
public class ActiveTransportMSDLineFit {
	/*
	 * Fits:
	 * msd(dt) = (v*dt)^2 + 4*D*dt
	 */
	double a;
	double b;
	double goodness;

	public void doFit(double[] xdata, double[] ydata){
		
		CurveFitter fitter = new CurveFitter(xdata, ydata);

		fitter = new CurveFitter(xdata, ydata);
		
		fitter.doCustomFit("y=a*a*x*x + 4*sqrt(b*b)*x", new double[]{0,0}, false);
		a = Math.abs(fitter.getParams()[0]);
		b = Math.abs(fitter.getParams()[1]);
		goodness = fitter.getFitGoodness();

	}
	
	public double getVelocity(){
		return a;
	}
	
	public double getDiffusionCoefficient(){
		return b;
	}
	
	public double getFitGoodness(){
		return goodness;
	}
}
