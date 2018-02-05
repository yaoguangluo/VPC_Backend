package org.lyg.vpc.transaction;

import org.lyg.vpc.controller.company.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionDelegate {
    @Autowired
    private LoginService loginService;

    public void transactionUpdateUsrTokenByUId(Integer uId, String key, String uPassword, long uTime) {
        loginService.updateUsrTokenByUId(uId, key, uPassword, uTime);
    }
}

