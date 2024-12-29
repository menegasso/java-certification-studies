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

### Imports Redundantes

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

** Para resolver conflitos, use importações específicas ou o nome completo da classe no código. Isso garante clareza e evita ambiguidades no compilador. **

** Nomear pacotes e entender como compilar/executar no terminal ajuda a organizar o código e facilita a reutilização em projetos maiores. **


















