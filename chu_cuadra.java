import java.util.Scanner;

/**
 * chu_cuadra
 */
public class chu_cuadra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el tamana de la tabla | FILAS: ");
        int f = sc.nextInt();
        System.out.print("Ingresa el tamana de la tabla | COLUMNAS: ");
        int c = sc.nextInt() ;        

        final double margen = 0.01;
        
        
        

        int[][] matrizOriginal = llenarMatriz(f, c, sc);
        
        int[] Vmatriz = llenarVArr(f, matrizOriginal);

        int[] Hmatriz = llenarHArr(c, matrizOriginal);

        int total = Totales(Hmatriz);

        // double gradoLibertad = gradoLibertad(f, c);
        
        
    }

    public static void Ft(int f, int c, int total, int[][] arr, int[] arrV, int[] arrH) {
        int[][] arrFT = new int[f][c];

        for (int index = 0; index < array.length; index++) {
            
        }
    }

    public static double gradoLibertad(int filas, int columnas) {

        double v = (filas - 1)*(columnas - 1);
        return v;
    }

    public static void sumaRecursiva() {
        
    }

    public static int Totales(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
        }
        return count;
    }

    public static int[][] llenarMatriz(int f, int c, Scanner sc) {
        int[][] matriz = new int[f][c];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Ingresa el valor a la tabla: ");
                matriz[i][j] = sc.nextInt();

            }
        }      
        
        return matriz;
    }


    public static int[] llenarVArr(int f, int[][] arr) {
        int[] Vmatriz = new int[f];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                count += arr[i][j];
            }
            Vmatriz[i] = count;
            count = 0;
        } 
        return Vmatriz;
    }

    public static int[] llenarHArr(int c, int[][] arr) {
        int[] Hmatriz = new int[c];
        int count = 0;  
        for (int i = 0; i < arr[0].length; i++) {

            for (int j = 0; j < arr.length; j++) {
                count += arr[j][i];
            }

            Hmatriz[i] = count;
            count = 0;
        }     
        return Hmatriz;
    }    
}