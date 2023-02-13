

import java.util.ArrayList;

public class TimeZone {
	
	public static void main(String[] args) {
		ArrayList<Double> HPlusVals = new ArrayList<>();
		ArrayList<Double> HMinusVals = new ArrayList<>();
		ArrayList<Double> HVals = new ArrayList<>();
		
		double t = 0;
		int tF = 72;
		double amplitude = 0.1, alpha= 0, T = 24, xS = 4.2, xW = 18.2, hPlus = .6, hMinus = 0.17, hStart  = .26;
		
		HPlusVals.add(hPlus);
		HMinusVals.add(hMinus);
		HVals.add(hStart);
		double coef = (2*Math.PI/T);
		
		boolean awake = true;
		
		for (int i = 0; i < tF*10; i ++)
		{
			
			//hour a 2 hour time shift we are setting the alpha to be shifted so after 2 days it is 2 hours ahead
			if (i < 480)
			{
				alpha += 1/240;
			}
			
			
			double C = amplitude * Math.sin(coef * (t - alpha));
			double hP = HPlusVals.get(0) + C; 
			HPlusVals.add(hP);
			
			double hM = HMinusVals.get(0) + C; 
			HMinusVals.add(hM);
			
			t = t + .1;
			double h = HVals.get(i); 
			
			if (awake)
			{
				h += ((1 - HVals.get(i))/xW) * .1;
				HVals.add(h);
			}
			else
			{
				h += (-(HVals.get(i))/xS) *.1;
				HVals.add(h);
			}
			
			if (h >= hP)
			{
				awake = false;
			}
			else if (h <= hM)
			{
				awake = true;
			}
			
	}
	sleep.printVals(HPlusVals, HMinusVals, HVals);

		
	}
	

}
