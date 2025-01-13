# Perguntas e Respostas sobre Strings em Java

1. **O que significa dizer que as Strings em Java são imutáveis? Dê um exemplo.**  
R: Quer dizer que uma vez criadas, seu valor não pode ser alterado. Qualquer operação que pareça modificar uma string cria uma nova instância da String.

2. **Qual a diferença entre criar uma String com literais e com o operador `new`?**  
R: As Literais são criadas automaticamente no pool de de strings, já com o operador ‘new’, é alocado memória separada.

3. **Explique o que é o pool de strings e como ele otimiza o uso de memória.**  
R: O pool de strings é uma área da memória onde as strings literais são armazenadas. Quando uma string é criada com literais, Java verifica se já existe uma string com o mesmo valor no pool. Se existir, a referência a essa string é reutilizada, economizando memória.

4. **Dada a string `String s = "Hello";`, qual o resultado de `s.charAt(1)`?**  
R: O caractere na posição 1 é ‘e’.

5. **Escreva um código que demonstre a diferença entre `equals()` e `==` para comparação de strings.**  
R: Equals é utilizado quando se tem objeto.

```java
String s1 = "Java";
String s2 = new String("Java");

System.out.println(s1.equals(s2)); // true (compara conteúdo)
System.out.println(s1 == s2);          // false (compara referências de memória)
```

6. **Qual é o propósito do método `trim()`? Dê um exemplo prático.**  
R: Remove os espaços em branco.

7. **O que é retornado pelo método `split()`? Como ele pode ser usado para dividir uma frase em palavras?**  
R: Divide a string em um array de substrings, com base no delimitador fornecido.

```java
String frase = "Java é incrível";
String[] palavras = frase.split(" ");
System.out.println(Arrays.toString(palavras)); // Saída: [Java, é, incrível]
```

8. **Qual a principal diferença entre as classes `StringBuilder` e `StringBuffer`?**  
R: A principal diferença é que a StringBuffer é thread-safe, ou seja, suas operações são seguras para múltiplas threads, enquanto StringBuilder não é thread-safe, mas é mais rápido.

9. **Como você concatenaria duas strings sem usar o operador `+`?**  
```java
String s1 = "Olá, ";
String s2 = "Mundo!";
String resultado = s1.concat(s2);  // Usando concat
System.out.println(resultado);  // "Olá, Mundo!"
```

10. **Explique o conceito de thread safety em relação a `StringBuffer` e por que `StringBuilder` não é thread-safe.**  
R: O conceito de thread safety significa que o objeto pode ser manipulado de forma segura em um ambiente multithread, ou seja, sem causar problemas de concorrência. StringBuffer é projetado para ser seguro em múltiplas threads, usando sincronização em suas operações. StringBuilder, por outro lado, não é sincronizado e, portanto, não é seguro em um ambiente multithread.
