import java.util.Scanner;

public class Advanced2 {

    public static boolean validaCpf(String cpf){
        int soma = 0, mod = 0, digitoVerificador1 = 0, digitoVerificador2 = 0, j = 10;;

        retiraPontoTraco(cpf);
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("\\-", "");

        // Valida 11 digitos
//        if (cpf.length() != 11 ){
//            return false;
//        }

        // Calculo do primeiro digito verificador
        for (int i = 0; i < cpf.length()-2; i++){
            char c= cpf.charAt(i);
            int somaPorDigito = Character.getNumericValue(c) * j;
            soma += somaPorDigito;
            j--;
        }

        mod = soma % 11 ;
        if (mod < 2 ){
            digitoVerificador1 = 0;
        } else {
            digitoVerificador1 = 11 - mod;
        }

        System.out.println("Digito Verificador valor: "+ digitoVerificador1);



        // Calculo do segundo digito verificador
        return false;
    }

    private static void retiraPontoTraco(String cpf) {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite CPF para validação: ");
        String cpf = scan.nextLine();
        System.out.println(validaCpf(cpf));

    }


}


