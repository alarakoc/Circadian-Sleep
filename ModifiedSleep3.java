import java.util.ArrayList;

public class ModifiedSleep3 {

	public static void main(String[] args) {
		
		ArrayList<Double> HPlusVals = new ArrayList<>();
		ArrayList<Double> HMinusVals = new ArrayList<>();
		ArrayList<Double> HVals = new ArrayList<>();
		ArrayList<Double> SVals = new ArrayList<>();
		
		
		double t = 0;
		int tF = 120;
		double amplitude = 0.1, alpha= 0, T = 24, xS = 4.2, xW = 18.2, hPlus = .6, hMinus = 0.17, hStart  = .26, s0 = 0.15, k = .7;
		
		HPlusVals.add(hPlus);
		HMinusVals.add(hMinus);
		HVals.add(hStart);
		SVals.add(s0);
		double coef = (2*Math.PI/T);
		
		boolean awake = true;
		
		for (int i = 0; i < tF*10; i ++)
		{
			double C = amplitude * Math.sin(coef * (t - alpha));
			double hP = HPlusVals.get(0) + C; 
			HPlusVals.add(hP);
			
			double hM = HMinusVals.get(0) + C; 
			HMinusVals.add(hM);
			
			
			t = t + .1;
			double h = HVals.get(i); 
			
			if (awake)
			{
				h += ((1-SVals.get(i))*(1 - HVals.get(i))/xW) * .1;
				HVals.add(h);
			}
			else
			{
				h -= (HVals.get(i))/xS *.1;
				HVals.add(h);
			}
			
			double ratio = (h - hM)/(hP - hM);
			double Htemp = 2 *ratio -1;
			double fH = Math.pow(Htemp, 5);
			
			
			double s = SVals.get(i); 
			
			s += 0.1*(k * fH * SVals.get(i)*(1-SVals.get(i)));
			
			SVals.add(s);

			
			if (1 - SVals.get(i) <= 0.01)
			{
				awake = false;
			}
			else if (SVals.get(i) <= 0.01)
			{
				awake = true;
			}
			

		}
		sleep.printVals(HPlusVals, HMinusVals, HVals);
		
		
		System.out.println("\n\nS\n\n");
		for (int i = 0; i < SVals.size(); i ++ )
		{
			
			System.out.format("%.4f\n", SVals.get(i));
		}
	}

}
