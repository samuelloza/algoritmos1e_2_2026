# Week 3

## Fuerza Bruta y Algoritmos Greedy


---

Supongamos que tenemos varias opciones para resolver un problema

Podemos hacer dos cosas:

```text
Opción 1:
No sé cuál opción es mejor.
Voy a probarlas todas.

Opción 2:
Creo que una opción es mejor.
La elijo y descarto las demás.
```

---

## Fuerza bruta

---

# ¿Qué es fuerza bruta?

La fuerza bruta consiste en:

1. Generar todas las opciones posibles
2. Probar cada opción
3. Comprobar cuáles son válidas
4. Comparar los resultados
5. Quedarse con la mejor respuesta

---

# Ejemplo

Queremos formar el número:

```text
6
```

Tenemos monedas de:

```text
1, 3 y 4
```

Podemos utilizar cualquier moneda varias veces.

Queremos usar la menor cantidad de monedas.

---

# Primera decisión

Desde el monto `6`, podemos elegir:

```text
Usar una moneda de 1
Usar una moneda de 3
Usar una moneda de 4
```

Cada elección deja un monto diferente:

```text
6 - 1 = 5
6 - 3 = 3
6 - 4 = 2
```

---

### Después aparecen nuevas decisiones

Si elegimos la moneda `1`:

```text
6 -> 5
```

Desde `5`, podemos volver a elegir:

```text
1, 3 o 4
```

Si elegimos la moneda `3`:

```text
6 -> 3
```

Desde `3`, podemos elegir:

```text
1 o 3
```

---

# Árbol de posibilidades

```text
                    6
              /     |     \
             5      3      2
           (-1)   (-3)   (-4)
```

La fuerza bruta continúa explorando todos los caminos.

---

### Algunas soluciones posibles

```text
6 = 1 + 1 + 1 + 1 + 1 + 1
6 = 3 + 1 + 1 + 1
6 = 4 + 1 + 1
6 = 3 + 3
```

Cantidad de monedas:

```text
1+1+1+1+1+1  6 monedas
3+1+1+1      4 monedas
4+1+1        3 monedas
3+3          2 monedas
```

Pero la mejor solución es:

```text
3 + 3
```

---

#### ¿Qué hizo la fuerza bruta?

Probó diferentes combinaciones y comparó los resultados.

```text
Mejor resultado = 2 monedas
```

---


#### Fuerza bruta con recursión

```java
static int minimoMonedas(int monto, int[] monedas) {
    if (monto == 0) {
        return 0;
    }

    int mejor = Integer.MAX_VALUE;

    for (int i = 0; i < monedas.length; i++) {
        int moneda = monedas[i];

        if (moneda <= monto) {
            int resultado = 1 + minimoMonedas(monto - moneda, monedas);
            mejor = Math.min(mejor, resultado);
        }
    }

    return mejor;
}
```

Este código es intencionalmente sencillo: permite observar el árbol de decisiones, pero vuelve a resolver muchas veces los mismos montos.


---


### Ejemplo de crecimiento

Si en cada nivel tenemos tres decisiones:

```text
Nivel 1: 3 posibilidades
Nivel 2: 3 × 3 = 9
Nivel 3: 3 × 3 × 3 = 27
Nivel 4: 81
Nivel 5: 243
```

La cantidad de caminos aumenta muy rápido.

---

### Algoritmos Greedy

