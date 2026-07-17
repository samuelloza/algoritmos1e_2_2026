---
marp: true
theme: default
paginate: true
size: 16:9
math: mathjax
---

# Semana 2
# Complejidad algorítmica

---

## ¿Para qué sirve la complejidad?

Sirve para:

- Saber si una solución va a escalar
- Comparar dos soluciones antes de programarlas.
- Evitar soluciones que funcionan con ejemplos pequeños, pero mueren en el juez.

La complejidad existe para no programar a ciegas.

---

![](https://hedgedoc.aquicasual.me/uploads/5830ad44-f09d-41c0-909f-6c93159ba827.png)

---

![](https://hedgedoc.aquicasual.me/uploads/b584f0c9-686f-41bf-8e54-fb8ac108c34a.png)

---

Tengo dos soluciones para el mismo problema:

```text
Solución A: revisa el arreglo una vez.
Solución B: compara cada elemento con todos los demás.
```
---

¿Cuál soporta una entrada más grande?
Opción 1: Revisa el arreglo una vez    
Opción 2: Compara cada elemento con todos los demás

---

## Respuesta

La solución A probablemente es `O(n)`.

La solución B probablemente es `O(n²)`.

Con pocos datos, ambas pueden funcionar.

Con muchos datos, una solución `O(n²)` puede superar el límite de tiempo.

---

## Idea

No medimos solo cuánto tarda un programa una vez.

Medimos cómo crece su trabajo cuando crece la entrada.

---


## Operaciones elementales

Una operación elemental es un costo constante.

Ejemplos:

- Asignar una variable.
- Sumar, restar, multiplicar.
- Comparar.
- Acceder a `a[i]`.
- Imprimir o leer un dato simple.
- Retornar un valor.

---

## Primer ejemplo

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
    }
}
```

¿Cuántas operaciones principales hay?

---

## Respuesta

<details>
<summary>Ver respuesta</summary>

Hay 8 impresiones.

El número de impresiones no depende de `n`.

```text
T(n) = 8
O(1)
```

</details>

---

## O(1): constante

```java
int primero = a[0];
```

Da igual si el arreglo tiene:

```text
10 elementos
1000 elementos
1000000 elementos
10⁹ elementos
```

Acceder a una posición directa es constante.

---

## O(n): lineal

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Si `n = 10`, imprime 10 veces.

Si `n = 1000`, imprime 1000 veces.

Complejidad:

```text
O(n)
```

---
## Cálculo usando ifs
![](https://hedgedoc.aquicasual.me/uploads/4da316d2-1378-4f16-b3c1-6ff16efd2c19.png)

## Cálculo de operaciones en ciclos

![](https://hedgedoc.aquicasual.me/uploads/5dc042eb-a2a1-4aa8-bb58-c614d4bc303f.png)

---


Aunque el conteo exacto sea algo como:

```text
T(n) = 4n + 2
```

Para Big O queda:

```text
O(n)
```

Porque ignoramos constantes.


---

## O(n²): ciclos anidados

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

El externo entra `n` veces.

Por cada vuelta del externo, el interno entra `n` veces.

```text
n × n = n²
```

---

¿Cuántas veces se ejecuta `procesar()`?

```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 4; j++) {
        procesar();
    }
}
```

---

## Respuesta


<details>
<summary>Ver respuesta</summary>


```text
3 × 4 = 12 veces
```

Como 3 y 4 son constantes:

```text
O(1)
```

No todo doble ciclo es `O(n²)`.

</details>

---

## Doble ciclo con n

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        procesar();
    }
}
```

Aquí sí:

```text
n × n = n²
```

Complejidad:

```text
O(n²)
```

---

## Dos ciclos separados

```java
for (int i = 0; i < n; i++) {
    procesar();
}

for (int j = 0; j < n; j++) {
    procesar();
}
```

No están anidados.

```text
n + n = 2n
O(n)
```

---

---

## while con incremento normal

```java
int i = 1;

while (i <= n) {
    procesar();
    i = i + 1;
}
```

`i` avanza de uno en uno.

Complejidad:

```text
O(n)
```

---

## while con salto de 3

```java
int i = 1;

while (i < n) {
    procesar();
    i = i + 3;
}
```

¿Cuántas vueltas aproximadamente?

```text
n / 3
```

Complejidad:

```text
O(n)
```

La constante 3 desaparece.

---


## Problemas

- A: Codeforces 71A - Way Too Long Words
- B: UVA 750 - 8 Queens Chess Problem
- C: Codeforces 263A - Beautiful Matrix
- D: Codeforces 520A - Pangram
- E: UVA 10443 - Rock, Scissors, Paper
- F: UVA 167 - The Sultan's Successors
- G: UVA 624 - CD

