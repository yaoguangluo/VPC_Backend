package org.lyg.vpc.process.projectImpl;

import com.google.gson.Gson;
import org.lyg.common.utils.StringUtil;
import org.lyg.common.utils.TokenUtil;
import org.lyg.vpc.controller.company.LoginService;
import org.lyg.vpc.controller.project.LoginProject;
import org.lyg.vpc.transaction.TransactionDelegate;
import org.lyg.vpc.view.Token;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginProjectImpl implements LoginProject {
    @Autowired
    private LoginService loginService;
    @Autowired
    private TransactionDelegate transactionDelegate;

    @Override
    public Map<String, Object> login(String uEmail, String uPassword) throws Exception {
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
        transactionDelegate.transactionUpdateUsrTokenByUId(usr.getUId(), token.getUKey(), password, token.getUTime());
        return out;
    }
}