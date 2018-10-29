package com.ticketopia.util;

import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ticketopia.beans.CustomerInfo;

public class ServletSupport {
	public static CustomerInfo convertToken(HttpServletRequest request) {
		
		String token = request.getParameter("token");
		Algorithm algorithm = Algorithm.HMAC256("secretPassword123");
		JWTVerifier verifier = JWT.require(algorithm).withIssuer("Shadow").build();
		DecodedJWT jwt = verifier.verify(token);
		CustomerInfo ci = new CustomerInfo(jwt.getClaim("userEmail").asString(), jwt.getClaim("displayName").asString(), jwt.getClaim("userFName").asString(), jwt.getClaim("userLName").asString(), jwt.getClaim("accumulatedPoints").asInt(), jwt.getClaim("role").asInt(), jwt.getClaim("userAddress").asString(), jwt.getClaim("userCity").asString(), jwt.getClaim("userState").asString(), jwt.getClaim("userZip").asInt(), null);
		return ci;
	}
	
}
