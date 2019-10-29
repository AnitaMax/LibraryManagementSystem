package cn.edu.jlu.ccst.zhy.librarymanagement.Service;

import cn.edu.jlu.ccst.zhy.librarymanagement.Dao.PersonalCenterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCenterService {
    @Autowired
    PersonalCenterDao personalCenterDao;
}
