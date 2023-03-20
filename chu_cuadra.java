import java.util.Scanner;

public class chu_cuadra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el tamana de la tabla | FILAS: ");
        int f = sc.nextInt();
        System.out.print("Ingresa el tamana de la tabla | COLUMNAS: ");
        int c = sc.nextInt();        

        
        System.out.println("Ingrese el margen de error: ");
        final double margen = sc.nextDouble(); 

        int[][] matrizOriginal = llenarMatriz(f, c, sc);
        
        int[] Vmatriz = llenarVArr(f, matrizOriginal);

        int[] Hmatriz = llenarHArr(c, matrizOriginal);

        int total = Totales(Hmatriz);

        double[][] FtMatriz = Ft(f, c, total, Vmatriz, Hmatriz);

        System.out.println("Chi cuadrada: "+XCuadrada(matrizOriginal, FtMatriz));

        System.out.println("Chi cuadrada critica: " + tablaDistribucion(gradoLibertad(f, c), margen));
        
    }

    public static double XCuadrada(int[][] original, double[][] Ft) {
        double count = 0;
        for (int i = 0; i < Ft.length; i++) {
            for (int j = 0; j < Ft[i].length; j++) {
                count += Math.pow((original[i][j] - (Ft[i][j])), 2)/(Ft[i][j]);
            }
        }
        return count;
    }

    public static double[][] Ft(int f, int c, int total, int[] arrV, int[] arrH) {
        double[][] arrFT = new double[f][c];

        for (int i = 0; i < arrFT.length; i++) {

            for (int j = 0; j < arrFT[i].length; j++) {

                arrFT[i][j] = (double) (arrV[i]*arrH[j])/total;
            }
        } 

        return arrFT;
    }

    public static int gradoLibertad(int filas, int columnas) {

        int v = (filas - 1)*(columnas - 1);
        return v;
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
    
    public static double tablaDistribucion(int gL, double mE) {
        int[] gradeLibertyArr = {1, 2, 3, 4, 5};
        double[] marginErrorArr = {0.001, 0.0025, 0.005, 0.01, 0.025, 0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.5};

        double[][] tabla = {
        {10.8274, 9.1404, 7.8794, 6.6349, 5.0239, 3.8415, 2.7055, 2.0722, 1.6424, 1.3233, 1.0742, 0.8735, 0.7083, 0.5707, 0.4549},
        {13.8150, 11.9827, 10.5965, 9.2104, 7.3778, 5.9915, 4.6052, 3.7942, 3.2189, 2.7726, 2.4079, 2.0996, 1.8326, 1.5970, 1.3863},
        {16.2660, 14.3202, 12.8381, 11.3449, 9.3484, 7.8147, 6.2514, 5.3170, 4.6416, 4.1083, 3.6649, 3.2831, 2.9462, 2.6430, 2.3660}, 
        {18.4662, 16.4238, 14.8602, 13.2767, 11.1433, 9.4877, 7.7794, 6.7449, 5.9886, 5.3853, 4.8784, 4.4377, 4.0446, 3.6871, 3.3567}, 
        {20.5147, 18.3854, 16.7496, 15.0863, 12.8325, 11.0705, 9.2363, 8.1152, 7.2893, 6.6257, 6.0644, 5.5731, 5.1319, 4.7278, 4.3515}
        };

        int auxI = 200; //Los valore son para rapido
        int auxJ = 200; //Los valore son para rapido
        double resultado;

        for (int i = 0; i < gradeLibertyArr.length; i++) {
            if (gL == gradeLibertyArr[i]) {
                auxI = i;
            }
        }

        for (int i = 0; i < marginErrorArr.length; i++) {
            if (mE == marginErrorArr[i]) {
                auxJ = i;
            }
        }

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if (i == auxI && j == auxJ) {
                    resultado = tabla[i][j];
                    return resultado;
                }
            }
        }

        return 0;
    }
}