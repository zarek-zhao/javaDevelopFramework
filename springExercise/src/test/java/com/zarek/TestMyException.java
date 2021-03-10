package com.zarek;

import org.junit.Test;

import javax.security.auth.login.LoginException;

/**
 * @author zhao
 * @date 2021/3/2 11:08
 */
public class TestMyException {

    @Test
    public void testLoginException() throws LoginException
    {

        throw new LoginException("登陆失败");

    }

}
