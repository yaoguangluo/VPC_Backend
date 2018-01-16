package org.lyg.vpc.controller.businessImpl.companyImpl.departmentImpl.serviceImpl;

import org.lyg.vpc.controller.business.company.department.service.HelloService;
import org.lyg.vpc.controller.business.factory.workshop.task.SelectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloServiceImpl implements HelloService {
    @Autowired
    private SelectDAO selectDAO;

    @Override
    public void testSample(int id) {
        // TODO Auto-generated method stub
        selectDAO.selectTableById(id);
    }
}