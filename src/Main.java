import java.util.LinkedList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<int[]> listaVectores=new LinkedList<>();
        List<Thread> listaHilos=new LinkedList<>();
        int[] array;
        int tiempoMiliSegundo=50;
        Thread h1;
        for (int i=0;i<20;i++){
            array=new int[1000000];
            for(int j=0;j<array.length;j++){
                array[j]=(int)(Math.random()*10000);
            }
            listaVectores.add(array);
        }

        for (int array2[] : listaVectores){
            h1=new Thread(new HiloConsumidor(array2));
            h1.start();
            listaHilos.add(h1);
        }

        try {
            Thread.sleep(tiempoMiliSegundo);
        } catch (InterruptedException e) {

        }
        for (Thread hilo:listaHilos) {
            if(hilo.isAlive()){
                hilo.interrupt();
            }
        }
    }

}
