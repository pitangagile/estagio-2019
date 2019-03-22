package kagglestudents;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;

    public StudentNotebook(ExtractStudent extractStudent) {
        this.extractStudent = extractStudent;
        this.studentNotebookList = extractStudent.load();
    }

    public Boolean isAnApprovedUserByID(Integer id) {
        for(StudentVO aluno : this.studentNotebookList)	{
        	if(aluno.getId().equals(id))	{
        		return aluno.isApproved();
        	}
        }
        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }
    
    public Boolean isAnApprovedUserbyCgpa(BigDecimal cgpa) {
    	for(StudentVO aluno : this.studentNotebookList)	{
    		if(aluno.getCgpa().doubleValue() == cgpa.doubleValue())	{
    			return aluno.isApproved();
    		}
    	}
    	throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }

    public Boolean isAnApprovedUserbyLor(BigDecimal lor) {
    	for(StudentVO aluno: this.studentNotebookList) {
    		if(aluno.getLor().doubleValue() == lor.doubleValue()) {
    			return aluno.isApproved();
    		}
    	}
    	throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }
    
    public BigDecimal approvalPercentageBySop(BigDecimal value, String compare) {
		
		double count = 0;
		switch(compare) {
		
		case ">":	
			for(StudentVO student : studentNotebookList)	{
				if(student.getSop().doubleValue() > value.doubleValue())	{
					count++;
				}
			break;
		}
		case "<":
			for(StudentVO student : studentNotebookList)	{
				if(student.getSop().doubleValue() < value.doubleValue())	{
					count++;
				}
			}
			break;
		case "=":
			for(StudentVO student : studentNotebookList)	{
				if(student.getSop().doubleValue() == value.doubleValue())	{
					count++;
				}
			}
			break;
		}
		double aux = studentNotebookList.size();
		return BigDecimal.valueOf(count).divide(BigDecimal.valueOf(aux));
	}

	public BigDecimal approvalPercentageByLor(BigDecimal value, String compare) {
			
		double count = 0;
		switch(compare) {
		
		case ">":	
			for(StudentVO student : studentNotebookList)	{
				if(student.getLor().doubleValue() > value.doubleValue())	{
					count++;
				}
			break;
		}
		case "<":
			for(StudentVO student : studentNotebookList)	{
				if(student.getLor().doubleValue() < value.doubleValue())	{
					count++;
				}
			}
			break;
		case "=":
			for(StudentVO student : studentNotebookList)	{
				if(student.getLor().doubleValue() == value.doubleValue())	{
					count++;
				}
			}
			break;
		}
		double aux = studentNotebookList.size();
		return BigDecimal.valueOf(count).divide(BigDecimal.valueOf(aux));
	}
	
	public BigDecimal approvalPercentageByCgpa(BigDecimal value, String compare) {
		
		double count = 0;
		switch(compare) {
		
		case ">":	
			for(StudentVO student : studentNotebookList)	{
				if(student.getCgpa().doubleValue() > value.doubleValue())	{
					count++;
				}
			break;
		}
		case "<":
			for(StudentVO student : studentNotebookList)	{
				if(student.getCgpa().doubleValue() < value.doubleValue())	{
					count++;
				}
			}
			break;
		case "=":
			for(StudentVO student : studentNotebookList)	{
				if(student.getCgpa().doubleValue() == value.doubleValue())	{
					count++;
				}
			}
			break;
		}
		double aux = studentNotebookList.size();
		return BigDecimal.valueOf(count).divide(BigDecimal.valueOf(aux));
	}
	    
}