public class HiloConsumidor implements Runnable{

    private int[] arrayAConsumir;
    private static int numeroHilo=0;
    public HiloConsumidor(int[] arrayAConsumir){
        this.arrayAConsumir=arrayAConsumir;
        numeroHilo++;
    }


    @Override
    public void run() {
        System.out.println("Hilo número "+numeroHilo);
       consumirDato(arrayAConsumir);
    }
    private void consumirDato(int[] dato) {
        int suma = dato[0];
        int maximoActual=dato[0];
        int minimoActual=dato[0];
        for (int i = 1; i < dato.length; i++) {
            suma += dato[i];
            if(maximoActual<dato[i]){
                maximoActual=dato[i];
            }
            if(minimoActual>dato[i]){
                minimoActual=dato[i];
            }
        }
        if(!Thread.currentThread().isInterrupted()){
            System.out.println("La media es:" + suma / dato.length);
            System.out.println("El máximo es:" + maximoActual);
            System.out.println("El mínimo es:" + minimoActual);
        }else{
            System.out.println("Se ha interrumpido el hilo");
        }
    }

}
