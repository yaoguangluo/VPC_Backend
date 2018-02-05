package org.lyg.common.utils;

import org.lyg.vpc.view.Token;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrToken;
import java.util.Date;

public class TokenUtil {
    public static Token getNewTokenFromUsrAndUsrToken(Usr usr, UsrToken usrToken) throws Exception {
        String key = String.valueOf(Double.valueOf(Math.random() * 10000000).intValue());
        String mPassword = StringUtil.EncoderByMd5(key, usrToken.getUPassword(), 8);
        Token token = new Token();
        token.setUEmail(usr.getUEmail());
        token.setUKey(key);
        token.setUTime(new Date().getTime());
        token.setMPassword(mPassword);
        return token;
    }

    public static String getMD5Password(String uPassword) throws Exception {
       return StringUtil.EncoderByMd5("Author:Yaoguang Luo", uPassword, 8);
    }
}