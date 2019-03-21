package kagglestudents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String... args){

       /* StudentNotebook studentNotebook = new StudentNotebook();

        try {

            String strFile = "C:\\Users\\marco\\Documents\\Arquivos Pitang\\Admission_Predict.csv";
            BufferedReader reader = new BufferedReader(new FileReader(strFile));
            String nextLine;
            String csvDivisor = ",";
            int lineNumber = 0;
            nextLine = reader.readLine();
            System.out.println(nextLine);
            String[] notas = null;

            ArrayList<Double> arrayNotas = new ArrayList<Double>();

            while ((nextLine = reader.readLine()) != null) {
                lineNumber++;

                notas = nextLine.split(csvDivisor);

                System.out.println("Line # " + lineNumber);

                // nextLine[] is an array of values from the line
                System.out.println(notas[4]);
                arrayNotas.add(Double.parseDouble(notas[notas.length-1]));
            }

            double a;
            a = Double.parseDouble(arrayNotas.get(0).toString());
            System.out.println(a);
            a = Double.parseDouble(arrayNotas.get(1).toString());
            System.out.println(a);

            for(int i=0; i<arrayNotas.size(); i++){
                //System.out.println("Valor de i: " + arrayNotas.get(i));
            }

            System.out.println(aprovado.aprovadoId(notas.length-1));


        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
