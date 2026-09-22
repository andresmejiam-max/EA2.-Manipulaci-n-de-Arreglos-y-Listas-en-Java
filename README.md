# EA2. Manipulación de Arreglos y Listas en Java - Pizza-Track

## Objetivo
Comprender el concepto de pila (Stack) y su estructura lógica, aplicándolo en un simulador de gestión de pedidos con Undo/Redo para una pizzería (Pizza-Track), implementado en Java.

## ¿Qué es una pila (Stack)?
Una pila es una estructura de datos lineal que sigue el principio **LIFO** (*Last In, First Out*): el último elemento que entra es el primero que sale. Solo se puede acceder al elemento que está en el **tope** de la pila, y las dos operaciones fundamentales son:

- **push**: agrega un elemento en el tope.
- **pop**: retira y devuelve el elemento del tope.

En este proyecto la pila se implementa **desde cero con una lista ligada de nodos** (clase [`Nodo.java`](Nodo.java)), sin usar `java.util.Stack`. El "tope" de la pila es simplemente un puntero al primer `Nodo` de la lista:

- `push()`: el nuevo nodo apunta (`siguiente`) al nodo que antes era el tope, y el puntero `tope` se mueve al nuevo nodo. Así el último en entrar queda encima de todos.
- `pop()`: se guarda el dato del nodo `tope`, y el puntero `tope` avanza a `tope.siguiente`. El nodo retirado deja de tener referencias y se descarta.
- `peek()`: devuelve el dato de `tope` sin moverlo.
- `isEmpty()`: verdadero si `tope == null`.

### Relación con Undo/Redo
El sistema usa **dos pilas**:

- **Pila Principal**: almacena los pedidos activos. Registrar un pedido es un `push()` aquí.
- **Pila Secundaria**: almacena temporalmente los pedidos deshechos.

`Deshacer (Undo)` hace `pop()` de la principal y `push()` a la secundaria (el pedido "sale" de los activos pero queda disponible para recuperarlo). `Rehacer (Redo)` hace lo inverso: `pop()` de la secundaria y `push()` a la principal.

## Estructura del proyecto
| Archivo | Responsabilidad |
|---|---|
| [`Pizza.java`](Pizza.java) | Modelo de datos: nombre y arreglo fijo de 3 ingredientes. |
| [`Nodo.java`](Nodo.java) | Nodo genérico de la lista ligada (dato + puntero al siguiente). |
| [`Pila.java`](Pila.java) | Pila manual (`push`, `pop`, `peek`, `isEmpty`) basada en `Nodo`. |
| [`GestionPedidos.java`](GestionPedidos.java) | Coordina la pila principal (Undo) y la secundaria (Redo). |
| [`Main.java`](Main.java) | Menú interactivo en consola. |

## Cómo ejecutar
Requiere JDK (Eclipse Temurin recomendado) y VS Code con la extensión de Java.

```bash
javac *.java
java Main
```

## Menú
```
1. Registrar Pizza   -> pide nombre y 3 ingredientes, y hace push() en la pila principal.
2. Deshacer (Undo)    -> pop() de la principal, push() a la secundaria.
3. Rehacer (Redo)     -> pop() de la secundaria, push() a la principal.
4. Mostrar Pedido Actual -> peek() de la principal.
0. Salir
```

## Ejemplo del ciclo Registro -> Deshacer -> Rehacer
```
1. Registrar Pizza -> Margarita (Queso, Tomate, Albahaca)
1. Registrar Pizza -> Hawaiana (Piña, Jamon, Queso)
4. Mostrar Pedido Actual -> Hawaiana (Piña, Jamon, Queso)
2. Deshacer -> se retira Hawaiana de la principal y pasa a la secundaria
4. Mostrar Pedido Actual -> Margarita (Queso, Tomate, Albahaca)
3. Rehacer -> Hawaiana vuelve de la secundaria a la principal
4. Mostrar Pedido Actual -> Hawaiana (Piña, Jamon, Queso)
```

## Capturas de pantalla de la consola
_(Pega aquí las capturas de pantalla de la ejecución del programa)_

## Video de sustentación
_(Pega aquí el link del video: YouTube, Drive o GitHub)_

## Autores
- [Nombre completo aquí]
