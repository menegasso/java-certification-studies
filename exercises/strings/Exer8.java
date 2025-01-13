class Exer8{
	public static void main(String[] args){
		String s1 = new String("Java"); // Cria uma string no heap
		String s2 = s1.intern();        // Aponta para a string "Java" no pool
		String s3 = "Java";		// Literal, ja esta no pool
		
		// Comporacoes
		System.out.println(s1 == s2); 	// false: s1 esta no heap, s2 no pool
		System.out.println(s2 == s3);   // true: ambos apontam para o pool
}
}
