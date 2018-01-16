package org.lyg.vpc.controller.businessImpl.companyImpl.departmentImpl.serviceImpl;

import org.lyg.vpc.controller.business.company.department.service.HelloService;
import org.lyg.vpc.controller.business.factory.workshop.task.SelectDAO;
import org.lyg.vpc.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private SelectDAO selectDAO;

    @Override
    public void testSample(int id) {
        // TODO Auto-generated method stub
        List<User> userList = selectDAO.selectUserListByAge(32);
        System.out.println(userList.get(0).getUserName());
    }
}