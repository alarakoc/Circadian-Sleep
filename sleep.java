import java.util.ArrayList;
public class sleep {
	public static void main(String[] args) {
		
		ArrayList<Double> HPlusVals = new ArrayList<>();
		ArrayList<Double> HMinusVals = new ArrayList<>();
		ArrayList<Double> HVals = new ArrayList<>();
		
		double t = 0;
		int tF = 76;
		double amplitude = 0.09, alpha= 0, T = 24, xS = 4.2, xW = 18.2, hPlus = .6, hMinus = 0.19, hStart  = .5;
		
		HPlusVals.add(hPlus);
		HMinusVals.add(hMinus);
		HVals.add(hStart);
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
		printVals(HPlusVals, HMinusVals, HVals);
	}
	


	
	public static void printVals(ArrayList<Double> a, ArrayList<Double> b, ArrayList<Double> c)
	{
				System.out.println("H+\n\n");
		for (int i = 0; i < a.size(); i ++ )
		{
			System.out.format("%.4f\n", a.get(i));
		}

		System.out.println("\n\nH-\n\n");
		for (int i = 0; i < b.size(); i ++ )
		{
			System.out.format("%.4f\n", b.get(i));
		}
		
		System.out.println("\n\nH\n\n");
		for (int i = 0; i < c.size(); i ++ )
		{
		
			System.out.format("%.4f\n", c.get(i));
		}
	}
}
