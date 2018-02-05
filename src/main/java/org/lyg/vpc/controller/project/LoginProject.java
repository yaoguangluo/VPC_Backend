package org.lyg.vpc.controller.project;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface LoginProject {
    Map<String,Object> login(String uEmail, String uPassword) throws Exception;
}