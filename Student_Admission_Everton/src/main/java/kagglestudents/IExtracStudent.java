package kagglestudents;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IExtracStudent {

    public List<StudentVO> load() throws IOException;
}
