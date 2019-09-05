package top.chao.util;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import top.chao.entity.User;

/*
 * 标准中注册的声明
 * iss: jwt签发者
 * sub: jwt所面向的用户
 * aud: 接收jwt的一方
 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
 * nbf: 定义在什么时间之前，该jwt都是不可用的.
 * iat: jwt的签发时间
 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
 */
public class JwtUtil {
	//设置过期时间
	private static final long EXPIRE_TIME = 15 * 60 * 1000;
	//服务端的私钥secret,在任何场景都不应该流露出去
	private static final String TOKEN_SECRET = "zhengchao";

	/**
	 * 生成签名，15分钟过期
	 * @param **User**
	 * @param **password**
	 * @return
	 */
	public static String createToken(User user) {
	    try {
	        // 设置过期时间
	        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
	        // 私钥和加密算法
	        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
	        // 设置头部信息
	        Map<String, Object> header = new HashMap<>(2);
	        header.put("typ", "JWT");
	        header.put("alg", "HS256");
	        // 返回token字符串
	        return JWT.create()
	                .withHeader(header)
	                .withClaim("aud", user.getName())
	                .withClaim("uid", user.getId())
	                .withExpiresAt(date)
	                .sign(algorithm);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/**
	 * 检验token是否正确
	 * @param **token**
	 * @return
	 */
	public static boolean isVerify(String token){
	    try {
	        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
	        JWTVerifier verifier = JWT.require(algorithm).build();
	        verifier.verify(token);
	        return true;
	    } catch (Exception e){
	        return false;
	    }
	}
	
	/**
	 *从token解析出uid信息
	 * @param token
	 * @param key
	 * @return
	 */
	public static int parseTokenUid(String token) {
		DecodedJWT jwt = JWT.decode(token);
		return jwt.getClaim("uid").asInt();
	}
	
	/**
	 *从token解析出aud信息
	 * @param token
	 * @param key
	 * @return
	 */
	public static String parseTokenAud(String token) {
		DecodedJWT jwt = JWT.decode(token);
		return jwt.getClaim("aud").asString();
	}

}
