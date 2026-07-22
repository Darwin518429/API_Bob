package SerieBobEsponja.BobEsponja.bds.test;

import SerieBobEsponja.BobEsponja.Exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class testService {
    @Autowired
    testRespository dao;
    public List<testEntity> getAllList(){
        return dao.findAll();
    }


    public List<testEntity> getAll()  {
      return  dao.findAll();
    }


}
