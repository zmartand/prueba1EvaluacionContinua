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

package Ejercicio2_2.dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tablero {

    private static int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoActual(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;
            estadoActual = new int[DIMENSION][DIMENSION];
            while ((linea = br.readLine()) != null) {
                for (int col = 0; col < DIMENSION; col++) {
                    estadoActual[fila][col] = Character.getNumericValue(linea.charAt(col));
                }
                fila++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarEstadoActualPorMontecarlo() {
        estadoActual = new int[DIMENSION][DIMENSION];
        for (int fila = 0; fila < DIMENSION; fila++) {
            for (int col = 0; col < DIMENSION; col++) {
                double rand = Math.random();
                estadoActual[fila][col] = rand < 0.5 ? 1 : 0;
            }
        }
    }

    public void transitarAlEstadoSiguiente() {
        for (int fila = 0; fila < DIMENSION; fila++) {
            for (int col = 0; col < DIMENSION; col++) {
                int numVecinos = contarVecinosVivos(fila, col);
                if (estadoActual[fila][col] == 1) {
                    if (numVecinos == 2 || numVecinos == 3) {
                        estadoSiguiente[fila][col] = 1;
                    } else {
                        estadoSiguiente[fila][col] = 0;
                    }
                } else {
                    if (numVecinos == 3) {
                        estadoSiguiente[fila][col] = 1;
                    } else {
                        estadoSiguiente[fila][col] = 0;
                    }
                }
            }
        }
        int[][] temp = estadoActual;
        estadoActual = estadoSiguiente;
        estadoSiguiente = temp;
    }

    private int contarVecinosVivos(int fila, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int row = (fila + i + DIMENSION) % DIMENSION;
                int col2 = (col + j + DIMENSION) % DIMENSION;
                count += estadoActual[row][col2];
            }
        }
        count -= estadoActual[fila][col];
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int fila = 0; fila < DIMENSION; fila++) {
            for (int col = 0; col < DIMENSION; col++) {
                sb.append(estadoActual[fila][col] == 1 ? "x " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    }





