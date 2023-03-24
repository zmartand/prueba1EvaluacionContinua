/*
Copyright [2023] [Zara Martín]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific
language governing permissions and limitations under the
License.
*/

package Ejercicio2_1.mates;

import java.util.Scanner;
public class Matematicas {

    // Ejercicio 1.2
    public void MetodoMontecarlo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de puntos a generar: ");
        int puntosTotales = sc.nextInt();
        int aciertos = 0;
        double areaCuadrado = 4;
        for (int i = 1; i <= puntosTotales; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;
            if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= 1) {
                aciertos++;
            }
        }
        System.out.println("El valor de pi es: " + areaCuadrado * ((double) aciertos / (double) puntosTotales));
    }
}


