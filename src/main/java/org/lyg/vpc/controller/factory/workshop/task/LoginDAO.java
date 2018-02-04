package org.lyg.vpc.controller.factory.workshop.task;

import org.apache.ibatis.annotations.Param;
import org.lyg.vpc.view.Usr;
import org.lyg.vpc.view.UsrFull;
import org.lyg.vpc.view.UsrToken;

public interface LoginDAO {
    //select
    Usr selectUsrById(@Param("uId") Integer uId);

    UsrToken selectUsrTokenById(@Param("uId") Integer uId);

    UsrFull selectUsrFullById(@Param("uId") Integer uId);

    //update
    void updateUsrById(@Param("uId") Integer uId,
                       @Param("uName") String uName,
                       @Param("uAge") String uAge,
                       @Param("uSex") String uSex,
                       @Param("uPhone") String uPhone,
                       @Param("uAddress") String uAddress,
                       @Param("uWeChat") String uWeChat,
                       @Param("uClass") String uClass,
                       @Param("uEmail") String uEmail,
                       @Param("uQq") String uQq);

    void updateUsrTokenById(@Param("uId") Integer uId,
                            @Param("uKey") String uKey,
                            @Param("uPassword") String uPassword,
                            @Param("uToken") String uToken,
                            @Param("uTime") String uTime);

    void insertUsr(@Param("uName") String uName,
                   @Param("uAge") String uAge,
                   @Param("uSex") String uSex,
                   @Param("uPhone") String uPhone,
                   @Param("uAddress") String uAddress,
                   @Param("uWeChat") String uWeChat,
                   @Param("uClass") String uClass,
                   @Param("uEmail") String uEmail,
                   @Param("uQq") String uQq);

    void insertUsrokenById(@Param("uId") Integer uId,
                           @Param("uKey") String uKey,
                           @Param("uPassword") String uPassword,
                           @Param("uToken") String uToken,
                           @Param("uTime") String uTime);
}