// 1. Implemente um algoritmo para verificar se duas strings são anagramas uma da outra.

import java.util.Arrays;
import java.util.Scanner;

class Advanced1 {
    public static boolean saoAnagramas(String s1, String s2) {

        // Remove espaços e converte para letras minúsculas
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // Verifica se as strings têm o mesmo comprimento
        if (s1.length() != s2.length()){
            return false;
        }

        // Converte as strings para arrays de caracteres
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        // Ordena os arrays de caracteres
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Compara os arrays ordenados
        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite string 1:");
        String str1 = scanner.nextLine();

        System.out.println("Digite string 2:");
        String str2 = scanner.nextLine();

        System.out.println(saoAnagramas(str1, str2));
    }
}

