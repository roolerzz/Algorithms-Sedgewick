public class ClientProgram {

	public static void main(String[] args){
		QuickFindUF obj = new QuickFindUF(10);
		obj.printArray();
		obj.union(4,3);
		obj.union(3,8);
		obj.union(6,5);
		obj.union(9,4);
		obj.union(2,1);
		System.out.println(obj.find(8,9));
		System.out.println(obj.find(5,0));
		obj.union(5,0);
		obj.union(6,1);
		System.out.println(obj.find(5,0));
	}
}