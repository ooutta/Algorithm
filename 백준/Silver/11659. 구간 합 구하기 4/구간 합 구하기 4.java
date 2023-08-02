import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int [] list = new int[n];
		int [] sum = new int[m];
		
		String [] nList = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			if(i==0) 
				list[i] = Integer.parseInt(nList[i]);
			else
				list[i] = list[i-1] + Integer.parseInt(nList[i]);
		}
		
		for(int t=0;t<m;t++) {
			String [] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[0]);
			int j = Integer.parseInt(ij[1]);
			sum[t] = list[j-1] - list[i-1] + Integer.parseInt(nList[i-1]);
			bw.write(sum[t] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
