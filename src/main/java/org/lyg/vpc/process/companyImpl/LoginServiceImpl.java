package org.lyg.vpc.process.companyImpl;

import org.lyg.vpc.controller.company.LoginService;
import org.lyg.vpc.controller.factory.LoginDAO;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public Usr findUsrByUEmail(String uEmail) {
        return null;
    }

    @Override
    public UsrToken findUsrTokenByUId(Integer uId) {
        return null;
    }

    @Override
    public void updateUsrTokenByUId(Integer uId, String key, String uPassword, long uTime) {
    }
}