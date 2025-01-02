# Understanding the Java Class Structure

## Fields and Methods

Em java, as classes são blocos básicos de construção. Para usar uma classe, cria-se um objeto, que é uma instância dela em memória. Esses objetos representam o estado do programa.

Classes em Java têm dois elementos principais: métodos (ou funções) e campos (ou variáveis). Juntos, são chamados de membros da classe. As variáveis armazenam o estado do programa, e os métodos operam sobre esse estado.

## Comments

Comentários são partes do código que não são executadas, servindo para tornar o código mais legível. Existem três tipos de comentários em Java:

Comentário de linha única: Começa com // e ignora tudo após isso na mesma linha.

Comentário de múltiplas linhas: Começa com /* e termina com */. Pode se estender por várias linhas.

Comentário Javadoc: Começa com /** e é usado para documentar código. **É lido pela ferramenta Javadoc para gerar documentação automática.**

Além disso, é importante praticar a identificação de comentários em diferentes contextos, como no caso de um comentário de linha dentro de um comentário de múltiplas linhas, que pode causar confusão se não for analisado com cuidado.

## Classes vs. Files
Na maioria das vezes, cada classe Java é definida em seu próprio arquivo .java. Geralmente, a classe é public, o que significa que qualquer código pode acessá-la. Curiosamente, o Java não exige que a classe seja public. Por exemplo, esta classe funciona normalmente:

```java
class Animal {
    String name;
}
```
Você também pode colocar duas classes no mesmo arquivo. Nesse caso, no máximo uma das classes pode ser public. Isso significa que o seguinte exemplo também está correto:

```java
public class Animal {
    private String name;
}
class Animal2 {
}
```

Se você tiver uma classe public, o nome dela deve corresponder ao nome do arquivo. Por exemplo, uma classe public class Animal2 não será compilada se o arquivo não tiver o nome correspondente.

## Writing a main() Method 

Um programa Java começa pelo método main(), que conecta a JVM ao código do programador. O exemplo básico é:

```java
public class Zoo {
    public static void main(String[] args) {
    }
}
```

Regras básicas:
O arquivo deve ter extensão .java e o nome igual ao da classe (sensível a maiúsculas).

A compilação gera um arquivo .class (bytecode), executado pela JVM.

O método main() é obrigatório para iniciar a execução.

## Understanding Package Declarations and Imports

1. Pacotes (Packages)
    * Agrupam classes de forma hierárquica, como pastas.
    * Exemplo: java.util contém várias classes utilitárias.

2. Import (Import)
    * Indica ao compilador onde encontrar essas classes.
    * Exemplo: `import java.util.Random;`.

3. Hierarquia
    * Pacotem começam com `java` ou `javax` são do JDK. Outros seguem a convenção de domínio invertido (ex.: com.amazon).

### Wildcards

1. Wildcard(*):
    * Importa todas as classes de um pacote.
    * Exemplo: `import.java.util.*`

2. Limitações:
    * Não importa: subpacotes, campos ou métodos.

3. Impacto no Desempenho:
    * Não afeta a performance; o compilador só usa o que é necessário.

4. Boas práticas:
    * Listas classes específicas: Torna o código mais legível.
    * Usar wildcard: Reduz o número de linhas para pacotes amplamente usados.

### Redundant Imports

1. Pacote especial `java.lang`:
    * Classe no pacote `java.lang` são automaticamente importadas.
    * Exemplo: `system`e `String` não precisam de import.

2. Exemplo de importações redundantes:
    ```java
    import java.lang.System; // Redundante
    import java.lang.*;      // Redundante
    import java.util.*;      // Redundante (se java.util.Random já foi importado)
    import java.util.Random;
    ```

3. Regra para o Mesmo Pacote:
    * Classes no mesmo pacote são automaticamente visíveis; não precisam de import.

4. Wildcard (*) nos imports:
    * Importa todas as classes de um pacote, mas não subpacotes. Exemplo válido: `import java.nio.file.*;`
    * Exemplos inválidos:
        ```java
        import java.nio.*;       // Não importa subpacotes como file.*
        import java.nio.*.*;     // Não é permitido mais de um wildcard
        import java.nio.file.Paths.*; // Não é possível importar métodos
        ```

5. Recomendações:
    * Evite importações redundantes para manter o código limpo.
    * Use wildcards apenas quando necessário para múltiplas classes de um mesmo pacote.

### Naming Conflicts

1. Motivo para Pacotes:
    * Permitem que classes com o mesmo nome existam em diferentes pacotes.
    * Exemplo: java.util.Date e java.sql.Date.

2. Conflito com Imports Wildcards:
    * Importar java.util.* e java.sql.* ao mesmo tempo gera erro quando há classes com o mesmo nome: `The tpe Date is ambiguous`

3. Solução para Conflitos:
    * Importar Especificamente a Classe Desejada:
    ```java
    import java.util.Date;
    import java.sql.*;
    ```
    Aqui, `java.util.Date` tem prioridade sobre o wildcard de `java.sql`.

    * Usar Nome Completo (FQN - Fully Qualified Name):Se precisar de ambas as classes:
    ```java
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
    ```
4. Importação Explícita com Conflitos:
    * Importar duas classes explicitamente com o mesmo nome gera erro:
    ```java
    import java.util.Date;
    import java.sql.Date; // Erro: colisão de imports
    ```

**Para resolver conflitos, use importações específicas ou o nome completo da classe no código. Isso garante clareza e evita ambiguidades no compilador.**

**Nomear pacotes e entender como compilar/executar no terminal ajuda a organizar o código e facilita a reutilização em projetos maiores.**

### Code Formatting on the Exam

1. Omissão de Imports
    * Se a questão não se trata sobre imports, eles podem ser omitidos para economizar espaço.
    * Quando o código começa com um número diferente de 1, assume-se que os imports e o restante do código ausente estão corretos.

2. Linha 1 ou Sem Números de Linha:
    * Quando o código começa na linha 1 ou não tem números de linha, verifique se os imports necessários estão presentes. Exemplo:
    ```java
    1: public class LineNumbers {
    2: public void method(ArrayList list) {
    3: if (list.isEmpty()) { System.out.println("e");
    4: } else { System.out.println("n");
    5: } } }
    ```
    **Não compila, pois ArrayList precisa ser importado de java.util.**

3. Código Compactado:
    * O exame pode apresentar código em uma única linha para economizar espaço:
    ```java
    6: public void method(ArrayList list) {
    7: if (list.isEmpty()) { System.out.println("e");
    8: } else { System.out.println("n"); } }
    ```

4. Ausência do main() Method:
    * Caso o código apresentado não contenha um método main(), assuma que ele e o restante do código necessário estão corretos.
    * A questão verifica apenas se o trecho mostrado compila quando inserido em um contexto válido.

    **Dica: Sempre preste atenção nas numerações de linha e leia as instruções da questão para identificar o contexto correto.**


## Creating Objects
Nossos programas não seriam capazes de fazer nada útil se não tivéssemos a capacidade de criar novos objetos. Lembre-se de que um objeto é uma instância de uma classe.

### Constructors
1. Criação de Objetos e Construtores
    * Um objeto é uma instância de uma classe, criado com o operador new.
    * O construtor é um método especial que inicializa objetos. Ele:
        * Tem o mesmo nome da classe.
        * Nâo tem tipo de retorno.
        * Exemplo:
        ```java
        public class Chick {
            public Chick() {
                System.out.println("in constructor");
            }
        }
        ```
        * Um método com nome de classe e com tipo de retorno não é um construtor:
        ```java
         public void Chick() { } // Método comum, não um construtor.
         ```
        * Se nenhum construtor for declarado, o compilador cria um construtor padrão vazio.

### Reading and Writing Object Fields

1. Leitura e Escrita de Campos de Objetos
    * Você pode acessar (ler) e modificar (escrever) diretamente as variáveis de instância de um objeto.
    ```java
    public class Swan {
        int numberEggs;

        public static void main(String[] args) {
            Swan mother = new Swan();
            mother.numberEggs = 1; // Escrevendo no campo.
            System.out.println(mother.numberEggs); // Lendo o campo.
        }
    }
    ```

### Instance Initializer Blocks
1. Blocos de inicialização de Instância
    * Em java, os blocos de código são qualquer trecho de código dentro de chaves {}. Quando dentro de um método, o código é executado quando o método é chamado. Fora de um métodos, são chamados blocos de inicialização de instância, executados antes do contrutor da classe. Exemplo:
    ```java
        public class Example {
            public static void main(String[] args) {
                { System.out.println("Feathers"); }  // Bloco de código no método
            }
            { System.out.println("Snowy"); }  // Bloco de inicialização de instância
        }
    ```
    * Blocos de código: Dentro ou fora de métodos.
    * Bloco de inicialização de instância: Fora de um método, executado antes do construtor.

### Order of Initialization
1. Ordem de Inicialização em Java
    * Campos e Blocos de Inicialização: São executados na ordem em que aparecem no código, de cima para baixo.
    * Construtor: É executado após todos os campos e blocos de inicialização. Exemplo:
    ```java
        public class Chick {
            private String name = "Fluffy"; // Campo inicializado com "Fluffy"
            
            { System.out.println("setting field"); } // Bloco de inicialização
            
            public Chick() {
                name = "Tiny"; // Construtor altera o valor de 'name' para "Tiny"
                System.out.println("setting constructor");
            }
            
            public static void main(String[] args) {
                Chick chick = new Chick(); // Criação do objeto
                System.out.println(chick.name); // Imprime o valor de 'name'
            }
        }
    ```
    * A ordem de execução deve ser seguida rigorosamente para evitar erros de inicialização.


## Distinguishing Between Object References and Primitives
Os aplicativos Java contêm dois tipos de dados: tipos primitivos e tipos de referência.

### Primitives Types
Java tem oito tipos de dados integrados, chamados de tipos primitivos Java. Esses oito tipos de dados representam os blocos de construção para objetos Java, porque todos objetos Java são apenas uma coleção complexa desses tipos de dados primitivos. 

1. Tipos Primitivos

| Keyword     | Type         | Example      |
|-------------|--------------|--------------|
|boolean |true or false |true|
|byte |8-bit integral value|123|
|short |16-bit integral value|123|
|int |32-bit integral value|123|
|long |64-bit integral value|123|
|float |32-bit floating-point value|123.45f|
|double |64-bit floating-point value|123.456|
|char |16-bit Unicode value|'a'|

2. Númericos Sem Pontos Decimais
    * byte, short, int e long reservam memória proporcional aos seus bits.
    * Exemplo: int usa 32 bits e seu valor máximo é 2.147.483.647

3. Literais Numéricos
    * Por padrão, literais numéricos são int. Para valores maiores, utiliza-se o sufixo L.
    * Exemplo: 9283379287L
    
3. Bases númericas suportadas (Decimal, binário, octal e hexadecimal)

4. Undersscores em Literais
    * Facilitam a leitura de números grandes
    * Restrições: não usuario no inicio, no fianl, antes ou depois de um ponto decimal.


### Reference Types

1. Tipos de Referência
    * TIpos de referência apotam para objetos (instâncias de classes) na memória.
    * Diferente de tipos primitivos, que armazenam diretamente seus valores, tipos de referência armazenam o endereço de memória onde o objeto está localizado.
    * O endereço de memória é abstrato em Java.
    * Referências podem ser usadas para acessar os métodos e atributos do objeto.
    * Declaração: `java.util.Date today`ou `String greeting`.
    * Inicialização: `today = new java.util.Date();`.
    * A variável de referência aponta para um objeto em memória.
    * O objeto não possui um nome diretamente; ele é acessado através da referência.


### Key Differences
1. Atribuição de NULL
    * Tipos de referência: Podem ser atribuídos a null, indicando que não apontam para nenhum objeto.
        * `String s = null; // COMPILA`
    * Tipos primitivos: Não podem ser atribuídos a null.
        * `int value = null; // NÃO COMPILA`

2. Métodos
    * Tipos de referência: Possuem métodos associados que podem ser chamados, desque não sejam atribuídos a null.
    ```java
        String reference = "hello";
        int len = reference.length(); // válido
    ```
    * Tipos primitivos: Não possuem métodos.
    ```java
        int len = 5;
        int bad = len.length(); // NÃO COMPILA
    ```

## Declaring and Initializing Variables

* Declaração de Variáveis:
    * Uma variável é um nome para um espaço na memória que armazena dados.
    * Ao declarar uma variável, é necessário especificar o tipo e o nome da variável.

* Inicialização de Variáveis:
    * Inicializar uma variável significa atribuir um valor a ela.

* Declaração de Variáveis em uma Linha:
    * `double d1, d2; // Válido`
    * `int i3; i4; // NÃO COMPILA`

### Identifiers

* Regras para Identificadores:
    * Primeiro caractere: Deve começar com uma letra (a–z, A–Z), ou os símbolos $ ou _.
    * Caracteres subsequentes: Podem ser letras, números, $ ou _.
    * Palavras reservadas: Não é permitido usar palavras reservadas (ex.: class, int, public) como identificadores.

    * Exemplos de identificadores legais:

        * okidentifier
        * $OK2Identifier
        * _alsoOK1d3ntifi3r
        * __SStillOkbutKnotsonice$

    * Exemplos de identificadores ilegais:
        * 3DPointClass (não pode começar com número)
        * hollywood@vine (símbolo @ não permitido)
        * *$coffee - símbolos * e $ são permitidos, mas a combinação com * é inválida
        * public (é uma palavra reservada)

































