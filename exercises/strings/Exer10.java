class Exer10{
	public static void main(String[] args){
		long startTime = System.nanoTime();
		String str = "";
		for(int i = 0; i < 10_000; i++){
			str += "a";
		}
		long endTime = System.nanoTime();
		System.out.println("Tempo String: " + (endTime - startTime));

		startTime = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10_000; i++){
			sb.append("a");
		}
		endTime = System.nanoTime();
		System.out.println("Tempo StringBuilder: " + (endTime = startTime));

}}
