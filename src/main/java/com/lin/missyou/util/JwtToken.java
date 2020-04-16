/**
 * @作者 leokkzhang
 * @创建时间 2020/4/16 22:50
 */
package com.lin.missyou.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;

public class JwtToken {


    private static String jwtKey;

    @Value("${missyou.security.jwt-key}")
    public void setJwtKey(String jwtKey){
        JwtToken.jwtKey = jwtKey;
    }

    public static String makeToken(Long uid, Integer scope){
        return null;
    }

    private static String getToken(Long uid ,Integer scope){

        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);

        String jwt = JWT.create()
                .withClaim("uid",uid)
                .withClaim("scope",scope)
//                .withExpiresAt()
                .sign(algorithm);
        return jwt;

    }
}
