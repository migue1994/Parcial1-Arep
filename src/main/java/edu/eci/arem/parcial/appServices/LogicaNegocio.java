package edu.eci.arem.parcial.appServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogicaNegocio{
    private int[] numDatos;


    private int sumatoria;

    public void getEntrada(String datos){

        String[] listDatos = datos.split(",");
        
        listDatos = datos.split(",");

        this.numDatos = new int[listDatos.length];

        for(int i = 0; i < numDatos.length; i++){
            this.numDatos[i] = Integer.parseInt(listDatos[i]);
        }

    }

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

    public void sumatoria(){
        int sum = 0;
        for(int i:numDatos){
            sum += i;
        }
        setSumatoria(sum);
    }
}
