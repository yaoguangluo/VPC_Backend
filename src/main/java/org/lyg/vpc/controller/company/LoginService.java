package org.lyg.vpc.controller.company;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrToken;

public interface LoginService {
    Usr findUsrByUEmail(String uEmail);
    UsrToken findUsrTokenByUId(Integer uId);
    void updateUsrTokenByUId(Integer uId, String key, String uPassword, long uTime);
}