---
![](https://hedgedoc.aquicasual.me/uploads/6acdade9-e37d-47c3-bbbf-2c0ef28d4cee.png)

---

### El problema de la fuerza bruta

La fuerza bruta puede encontrar la mejor respuesta.

Pero es lenta

---

##### ¿Qué problemas intenta resolver Greedy?

Los algoritmos greedy se utilizan normalmente en problemas de optimización

Un problema de optimización busca:

```text
Minimizar algún resultado
Maximizar algún resultado
El camino más corto entre dos ciudades.
El valor máximo que podemos obtener con ciertos objetos.
El costo mínimo para ofrecer un servicio.
La menor cantidad de monedas para pagar un monto.
El menor tiempo necesario para terminar un trabajo.
La mayor cantidad de actividades que podemos realizar.
```
En todos estos problemas existen varias soluciones posibles.

**El objetivo es encontrar la mejor.**

---

#### ¿Cómo construye una solución Greedy?

Un algoritmo greedy intenta construir una solución óptima paso a paso.

En cada paso:

1. Observa las opciones disponibles
2. Elige la opción que parece mejor
3. Comprueba si puede utilizarla
4. La agrega a la solución o la descarta
5. Continúa sin regresar (No puede retroceder)

---

#### La idea de Greedy


```text
Elegir la mejor opción local
en cada paso
```

Para obtener

```text
La mejor solución global
al finalizar
```

**Pero esa esperanza no siempre se cumple**

---

#### Decisión local

Una decisión local analiza solamente el paso actual.

Por ejemplo:

```text
Elegir la moneda más grande.
Elegir la actividad que termina primero.
Elegir el objeto de mayor valor.
Elegir el objeto de menor peso.
Elegir el candidato de menor costo.
```

La decisión local depende del objetivo del problema.

---

#### Solución global

La solución global es la respuesta completa obtenida al finalizar el algoritmo.

---

#### Características de Greedy

Un algoritmo greedy normalmente:

- construye la solución paso a paso;
- selecciona un candidato en cada paso;
- no revisa una selección ya realizada;
- no regresa para cambiar decisiones;
- descarta opciones que considera innecesarias;
- suele ser rápido;
- necesita una regla clara de selección;
- no funciona correctamente en todos los problemas.

---

#### Greedy no vuelve atrás

Una vez que greedy toma una decisión:

```text
No regresa para cambiarla.
```

Por ejemplo:

```text
Monto: 41
Moneda seleccionada: 25
```

Después de elegir `25`, el algoritmo continúa con:

```text
Monto restante: 16
```

No vuelve para preguntarse si debía haber elegido otra moneda.

---

#### Conjunto de candidatos

Al comenzar tenemos un conjunto de opciones disponibles.

Lo llamaremos:

```text
C = candidatos
```

Por ejemplo, en el cambio de monedas:

```text
C = {1, 5, 10, 25}
```

Cada moneda es un candidato que podría formar parte de la solución.

---

#### Conjunto de seleccionados

La solución se construye utilizando los candidatos elegidos.

Lo llamaremos:

```text
S = seleccionados
```

Al principio:

```text
S = {}
```

Después de elegir la moneda `25`:

```text
S = {25}
```

---

Después de elegir `10`:

```text
S = {25, 10}
```

---

#### Funciones importantes de Greedy

Un algoritmo greedy necesita responder varias preguntas.

#### Selección

```text
¿Cuál es el mejor candidato disponible?
```

#### Viabilidad

```text
¿Puedo agregar este candidato
sin romper las restricciones?
```

#### Solución

```text
¿Ya completé el objetivo?
```

---

#### Función de selección

La función de selección aplica la regla greedy.

```text
seleccionarMejor(candidatos)
```

Dependiendo del problema puede elegir:

```text
La moneda de mayor valor.

La actividad que termina primero.

El objeto con mejor valor por peso.

La arista de menor costo.

La primera coincidencia disponible.
```

Esta función define qué significa “mejor” localmente.

---

#### Función de viabilidad

La función de viabilidad comprueba si el candidato puede agregarse.

```text
esViable(solución, candidato)
```

Ejemplos:

```text
¿La moneda no supera el monto restante?

¿El objeto cabe en la mochila?

¿La actividad no se cruza con otra?

¿La arista forma un ciclo?

¿La elección respeta las reglas del problema?
```

---

#### Función de solución

La función de solución comprueba si ya alcanzamos el objetivo.

```text
esSolucion(solución)
```

Por ejemplo:

```text
El monto restante llegó a cero.

La mochila llegó a su capacidad.

Ya seleccionamos todas las actividades posibles.

Ya encontramos todos los caracteres necesarios.

Ya conectamos todos los nodos.
```

---

#### Idea general del Greedy

```text
Candidatos disponibles
          |
Seleccionar el mejor candidato
          |
     ¿Es viable?
       /     \
     sí       no
     |         |
 agregar    rechazar
     \         /
      continuar
          |
 ¿La solución está completa?
```

---

#### No todos los problemas aceptan Greedy

Una estrategia greedy puede:

```text
Funcionar para algunos casos
```

y fallar para otros.

También puede funcionar para un tipo de problema y fallar cuando cambian las reglas.

Por eso:

> No basta con encontrar una decisión local que parezca buena.

---

#### Ejemplo con monedas

Para:

```text
Monedas: 1, 5, 10 y 25
Monto: 41
```

la regla:

```text
Elegir siempre la moneda más grande posible
```

produce:

```text
25 + 10 + 5 + 1
```

Parece una buena solución.

---
---






---

---


---
---
---
---
---
---
---
#### Pero las reglas pueden cambiar

Para:

```text
Monedas: 1, 3 y 4
Monto: 6
```

la misma regla produce:

```text
4 + 1 + 1
```

Sin embargo, existe una solución mejor:

```text
3 + 3
```

Esto demuestra que una regla greedy no funciona automáticamente para todos los problemas.

---

#### Idea que debe recordar el estudiante

```text
Greedy no significa:
“Elegir siempre el mayor”.
```

Greedy significa:

```text
Definir qué opción parece mejor.

Elegirla.

No regresar.

Justificar por qué las otras
opciones pueden descartarse.
```

---

#### Preguntas para la clase

Antes de mostrar una solución greedy, responde:

1. ¿Cuál es el objetivo que queremos optimizar?
2. ¿Cuáles son los candidatos?
3. ¿Qué significa que un candidato sea mejor?
4. ¿Cómo elegimos al mejor candidato?
5. ¿Cuándo un candidato es viable?
6. ¿Cuándo la solución está completa?
7. ¿Puede la decisión local perjudicar el futuro?
8. ¿Podemos encontrar un contraejemplo?

---

#### Resumen

Los algoritmos greedy suelen resolver problemas de optimización.

Construyen una solución:

```text
paso a paso
```

En cada paso:

```text
eligen la opción que parece mejor
```

y continúan:

```text
sin regresar
```

Su objetivo es que:

```text
una secuencia de buenas decisiones locales
```

produzca:

```text
una solución global óptima
```

Pero esto debe justificarse.

---

#### Ejemplo Greedy

Tenemos monedas:

```text
1, 5, 10 y 25
```

Queremos formar:

```text
41
```

Una idea natural es:

> Elegir siempre la moneda más grande que no supere el monto restante

---

#### Aplicando Greedy

Monto inicial:

```text
41
```

Elegimos `25`:

```text
41 - 25 = 16
```

Elegimos `10`:

```text
16 - 10 = 6
```

---

#### Continuamos

Elegimos `5`:

```text
6 - 5 = 1
```

Elegimos `1`:

```text
1 - 1 = 0
```

Solución obtenida:

```text
25 + 10 + 5 + 1
```

Cantidad:

```text
4 monedas
```

---

# ¿Cuál fue la decisión local?

En cada paso elegimos:

```text
La moneda de mayor valor
que no supere el monto restante
```

Esta es la regla greedy.

---

# Probemos otro sistema

Monedas:

```text
1, 3 y 4
```

Monto:

```text
6
```

Aplicamos la misma regla:

> Elegir siempre la moneda más grande posible.

---

# Resultado Greedy

Primero elegimos `4`:

```text
6 - 4 = 2
```

Después solo podemos utilizar monedas de `1`:

```text
2 - 1 = 1
1 - 1 = 0
```

Solución greedy:

```text
4 + 1 + 1
```

Cantidad:

```text
3 monedas
```

---

# ¿Existe una solución mejor?

Sí:

```text
6 = 3 + 3
```

Cantidad:

```text
2 monedas
```

Comparación:

```text
Greedy:  4 + 1 + 1 -> 3 monedas
Óptimo:  3 + 3     -> 2 monedas
```

---

# Greedy falló

La moneda `4` parecía la mejor decisión inmediata.

Reducía más el monto.

Pero dejó un residuo difícil:

```text
2
```

Ese residuo obligó a utilizar dos monedas adicionales.

---
![](https://hedgedoc.aquicasual.me/uploads/2b8af1a8-8705-41e5-a835-c2d352bf73dd.png)

---


## Removing Digits

https://cses.fi/problemset/task/1637

---

# El problema

Tenemos un número entero `n`.

En cada operación podemos restarle uno de sus dígitos no nulos.

Queremos llegar a cero utilizando la menor cantidad de operaciones.

Ejemplo:

```text
n = 27
```

Sus dígitos son:

```text
2 y 7
```

---

# Decisiones disponibles

Podemos hacer:

```text
27 - 2 = 25
27 - 7 = 20
```

Ahora debemos responder:

> ¿Cuál opción debemos elegir?

---

# Enfoque de fuerza bruta

```text
No sé cuál es mejor.
Probaré ambas.
```

Desde `25`, prueba:

```text
25 - 2 = 23
25 - 5 = 20
```

Desde `20`, prueba:

```text
20 - 2 = 18
```

---

# Árbol inicial

```text
                                  27
                     ┌─────────────┴─────────────┐
                  27 - 2                      27 - 7
                     │                            │
                    25                           20
             ┌───────┴───────┐                    │
          25 - 2           25 - 5              20 - 2
             │                 │                  │
            23                20                 18
        ┌────┴────┐             │          ┌──────┴──────┐
     23 - 2     23 - 3       20 - 2     18 - 1        18 - 8
        │           │           │           │              │
       21          20          18          17             10
    ┌───┴───┐       │      ┌────┴────┐  ┌──┴──┐           │
 21 - 2  21 - 1   20 - 2 18 - 1  18 - 8 17 - 1 17 - 7   10 - 1
    │       │        │       │       │      │      │        │
   19      20       18      17      10     16     10        9
 ┌──┴──┐    │    ┌──┴──┐ ┌──┴──┐    │   ┌──┴──┐   │        │
19-1 19-9 20-2 18-1 18-8 17-1 17-7 10-1 16-1 16-6 10-1    9-9
  │     │    │    │    │    │    │    │    │    │    │      │
 18    10   18   17   10   16   10    9   15   10    9      0
```

La fuerza bruta continúa explorando cada rama hasta que llegue al caso base n = 0

---

# fuerza bruta

```java
public static int resolver(int n) {
    if (n == 0) {
        return 0;
    }

    int mejor = Integer.MAX_VALUE;
    int numero = n;

    while (numero > 0) {
        int digito = numero % 10;
        numero /= 10;

        if (digito != 0) {
            int pasos = 1 + resolver(n - digito);
            mejor = Math.min(mejor, pasos);
        }
    }

    return mejor;
}
```

Esta versión sirve para estudiar fuerza bruta, pero no es adecuada para valores grandes porque genera muchas llamadas repetidas. El archivo correspondiente es:

```text
Cses1637FuerzaBruta.java
```

---

# Enfoque Greedy

Podemos proponer:

> Elegir siempre el dígito mayor.

Para `27`:

```text
27 - 7 = 20
```

¿Por qué?

Porque:

* todas las restas cuestan una operación;
* restar `7` reduce más que restar `2`;
* después del movimiento quedamos más cerca de cero.

---

# Aplicando el candidato Greedy

```text
27 -> 20
20 -> 18
18 -> 10
10 -> 9
9  -> 0
```

Dígitos elegidos:

```text
7, 2, 8, 1, 9
```

Cantidad:

```text
5 operaciones
```

---

```java
import java.util.Scanner;

public class Main {

    public static int mayorDigito(int n) {
        int mayor = 0;

        while (n > 0) {
            int digito = n % 10;
            n /= 10;

            mayor = Math.max(mayor, digito);
        }

        return mayor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int pasos = 0;

        while (n > 0) {
            int digito = mayorDigito(n);

            n = n - digito;
            pasos++;
        }

        System.out.println(pasos);
    }
}
```
---
# Fuerza bruta y Greedy en Removing Digits

## Fuerza bruta

```text
Prueba cada dígito posible.
Genera varias ramas.
Compara todos los caminos.
```

## Greedy

```text
Elige directamente el dígito mayor.
Sigue una sola rama.
```

---

Restar el dígito mayor siempre es correcto?

Una decisión que parece buena ahora debe analizarse cuidadosamente

El archivo:

```text
Cses1637Greedy.java
```

---

# Ejemplo: Mochila Fraccionaria

Tenemos `n` objetos.

Cada objeto `i` tiene:

- un peso `w[i]`;
- un valor `v[i]`.

También tenemos una mochila con capacidad máxima `W`.

Queremos cargar la mochila de forma que:

```text
El valor total transportado sea máximo.
```

Sin superar:

```text
La capacidad máxima de la mochila.
```

![](https://hedgedoc.aquicasual.me/uploads/909103af-ab67-4816-a8dc-8cca16472aba.png)

capacidad de 100

---

# Algoritmo general

```java
public static double[] greedy(int[] pesos, int[] valores, int capacidad) {
    double[] solucion = new double[pesos.length];
    boolean[] visitado = new boolean[pesos.length];
    double pesoActual = 0;

    while (pesoActual < capacidad) {
        int i = seleccionar(pesos, valores, visitado);

        if (i == -1) {
            break;
        }

        visitado[i] = true;

        if (pesoActual + pesos[i] <= capacidad) {
            solucion[i] = 1;
            pesoActual += pesos[i];
        } else {
            solucion[i] = (capacidad - pesoActual) / (double) pesos[i];

            break;
        }
    }

    return solucion;
}
```

El arreglo `visitado` evita seleccionar varias veces el mismo objeto. La función `seleccionar` cambia según la estrategia:

- mayor valor;
- menor peso;
- mayor valor por unidad de peso.

Como este ejemplo permite tomar una parte de un objeto, la solución se representa con `double[]`:

```text
0.0  -> no se toma el objeto
1.0  -> se toma completo
0.5  -> se toma la mitad
```

---

# Estrategia 1

## Seleccionar el objeto de mayor valor

Observamos solamente:

```text
El valor de cada objeto.
```

| Objeto | Peso | Valor |
|---:|---:|---:|
| 1 | 10 | 20 |
| 2 | 20 | 30 |
| 3 | 30 | 66 |
| 4 | 40 | 40 |
| 5 | 50 | 60 |

---

# Primer objeto

El objeto de mayor valor es:

```text
Objeto 3
Peso = 30
Valor = 66
```

La capacidad restante es:

```text
100 - 30 = 70
```

Valor acumulado:

```text
66
```

---

# Segundo objeto

El siguiente objeto de mayor valor es:

```text
Objeto 5
Peso = 50
Valor = 60
```

Como cabe completo:

```text
70 - 50 = 20
```

Valor acumulado:

```text
66 + 60 = 126
```

---

# Tercer objeto

El siguiente objeto de mayor valor es:

```text
Objeto 4
Peso = 40
Valor = 40
```

Pero solamente quedan:

```text
20 unidades de capacidad
```

Entonces llevamos una fracción:

```text
20 / 40 = 0.5
```

Llevamos el `50 %` del objeto.

---

# Resultado por mayor valor

Valor de la fracción:

```text
40 × 0.5 = 20
```

Valor total:

```text
66 + 60 + 20 = 146
```

Peso total:

```text
30 + 50 + 20 = 100
```

Resultado:

```text
Valor total = 146
```

### Relación con el código de clase

El cálculo anterior corresponde a la **mochila fraccionaria**. Sin embargo, el archivo actual:

```text
t_greedy_mochila_mayor_valor.java
```

utiliza un arreglo `boolean[]`. Por eso solo puede decidir entre tomar un objeto completo (`true`) o no tomarlo (`false`). Si un objeto no cabe, lo descarta y continúa con el siguiente.

Con los datos de este ejemplo, el programa selecciona los objetos con valores `66`, `60` y `30`, cuyo valor total es:

```text
66 + 60 + 30 = 156
```
---

# Estrategia 2

## Seleccionar el objeto de menor peso

Observamos solamente:

```text
El peso de cada objeto.
```

Orden de selección:

```text
Objeto 1: peso 10
Objeto 2: peso 20
Objeto 3: peso 30
Objeto 4: peso 40
Objeto 5: peso 50
```

---

# Aplicando menor peso

Seleccionamos:

```text
Objeto 1:
Peso = 10
Valor = 20
```

Después:

```text
Objeto 2:
Peso = 20
Valor = 30
```

Después:

```text
Objeto 3:
Peso = 30
Valor = 66
```

Después:

```text
Objeto 4:
Peso = 40
Valor = 40
```

---

# Resultado por menor peso

Peso total:

```text
10 + 20 + 30 + 40 = 100
```

Valor total:

```text
20 + 30 + 66 + 40 = 156
```

Resultado:

```text
Valor total = 156
```

---

# Estrategia 3

## Mayor valor por unidad de peso

Ahora consideramos:

```text
Cuánto valor aporta el objeto.
```

y también:

```text
Cuánto espacio ocupa.
```

Calculamos:

\[
\frac{valor}{peso}
\]

---

# Cálculo de la razón

| Objeto | Peso | Valor | Valor / Peso |
|---:|---:|---:|---:|
| 1 | 10 | 20 | `20 / 10 = 2.0` |
| 2 | 20 | 30 | `30 / 20 = 1.5` |
| 3 | 30 | 66 | `66 / 30 = 2.2` |
| 4 | 40 | 40 | `40 / 40 = 1.0` |
| 5 | 50 | 60 | `60 / 50 = 1.2` |

---

# Orden de selección

De mayor a menor valor por unidad de peso:

```text
Objeto 3: 2.2
Objeto 1: 2.0
Objeto 2: 1.5
Objeto 5: 1.2
Objeto 4: 1.0
```

---

# Seleccionamos el objeto 3

```text
Peso = 30
Valor = 66
```

Capacidad restante:

```text
100 - 30 = 70
```

Valor acumulado:

```text
66
```

---

# Seleccionamos el objeto 1

```text
Peso = 10
Valor = 20
```

Capacidad restante:

```text
70 - 10 = 60
```

Valor acumulado:

```text
66 + 20 = 86
```

---

# Seleccionamos el objeto 2

```text
Peso = 20
Valor = 30
```

Capacidad restante:

```text
60 - 20 = 40
```

Valor acumulado:

```text
86 + 30 = 116
```

---

# Seleccionamos una fracción del objeto 5

El objeto `5` pesa:

```text
50
```

Pero solamente quedan:

```text
40 unidades de capacidad
```

La fracción que podemos llevar es:

```text
40 / 50 = 0.8
```

Llevamos el `80 %` del objeto.

---

# Valor de la fracción

El valor completo del objeto `5` es:

```text
60
```

El valor del `80 %` es:

```text
60 × 0.8 = 48
```

Valor total:

```text
66 + 20 + 30 + 48 = 164
```

Peso total:

```text
30 + 10 + 20 + 40 = 100
```

---

# Solución final

```text
Objeto 1: 100 %
Objeto 2: 100 %
Objeto 3: 100 %
Objeto 4: 0 %
Objeto 5: 80 %
```

Arreglo solución:

```text
[1, 1, 1, 0, 0.8]
```

Resultado:

```text
Valor total = 164
```

---

# Resumen de las estrategias

| Estrategia | Valor obtenido |
|---|---:|
| Mayor valor | 146 |
| Menor peso | 156 |
| Mayor valor por unidad de peso | **164** |

La mejor estrategia fue:

> Seleccionar el objeto con mayor valor por unidad de peso.

El código completo está en:

```text
t_greedy_mochila_fraccionaria.java
```

Al ejecutarlo debe mostrar:

```text
Peso total = 100.0
Valor total = 164.0
```
---

# Ejemplo de monedas

Queremos formar:

```text
36
```

Tenemos monedas de:

```text
1, 2, 5, 10 y 20
```

Queremos utilizar la menor cantidad de monedas.

---

# Candidato Greedy

Podemos proponer:

> Elegir siempre la moneda de mayor valor que no supere el monto restante.

---

# Aplicando Greedy

Monto inicial:

```text
36
```

Elegimos `20`:

```text
36 - 20 = 16
```

Elegimos `10`:

```text
16 - 10 = 6
```

---

# Continuamos

Elegimos `5`:

```text
6 - 5 = 1
```

Elegimos `1`:

```text
1 - 1 = 0
```

Solución:

```text
20 + 10 + 5 + 1
```

Cantidad:

```text
4 monedas
```

---

# Parece una buena solución

La estrategia fue:

```text
Elegir siempre la moneda más grande posible.
```

Para este sistema de monedas obtenemos:

```text
4 monedas
```

Pero debemos comprobar si esta regla funciona siempre.

---

# Cambiamos las monedas

Ahora tenemos:

```text
1, 5, 10, 18 y 20
```

Queremos formar nuevamente:

```text
36
```

Aplicamos la misma estrategia greedy.

---

# Resultado Greedy

Elegimos `20`:

```text
36 - 20 = 16
```

Elegimos `10`:

```text
16 - 10 = 6
```

Elegimos `5`:

```text
6 - 5 = 1
```

Elegimos `1`:

```text
1 - 1 = 0
```

---

# Solución Greedy

```text
20 + 10 + 5 + 1
```

Cantidad:

```text
4 monedas
```

---

# ¿Existe una solución mejor?

Sí:

```text
18 + 18 = 36
```

Cantidad:

```text
2 monedas
```

Comparación:

```text
Greedy:
20 + 10 + 5 + 1 = 4 monedas

Óptimo:
18 + 18 = 2 monedas
```

---

# Greedy falló

La moneda `20` parecía ser la mejor decisión inmediata.

Pero dejó un monto restante de:

```text
16
```

En cambio, elegir `18` permitía completar el monto utilizando solamente dos monedas.

---

# Contraejemplo

El sistema:

```text
Monedas: 1, 5, 10, 18 y 20
Monto: 36
```

es un contraejemplo para la afirmación:

> Elegir siempre la moneda más grande produce la menor cantidad de monedas.

---

# Conclusión

Una decisión greedy puede parecer correcta y funcionar en varios ejemplos.

Pero:

```text
Una buena decisión local
no siempre produce
la mejor solución global.
```

Por eso debemos:

```text
Probar ejemplos.

Buscar contraejemplos.

Justificar la elección greedy.
```

---

# Divide y Vencerás

Divide y Vencerás también utiliza problemas pequeños, pero la idea es distinta a fuerza bruta y greedy.

```text
1. Dividir el problema en partes más pequeñas.
2. Resolver cada parte.
3. Combinar las respuestas.
```

No elegimos una sola opción como en greedy y tampoco probamos todas las combinaciones. Separamos el problema en partes que tengan la misma forma que el problema original.

## Ejemplo: encontrar el número mayor

Tenemos:

```text
[7, 2, 15, 4, 9, 21, 3, 12]
```

Primero dividimos el arreglo:

```text
[7, 2, 15, 4]     [9, 21, 3, 12]
```

Seguimos dividiendo hasta tener un solo número. Un arreglo con un solo elemento ya tiene una respuesta: ese elemento es su máximo.

Después combinamos las respuestas usando `Math.max`:

```text
Máximo de la mitad izquierda = 15
Máximo de la mitad derecha   = 21
Máximo de todo el arreglo    = 21
```

La parte principal del código es:

```java
public static int maximo(int[] numeros, int inicio, int fin) {
    if (inicio == fin) {
        return numeros[inicio];
    }

    int medio = (inicio + fin) / 2;

    int maximoIzquierda = maximo(numeros, inicio, medio);
    int maximoDerecha = maximo(numeros, medio + 1, fin);

    return Math.max(maximoIzquierda, maximoDerecha);
}
```

El ejemplo completo está en:

```text
MaximoDivideVenceras.java
```

## Comparación

| Técnica | Qué hace |
|---|---|
| Fuerza bruta | Prueba las posibilidades y compara sus resultados. |
| Greedy | Toma la decisión que parece mejor en ese momento y no regresa. |
| Divide y Vencerás | Divide el problema, resuelve las partes y combina las respuestas. |

Otros problemas conocidos que usan esta idea son búsqueda binaria y Merge Sort.

---
