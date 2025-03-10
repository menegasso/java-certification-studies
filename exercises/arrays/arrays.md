✅ O que são Arrays?

Um array é uma estrutura de dados que armazena elementos do mesmo tipo em uma sequência ordenada. Em Java, os arrays são objetos e possuem um tamanho fixo após serem criados.

🔹 Declaração e Inicialização

Em Java, podemos declarar e inicializar um array de várias formas:

```java
// Declaração e alocação de espaço
int[] numeros = new int[5]; // Um array de inteiros com 5 posições

// Inicialização direta
int[] valores = {10, 20, 30, 40, 50}; // Um array com valores predefinidos

// Criando um array de Strings
String[] nomes = new String[]{"Alice", "Bob", "Carlos"};

```

🔹 Acessando e Modificando Elementos

Os elementos do array são acessados por índices, que começam em 0:

```java
int primeiroNumero = valores[0]; // Acessando o primeiro elemento (10)
valores[2] = 100; // Modificando o terceiro elemento (de 30 para 100)
```

🔹 Percorrendo Arrays
1️⃣ Usando for

```java
for (int i = 0; i < valores.length; i++) {
    System.out.println("Elemento " + i + ": " + valores[i]);
}
```

2️⃣ Usando for-each

```java
for (int valor : valores) {
    System.out.println(valor);
}
```

🏗️ Arrays Multidimensionais

Os arrays multidimensionais são usados para armazenar tabelas de dados:

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Acessando um elemento
int elemento = matriz[1][2]; // Valor 6
```

Para percorrer uma matriz:

```java
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

🚀 Aplicação de Arrays com POO

Agora, vamos aplicar arrays dentro de uma classe orientada a objetos.

🏷️ Exemplo: Classe Turma armazenando alunos em um Array

```java
class Aluno {
    String nome;
    int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibir() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Turma {
    Aluno[] alunos;
    int totalAlunos;

    public Turma(int capacidade) {
        this.alunos = new Aluno[capacidade];
        this.totalAlunos = 0;
    }

    public void adicionarAluno(Aluno aluno) {
        if (totalAlunos < alunos.length) {
            alunos[totalAlunos] = aluno;
            totalAlunos++;
        } else {
            System.out.println("Turma cheia!");
        }
    }

    public void listarAlunos() {
        for (int i = 0; i < totalAlunos; i++) {
            alunos[i].exibir();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Turma turma = new Turma(3);

        turma.adicionarAluno(new Aluno("Alice", 20));
        turma.adicionarAluno(new Aluno("Bob", 22));
        turma.adicionarAluno(new Aluno("Carlos", 21));

        turma.listarAlunos();
    }
}

```

🏛️ Design Patterns Aplicáveis a Arrays

Podemos usar alguns padrões de projeto (Design Patterns) para trabalhar com arrays de forma eficiente.

🔹 1. Singleton - Criar uma estrutura global para gerenciar dados em um array.

```java
class GerenciadorAlunos {
    private static GerenciadorAlunos instancia;
    private Aluno[] alunos;
    private int indice;

    private GerenciadorAlunos(int capacidade) {
        alunos = new Aluno[capacidade];
        indice = 0;
    }

    public static GerenciadorAlunos getInstance(int capacidade) {
        if (instancia == null) {
            instancia = new GerenciadorAlunos(capacidade);
        }
        return instancia;
    }

    public void adicionarAluno(Aluno aluno) {
        if (indice < alunos.length) {
            alunos[indice] = aluno;
            indice++;
        }
    }

    public void listarAlunos() {
        for (int i = 0; i < indice; i++) {
            alunos[i].exibir();
        }
    }
}

// Uso do Singleton
public class Main {
    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = GerenciadorAlunos.getInstance(5);

        gerenciador.adicionarAluno(new Aluno("Lucas", 25));
        gerenciador.adicionarAluno(new Aluno("Mariana", 23));

        gerenciador.listarAlunos();
    }
}

```

🔹 2. Iterator - Criar um mecanismo de navegação sobre arrays.


```java
import java.util.Iterator;

class AlunoIterator implements Iterator<Aluno> {
    private Aluno[] alunos;
    private int posicao = 0;

    public AlunoIterator(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public boolean hasNext() {
        return posicao < alunos.length && alunos[posicao] != null;
    }

    public Aluno next() {
        return alunos[posicao++];
    }
}

```
