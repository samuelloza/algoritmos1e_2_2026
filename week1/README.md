## Introducción al Juez Virtual y Primeros Envíos

### Materiales y recursos necesarios

Para las clases necesitamos lo siguiente:

1. Una cuenta en **VJudge**.
2. Una cuenta en **Codeforces**.
3. Un editor de código o IDE para programar en Java.

Puedes usar cualquiera de estas opciones:

* Visual Studio Code
* Eclipse
* IntelliJ IDEA
* NetBeans
* Vim
* Otro editor que ya tengas configurado

### Opcional
Herramienta para entender como funcionan algunos algoritmos
https://play.google.com/store/apps/details?id=wiki.algorithm.algorithms&hl=es_DO

---

### ¿Qué veremos en esta clase?

En esta clase aprenderemos a usar un juez virtual para enviar soluciones de programación y entender cómo se evalúa el código.

Veremos los siguientes temas:

1. Qué es un juez virtual.
2. Cómo funciona un juez virtual.
3. Qué son la entrada estándar y la salida estándar.
4. Cómo leer un problema de programación competitiva.
5. Cómo identificar los datos de entrada.
6. Cómo identificar la salida esperada.
7. Cómo escribir una solución simple.
8. Cómo enviar código a la plataforma.
9. Cómo interpretar los veredictos del juez.

---
Recursividad
---

# ¿Qué es la recursividad?

Una función que se llama a sí misma para resolver un problema más pequeño del mismo tipo.

```
Problema grande
      ↓
Problema más pequeño
      ↓
Problema aún más pequeño
      ↓
Caso base
```

---

# ¿Cuándo usar recursividad?

Cuando un problema puede dividirse en subproblemas iguales.

Ejemplos:

- Factorial
- Suma
- Potencia
- Arreglos
- Strings
- Árboles
- Grafos

---

# Toda función recursiva tiene dos partes

## Caso base

Detiene la recursión.

```cpp
if (...) return;
```

## Caso recursivo

Reduce el problema.

```cpp
return f(...);
```

---

# Primer ejemplo

Imprimir

```
5
4
3
2
1
```

```cpp
void imprimir(int n){

    if(n==0)
        return;

    cout<<n<<endl;

    imprimir(n-1);
}
```


---

# La pila de llamadas

```
┌──────────────┐
│ imprimir(0)  │
├──────────────┤
│ imprimir(1)  │
├──────────────┤
│ imprimir(2)  │
├──────────────┤
│ imprimir(3)  │
└──────────────┘
```

---

# Imprimir al regresar

```cpp
void imprimir(int n){

    if(n==0)
        return;

    imprimir(n-1);

    cout<<n<<endl;
}
```

Salida

```
1
2
3
```

---

# Factorial

```
5!

=

5×4×3×2×1
```

```cpp
int factorial(int n){

    if(n==1)
        return 1;

    return n*factorial(n-1);
}
```

---

# Potencia

```cpp
int potencia(int a,int n){

    if(n==0)
        return 1;

    return a * potencia(a,n-1);
}
```

---

# Contar dígitos

```cpp
int contar(int n){

    if(n<10)
        return 1;

    return 1+contar(n/10);
}
```

---

# Suma de dígitos

```cpp
int sumaDigitos(int n){

    if(n==0)
        return 0;

    return (n%10)+sumaDigitos(n/10);
}
```

---

# Recursión sobre arreglos

Ejemplo

```
3 8 2 5
```

Suma

```cpp
return a[i] + sum(a,i+1);
```

---

# Máximo

```cpp
return max(
    a[i],
    maximo(a,i+1)
);
```

---

# Buscar

```cpp
if(a[i]==x)
    return true;

return buscar(...);
```

---

# Contar pares

```cpp
return
(a[i]%2==0)
+
contarPares(...);
```

---

# Recursión sobre strings

- Contar vocales
- Contar letras
- Invertir string
- Palíndromo

---



