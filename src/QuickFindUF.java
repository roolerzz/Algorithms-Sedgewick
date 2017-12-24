public class QuickFindUF {

	// Solving the problem of Dynamic connectivity of N Objects. Objects are modeled as 
	// numbers from 0 to N-1, for each object, value in the array depicts its connection to other objects. 
	// Two Objects are connected if both have same value.

	public int[] id;

	QuickFindUF(int n){
		id = new int[n];
		for (int i=0; i<n;i++){
			id[i]=i;
		}
	}

	// Find if element p is connected to element q. O(1) Time complexity.
	public boolean find(int p, int q){
		return id[p]==id[q];
	}

	// make a connection from p to q.
	public void union(int p, int q){
	// Change the value of all the connected components from P to value at Q.
		int idP=id[p];				
		int idQ=id[q];
		int size = id.length;
		for(int i=0;i<size;i++){
			if(id[i]==idP){
				id[i]=idQ;
			}
		}
		printArray();
	}
	
	public void printArray(){
		System.out.println();
		int length = id.length;
		for(int i=0;i<length;i++){
			System.out.print(id[i] + ":");
		}
	}
}