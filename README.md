# Prueba  evaluacion continua
## Nota:
Mi repositorio es: https://github.com/zmartand/prueba1EvaluacionContinua.git

### 2.1. Práctica 1. Obtención de una aproximación al número pi
Implemente un programa que permita obtener una aproximación al número
pi mediante el método de Montecarlo1
. Se propone el siguiente pseudocódigo
(tenga en cuenta que el radio del círculo elegido es 1):
Algoritmo 1: Aproximación a pi mediante Montecarlo
Input: puntosT otales: cantidad de puntos a generar
Output: Número real que es una aproximación al número pi
aciertos ← 0;
areaCuadrado ← 4;
for i ← 1 to puntosT otales do
Obtener un número aleatorio x entre -1 y 1;
Obtener un número aleatorio y entre -1 y 1;
if d((x, y),(0, 0)) ≤ 1 then aciertos ← aciertos + 1;
end
return areaCuadrado · (aciertos/puntosT otales) ;
El cuadrado en que está inscrito el círculo tiene como vértices los puntos
(−1, −1),(−1, 1),(1, 1),(1, −1). El círculo tiene como centro el punto (0, 0).
Además, tal y como explica el vídeo al que se ha hecho referencia anteriormente, se asume que la proporción de puntos que caen dentro del círculo con
respecto al total de puntos generados es aproximadamente la misma que la
proporción entre el área del círculo y la del cuadrado en que está inscrito.
El pseudocódigo está escrito para que el estudiante pueda relacionarlo
con el método explicado en el vídeo. No obstante, se pueden realizar simplificaciones para que el programa final ocupe menos líneas de código sin
cambiar su comportamiento.
El algoritmo estará implementado en la clase Matematicas.java de acuerdo con la siguiente estructura:
package mates;
public class Matematicas{
/**
* Genera una aproximación al número pi mediante el método de
* Montecarlo. El parámetro ‘pasos‘ indica el número de puntos
* generado.
*/
public static double generarNumeroPi(long pasos){
return 0; // Este código hay que cambiarlo.
}
}
El programa principal para mostrar el resultado es el siguiente:
package aplicacion;
import mates.Matematicas;
public class Principal{
public static void main(String[] args){
System.out.println("El número PI es " + Matematicas.
generarNumeroPi(Integer.parseInt(args[0])));
}
}

### 2.2. Práctica 2. El juego de la vida
### 2.3. Práctica 3. Búsqueda de un camino en un grafo
