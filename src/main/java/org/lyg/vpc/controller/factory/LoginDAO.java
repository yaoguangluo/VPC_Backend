package org.lyg.vpc.controller.factory;

import org.apache.ibatis.annotations.Param;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrFull;
import org.lyg.vpc.view.UsrToken;

public interface LoginDAO {
    //select
    Usr selectUsrByUId(@Param("uId") Integer uId);

    UsrToken selectUsrTokenByUId(@Param("uId") Integer uId);

    UsrFull selectUsrFullByUId(@Param("uId") Integer uId);

    Usr selectUsrByUEmail(@Param("uEmail") String uEmail);

    //update
    void updateUsrByUId(@Param("uId") Integer uId,
                        @Param("uName") String uName,
                        @Param("uAge") String uAge,
                        @Param("uSex") String uSex,
                        @Param("uPhone") String uPhone,
                        @Param("uAddress") String uAddress,
                        @Param("uWeChat") String uWeChat,
                        @Param("uClass") String uClass,
                        @Param("uEmail") String uEmail,
                        @Param("uQq") String uQq);

    void updateUsrTokenByUId(@Param("uId") Integer uId,
                             @Param("uKey") String uKey,
                             @Param("uPassword") String uPassword,
                             @Param("uTime") long uTime);

    void insertUsr(@Param("uName") String uName,
                   @Param("uAge") String uAge,
                   @Param("uSex") String uSex,
                   @Param("uPhone") String uPhone,
                   @Param("uAddress") String uAddress,
                   @Param("uWeChat") String uWeChat,
                   @Param("uClass") String uClass,
                   @Param("uEmail") String uEmail,
                   @Param("uQq") String uQq);

    void insertUsroken(@Param("uId") Integer uId,
                       @Param("uKey") String uKey,
                       @Param("uPassword") String uPassword,
                       @Param("uTime") long uTime);
}