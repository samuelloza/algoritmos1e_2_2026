---
marp: true
theme: default
paginate: true
size: 16:9
---

### Week 5
###### Algoritmos de búsqueda

En esta clase veremos:

- Búsqueda por fuerza bruta
- Búsqueda binaria

---

### ¿Qué significa buscar?

Encontrar un dato dentro de un conjunto de datos.

- Encontrar un número en un arreglo;
- Buscar un estudiante por su código;
- Encontrar un producto por su precio;
- Encontrar una distancia máxima posible.

---

#### Algunos algoritmos de búsqueda

<div style="font-size: 28px;">
    
| Algoritmo | Idea |
|---|---|
| Búsqueda lineal | Revisar uno por uno |
| Búsqueda binaria | Dividir el espacio de búsqueda |
| Hashing | Buscar usando una clave |
| DFS | Explorar un camino hasta el final |
| BFS | Explorar por niveles |
| A* | Buscar caminos usando una estimación |

En esta clase solo trabajaremos con los dos primeros.

</div>

---

### ¿Dónde se usan?

| Área | Ejemplo |
|---|---|
| Bases de datos | Encontrar registros |
| Redes sociales | Buscar perfiles y publicaciones |
| GPS | Encontrar rutas |
| Videojuegos | Buscar caminos o movimientos |
| Sistemas operativos | Buscar archivos y procesos |


---

### Búsqueda por fuerza bruta

También se conoce como búsqueda lineal.

La idea es simple:

```text
Revisar cada elemento hasta encontrar el valor.
```

Ejemplo:

```text
Arreglo: [7, 4, 9, 2]
Buscar: 9

7 -> no
4 -> no
9 -> encontrado
```

---

### Búsqueda lineal

```java
public static int linearSearch(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == target) {
            return i;
        }
    }
    return -1;
}
```

---

### Complejidad

| Caso | Qué ocurre | Complejidad |
|---|---|---:|
| Mejor caso | Está al inicio | `O(1)` |
| Peor caso | Está al final o no existe | `O(n)` |

La ventaja es que no necesita que el arreglo esté ordenado.

---

### ¿Por qué buscar de otra forma?

Supongamos que tenemos un millón de elementos.

Con búsqueda lineal podríamos hacer hasta:

```text
1 000 000 comparaciones
```

Con búsqueda binaria se necesitan aproximadamente:

```text
20 comparaciones
```

La diferencia está en que se descarta la mitad en cada paso.

---

### Búsqueda binaria

La búsqueda binaria trabaja con un arreglo ordenado.

Ejemplo:

```text
[3, 4, 5, 6, 7, 8, 9]
```

Queremos buscar:

```text
7
```

En lugar de revisar uno por uno, comenzamos por el centro.

---

### Condición importante

La búsqueda binaria clásica necesita que los datos estén ordenados.

Si el arreglo no está ordenado, no podemos decidir qué mitad descartar.

---

### Código

```java
public static int binarySearch(int[] vec, int target) {
    int low = 0;
    int high = vec.length - 1;
    int mid = 0;

    while (low <= high) {
        mid = (low + high) / 2;

        if (vec[mid] == target) {
            return mid;
        } else if (target > vec[mid]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return -1;
}
```

---

### ¿Qué representan las variables?

```text
low  -> inicio del rango
high -> final del rango
mid  -> posición central
```

En este ejercicio:

```java
vec[mid]
```

`mid` es una posición del arreglo.

---

### Complejidad de búsqueda binaria

En cada paso el problema se reduce a la mitad:

```text
n
n/2
n/4
n/8
...
1
```

Por eso su complejidad es:

```text
O(log n)
```

---

### Cambio de idea

Hasta ahora buscábamos una posición.

Pero también podemos usar búsqueda binaria para buscar una respuesta

Ejemplo:

```text
¿Cuál es la mayor distancia mínima posible?
```

Aquí aparece el problema de las vacas.

---

### Aggressive Cows

Tenemos establos ubicados en distintas posiciones.

```text
[1, 2, 4, 8, 9]
```

Debemos colocar 3 vacas.

Queremos que estén lo más separadas posible.

---

### ¿Qué se busca?

No buscamos una posición del arreglo.

Buscamos una distancia.

```text
¿Cuál es la mayor distancia mínima posible entre vacas?
```

En este problema, el valor del centro representa una distancia candidata.

---

### Probemos una distancia

```text
Establos: [1, 2, 4, 8, 9]
Vacas: 3
Distancia: 3
```

Podemos colocar:

```text
Vaca 1 -> 1
Vaca 2 -> 4
Vaca 3 -> 8
```

Sí se puede.

---

### Probemos una distancia mayor

```text
Distancia: 4
```

Podemos colocar:

```text
Vaca 1 -> 1
Vaca 2 -> 8
```

No alcanza para la tercera vaca.

Entonces distancia 4 no es posible.

---

### Función de comprobación

Código tomado del ejercicio trabajado:

```java
private static boolean es_posible(int[] vec, int distancia, int vacas) {
    int count = 1;
    int pos = vec[0];

    for (int i = 1; i < vec.length; i++) {
        if (vec[i] - pos >= distancia) {
            pos = vec[i];
            count++;
        }

        if (count == vacas){
            return true;
        }
    }
    return false;
}
```

---

### ¿Qué hace `es_posible`?

La función recibe una distancia y responde:

```text
¿Se pueden colocar todas las vacas manteniendo esa distancia?
```

Si puede:

```java
return true;
```

Si no puede:

```java
return false;
```

---

### Búsqueda binaria en las distancias

```java
public static int binarySearch(int[] vec, int vacas) {
    int low = 1;
    int high = vec[vec.length - 1] - vec[0];
    int distancia = 0;
    int distancia_maxima = 0;

    while (low <= high) {
        distancia = (low + high) / 2;

        if (es_posible(vec, distancia, vacas)) {
            low = distancia + 1;
            distancia_maxima = Math.max(distancia, distancia_maxima);
        } else {
            high = distancia - 1;
        }
    }

    return distancia_maxima;
}
```

---

### ¿Qué representa el centro?

En búsqueda binaria clásica:

```text
mid = índice
```

En Aggressive Cows:

```text
distancia = respuesta candidata
```

La fórmula es la misma.

Lo que cambia es el significado de `low`, `high` y el valor central.

---

### Comparación

| Problema | `low` y `high` representan | Centro representa |
|---|---|---|
| Binary Search | índices | una posición |
| Aggressive Cows | distancias | una distancia candidata |

---


### Complejidad de Aggressive Cows

Primero se ordenan los establos:

```text
O(n log n)
```

Después se prueban distancias con búsqueda binaria.

Cada prueba recorre el arreglo:

```text
O(n)
```

Complejidad aproximada:

```text
O(n log n + n log R)
```

---

### Nota

- Lower Bound busca `>=`.
- Upper Bound busca `>`.
- La busqueda binaria sirve para encontrar la mejor respuesta posible
