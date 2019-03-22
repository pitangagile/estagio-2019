package kagglestudents;

import java.math.BigDecimal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public abstract class AbstractExtractStudent implements IExtracStudent {

	public List<StudentVO> load() {
		
		String fileName= "/home/vpss/Downloads/Admission_Predict_Ver1.1.csv";
	    File file= new File(fileName);
	    ArrayList<StudentVO> alunos = new ArrayList<StudentVO>();
	    Scanner inputStream;
	
	    try{
	        inputStream = new Scanner(file);
	
	        while(inputStream.hasNext())	{
	            String line= inputStream.next();
	            String[] values = line.split(",");
	            novoAluno(values, alunos);
	        }
	
	        inputStream.close();
	    }catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return alunos;
	}
	    
	    void novoAluno(String[] values, ArrayList<StudentVO> alunos)	{
	    	
	    	Vector<BigDecimal> aux= new Vector<BigDecimal>();
	    	//certifica-se que possui apenas números
	    	for(String value : values)	{
	    		if(!value.matches("^[a-zA-Z.]*$")) { 
	    			aux.add(new BigDecimal(value));
	    		}
	    	}
	    	
	    	if(aux.size() != 0)	{
	    		byte byte_aux = (aux.elementAt(7).intValue() == 1) ? (byte) 1 : (byte) 0;
	    		StudentVO aluno = new StudentVO(aux.elementAt(0).intValue(), aux.elementAt(1).intValue(),
	    						aux.elementAt(2).intValue(), aux.elementAt(3).intValue(), aux.elementAt(4), 
	    						aux.elementAt(5), aux.elementAt(6), byte_aux , aux.elementAt(8));
	    		alunos.add(aluno);
	    		aux.clear();
	    	}
	    }
}