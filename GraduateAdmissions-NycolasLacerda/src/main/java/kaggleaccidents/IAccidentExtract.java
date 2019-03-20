package kaggleaccidents;

import java.util.List;

public interface IAccidentExtract {

  public void add(AccidentVO accidentVO);
  public  void delete(String id);
  public List<AccidentVO> list();
  public boolean update(String id);

}
