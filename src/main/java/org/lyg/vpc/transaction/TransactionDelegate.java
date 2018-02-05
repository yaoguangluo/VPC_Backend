package org.lyg.vpc.transaction;

import com.google.gson.Gson;
import org.lyg.common.utils.StringUtil;
import org.lyg.common.utils.TokenUtil;
import org.lyg.vpc.controller.company.LoginService;
import org.lyg.vpc.view.Token;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class TransactionDelegate {
    @Autowired
    private LoginService loginService;

    public  Map<String, Object> transactionLogin(String uEmail, String uPassword)throws Exception {
        Usr usr = loginService.findUsrByUEmail(uEmail);
        UsrToken usrToken = loginService.findUsrTokenByUId(usr.getUId());
        //internal code
        String password = TokenUtil.getMD5Password(uPassword);
        if (!password.equals(usrToken.getUPassword())) {
            return null;
        }
        //create new token
        Token token = TokenUtil.getNewTokenFromUsrAndUsrToken(usr, usrToken);
        String json = new Gson().toJson(token);
        String jsonToken = StringUtil.encode(json);
        Map<String, Object> out = new HashMap<>();
        out.put("userToken", jsonToken);
        out.put("userEmail", uEmail);
        loginService.updateUsrTokenByUId(usr.getUId(), token.getUKey(), password, token.getUTime()/1000);
        return out;
    }
}

