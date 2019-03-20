package kagglestudents;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;

    public StudentNotebook(ExtractStudent extractStudent) {
        this.extractStudent = extractStudent;
        this.studentNotebookList = extractStudent.load();
    }

    public Boolean isAnApprovedUser(Integer id) {

        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getId().equals(id)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");



    }

   public Boolean isAnApprovedUserGivenCgpaLor(String atribute, BigDecimal value){

      for(StudentVO studentVO:this.studentNotebookList){
            switch (atribute.toUpperCase()){
              case "CGPA": if(studentVO.getCgpa().compareTo(value) == 0)
                            return studentVO.isApproved();
                            else
                              continue;
              case "LOR": if(studentVO.getLor().compareTo(value)==0)
                              return studentVO.isApproved();
                          else
                            continue;
              default:throw new NoSuchElementException("Nenhuma operação encontrada");

            }
      }

     throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
   }


   public double percentageApprovedUserCgpa(String op, BigDecimal value){
     //Op {<,>,=}
      List<StudentVO> list = new ArrayList<>();

      //Add in the aux list, all students if getChance is Approved, and CGPA is equals, smaller or greater than value passed, given op passed as parameter
      for(StudentVO studentVO: this.studentNotebookList){
        if(studentVO.isApproved()){
          switch (op){
            case "<": if(studentVO.getCgpa().compareTo(value) < 0){
                        list.add(studentVO);
                        continue;
                        }else
                        continue;
            case ">": if(studentVO.getCgpa().compareTo(value) > 0) {
                          list.add(studentVO);
                          continue;
                        }else
                          continue;
            case "=": if(studentVO.getCgpa().compareTo(value) == 0) {
                          list.add(studentVO);
                          continue;
                        }else
                        continue;
            default: throw new NoSuchElementException("Nenhuma operação encontrada");
          }
        }

      }
      double percentage = (new Double(list.size())/new Double(this.studentNotebookList.size()))*100.0;
      return percentage;


   }


  public double percentageApprovedUserLor(String op, BigDecimal value){
    //Op {<,>,=}
    List<StudentVO> list = new ArrayList<>();

    //Add in the aux list, all students if getChance is Approved, and CGPA is equals, smaller or greater than value passed, given op passed as parameter
    for(StudentVO studentVO: this.studentNotebookList){
      if(studentVO.isApproved()){
        switch (op){
          case "<": if(studentVO.getLor().compareTo(value) < 0){
            list.add(studentVO);
            continue;
          }else
            continue;
          case ">": if(studentVO.getLor().compareTo(value) > 0) {
            list.add(studentVO);
            continue;
          }else
            continue;
          case "=": if(studentVO.getLor().compareTo(value) == 0) {
            list.add(studentVO);
            continue;
          }else
            continue;
          default: throw new NoSuchElementException("Nenhuma operação encontrada");
        }
      }

    }
    double percentage = (new Double(list.size())/new Double(this.studentNotebookList.size()))*100.0;
    return percentage;

  }


  public double percentageApprovedUserSop(String op, BigDecimal value){
    //Op {<,>,=}
    List<StudentVO> list = new ArrayList<>();

    //Add in the aux list, all students if getChance is Approved, and CGPA is equals, smaller or greater than value passed, given op passed as parameter
    for(StudentVO studentVO: this.studentNotebookList){
      if(studentVO.isApproved()){
        switch (op){
          case "<": if(studentVO.getSop().compareTo(value) < 0){
            list.add(studentVO);
            continue;
          }else
            continue;
          case ">": if(studentVO.getSop().compareTo(value) > 0) {
            list.add(studentVO);
            continue;
          }else
            continue;
          case "=": if(studentVO.getSop().compareTo(value) == 0) {
            list.add(studentVO);
            continue;
          }else
            continue;
          default: throw new NoSuchElementException("Nenhuma operação encontrada");
        }
      }

    }
    double percentage = (new Double(list.size())/new Double(this.studentNotebookList.size()))*100.0;
    return percentage;

  }




}
