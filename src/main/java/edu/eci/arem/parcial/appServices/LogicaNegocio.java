package edu.eci.arem.parcial.appServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Clse que e encarga de realizar las operaciones solicitadas
 */
public class LogicaNegocio{
    private int[] numDatos;


    private int sumatoria;
    /**
     * obtiene el string de la entrada dada por el usuaio
     * @param datos
     */
    public void getEntrada(String datos){

        String[] listDatos = datos.split(",");
        
        listDatos = datos.split(",");

        this.numDatos = new int[listDatos.length];

        for(int i = 0; i < numDatos.length; i++){
            this.numDatos[i] = Integer.parseInt(listDatos[i]);
        }

    }

    /**
     * Realiza el ordenamiento de los dato usando el algoritmo merge sort
     * @param a Lita de enteros
     * @param n tamaño de la lita
     */
    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
     
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
     
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Se encarga de unir los gracfentos depues de la division recurrente
     * @param a Arreglo resultante
     * @param l Parte izquierda del arreglo
     * @param r Parte derecha del arreglo
     * @param left entero
     * @param right entero
     */
    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        
          int i = 0, j = 0, k = 0;
          while (i < left && j < right) {
              if (l[i] <= r[j]) {
                  a[k++] = l[i++];
              }
              else {
                  a[k++] = r[j++];
              }
          }
          while (i < left) {
              a[k++] = l[i++];
          }
          while (j < right) {
              a[k++] = r[j++];
          }
      }

      /**
       * Se encarga de armar el JSON que e le va a devolver al usuario
       * @return String que contiene el JSON armado
       */
    public String printAnswer(){
        String ans = "{ \"numDatos\" :[";
        for(int i= 0; i < numDatos.length; i++){
            if (i < numDatos.length-1){
                ans += numDatos[i]+", ";
            }else{
                sumatoria();
                ans += "], \"sumatoria\" : "+sumatoria+"}";
            }

        }
        return ans;
    }

    /**
     * Realiza la sumatoria de lo elementos del arreglo
     */
    public void sumatoria(){
        int sum = 0;
        for(int i:numDatos){
            sum += i;
        }
        setSumatoria(sum);
    }
}
