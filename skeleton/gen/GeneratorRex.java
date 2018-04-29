import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class GeneratorMax {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter("test4.in", "UTF-8");
		int cases = 5;
		writer.println(cases);
		for(int i = 0; i < cases; i++){
			int n = 100000;
			int m = 100000;
			writer.println(n + " " + m);
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for(int j = 0; j < m; j++)
			{
				
				int i2 = (int)(Math.random()*n +1);
				int j2 = (int)(Math.random()*n +1);
				while(hm.get(i2) != null && hm.get(j2)!= null){
					if(hm.get(i2) != hm.get(j2))
					{
						break;
					}
					i2 = (int)(Math.random()*n +1);
					j2 = (int)(Math.random()*n +1);
				}
				hm.put(i2,j2);
				hm.put(j2, i2);
				writer.println(i2 + " " + j2);
			}
		}
		writer.close();
	}
}