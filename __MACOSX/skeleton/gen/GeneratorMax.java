
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;

public class GeneratorMax {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter("006-max.in", "UTF-8");
		int cases = 5;
		writer.println(cases);
		for(int i = 0; i < cases; i++){
			int n = 100000;
			int m = 100000;
			writer.println(n + " " + m);
			HashSet<Pair> hm = new HashSet<Pair>();
			for(int j = 0; j < m; j++)
			{
				
				int i2 = (int)(Math.random()*n +1);
				int j2 = (int)(Math.random()*n +1);
				Pair p1= new Pair(i2,j2);
				Pair p2 = new Pair(j2, i2);
				while(true){
					p1 = new Pair(i2,j2);
					p2 = new Pair(j2, i2);
					if(i2 != j2){
						if(!hm.contains(p1) && !hm.contains(p2))
						{
							break;
						}
					}
					i2 = (int)(Math.random()*n +1);
					j2 = (int)(Math.random()*n +1);
				}
				hm.add(p1);
				hm.add(p2);
				writer.println(i2 + " " + j2);
			}
		}
		writer.close();
	}
}
class Pair
{
	int a, b;
	Pair(int a1,int b1)
	{
		a = a1; 
		b = b1;
	}
}