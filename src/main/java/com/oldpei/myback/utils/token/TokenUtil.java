package com.oldpei.myback.utils.token;

import java.util.Date;

import com.oldpei.myback.configs.Contants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
* Token Interceptor class.
* @author ben.zhang
* @version 1.0
*/
@Component
public class TokenUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtil.class);

    @Autowired
    private Contants contants;
    
    /**
     * create key
     * @param userId
     * @return
     */
    public String sign(String userId) {
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + contants.getExpiretime());
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userId", userId)
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(contants.getTokensecret()));
        } catch (Exception e) {
        	LOGGER.error("Token sign error : {}", e);
        }
        return token;
    }

    /**
     * sing key
     * @param token
     * @return
     */
    public boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(contants.getTokensecret())).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
