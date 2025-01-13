# Conceitos de String em Java

### 1. **Definição de String**
Uma **`String`** em Java é uma sequência de caracteres, representada pela classe **`String`** no pacote padrão `java.lang`. Strings são imutáveis, ou seja, uma vez criadas, seu valor não pode ser alterado.

```java
String texto = "Olá, Mundo!";
```

---

### 2. **Criação de Strings**
Você pode criar uma String de duas maneiras principais:

- **Literal de String**: Criada automaticamente no pool de strings.
  ```java
  String s1 = "Exemplo";
  ```
- **Objeto String**: Criado explicitamente usando o operador `new`, alocando memória separada.
  ```java
  String s2 = new String("Exemplo");
  ```

---

### 3. **Imutabilidade**
Strings em Java são **imutáveis**. Isso significa que operações que modificam uma string retornam uma nova instância ao invés de alterar o conteúdo original.

```java
String s = "Java";
s = s + " é incrível!"; // Cria uma nova String
```

---

### 4. **Principais Métodos da Classe String**
A classe `String` oferece vários métodos úteis:

| Método                        | Descrição                                                | Exemplo                                             |
|-------------------------------|--------------------------------------------------------|-----------------------------------------------------|
| `length()`                    | Retorna o comprimento da string                        | `"Java".length(); // Retorna 4`                     |
| `charAt(int index)`           | Retorna o caractere na posição especificada            | `"Java".charAt(1); // Retorna 'a'`                  |
| `substring(int start, int end)`| Retorna uma parte da string                            | `"Java".substring(1, 3); // Retorna 'av'`           |
| `equals(String s)`            | Compara se duas strings são iguais                    | `"Java".equals("java"); // Retorna false`           |
| `equalsIgnoreCase(String s)`  | Compara ignorando maiúsculas e minúsculas              | `"Java".equalsIgnoreCase("java"); // Retorna true`  |
| `toUpperCase()`               | Converte todos os caracteres para maiúsculo           | `"java".toUpperCase(); // Retorna 'JAVA'`           |
| `toLowerCase()`               | Converte todos os caracteres para minúsculo           | `"JAVA".toLowerCase(); // Retorna 'java'`           |
| `replace(char, char)`         | Substitui caracteres ou strings                       | `"Java".replace('a', 'o'); // Retorna 'Jovo'`       |
| `trim()`                      | Remove espaços em branco no início e no final         | `" Java ".trim(); // Retorna 'Java'`                |
| `split(String regex)`         | Divide a string em um array baseado em um delimitador | `"a,b,c".split(","); // Retorna ['a', 'b', 'c']`    |
| `contains(CharSequence s)`    | Verifica se contém uma sequência de caracteres         | `"Java".contains("av"); // Retorna true`            |
| `indexOf(String s)`           | Retorna o índice da primeira ocorrência               | `"Java".indexOf('a'); // Retorna 1`                 |

---

### 5. **Concatenação**
Strings podem ser concatenadas utilizando o operador `+` ou o método `concat()`.

```java
String s1 = "Olá, ";
String s2 = "Mundo!";
String resultado = s1 + s2; // "Olá, Mundo!"
String resultado2 = s1.concat(s2); // "Olá, Mundo!"
```

---

### 6. **Comparação de Strings**
Ao comparar strings, use:

- **`equals()`** para comparação de conteúdo.
- **`==`** para verificar se referem ao mesmo objeto na memória.

```java
String s1 = "Java";
String s2 = new String("Java");

System.out.println(s1.equals(s2)); // true (conteúdo é igual)
System.out.println(s1 == s2); // false (objetos diferentes)
```

---

### 7. **Classe `StringBuilder` e `StringBuffer`**
Para manipulações frequentes e eficientes de strings (mutáveis):

- **`StringBuilder`**: Não é thread-safe, mas é mais rápido.
- **`StringBuffer`**: Thread-safe, mas mais lento.

```java
StringBuilder sb = new StringBuilder("Olá");
sb.append(", Mundo!");
System.out.println(sb.toString()); // "Olá, Mundo!"
```

---

### 10 Questões para Prática

1. O que significa dizer que as Strings em Java são imutáveis? Dê um exemplo.
2. Qual a diferença entre criar uma String com literais e com o operador `new`?
3. Explique o que é o **pool de strings** e como ele otimiza o uso de memória.
4. Dada a string `String s = "Hello";`, qual o resultado de `s.charAt(1)`?
5. Escreva um código que demonstre a diferença entre `equals()` e `==` para comparação de strings.
6. Qual é o propósito do método `trim()`? Dê um exemplo prático.
7. O que é retornado pelo método `split()`? Como ele pode ser usado para dividir uma frase em palavras?
8. Qual a principal diferença entre as classes `StringBuilder` e `StringBuffer`?
9. Como você concatenaria duas strings sem usar o operador `+`?
10. Explique o conceito de thread safety em relação a `StringBuffer` e por que `StringBuilder` não é thread-safe.

---

### Mais 10 Questões Práticas

1. Como o método `replace()` pode ser usado para substituir todas as ocorrências de uma letra em uma string? Dê um exemplo.
2. Dada a string `String s = "Java";`, qual o resultado de `s.toUpperCase()`?
3. Escreva um código que use o método `contains()` para verificar se uma palavra está contida em uma frase.
4. Dada a string `String s = " a,b,c ";`, qual o resultado de aplicar `s.trim().split(",");`?
5. Qual a diferença entre `substring(int start)` e `substring(int start, int end)`? Exemplifique.
6. Como você verificaria se uma string está vazia ou contém apenas espaços em branco?
7. Escreva um código que demonstre o uso de `indexOf()` e `lastIndexOf()` em uma string.
8. Explique como o método `intern()` funciona em Java. Dê um exemplo de sua aplicação.
9. Como você poderia reverter uma string usando a classe `StringBuilder`?
10. Escreva um código que demonstre a diferença de desempenho entre `String` e `StringBuilder` ao concatenar múltiplas strings em um loop.
