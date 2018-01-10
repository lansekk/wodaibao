package com.wodaibao.common.util;
/**
 * Copyright © 2015-2018 吉林省帮我贷信息技术有限公司
 * FileName: com.wodaibao.common.model.JwtUtil
 * Description : JwtUtil
 *
 */
import com.wodaibao.common.model.CommonConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    /**
     * 生成jwt token
     *
     * @param claims 存储参数
     * @param date   过期时间
     * @return token
     * @author C.K
     * @date 2018年01月04日
     */
    public static String generateToken(Map<String, Object> claims, Date date) {
        return Jwts.builder().setClaims(claims).setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, Base64.encodeBase64String(CommonConstants.JWT_SECRET.getBytes())).compact();
    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(Base64.encodeBase64String(CommonConstants.JWT_SECRET.getBytes())).parseClaimsJws(token)
                .getBody();
    }

}
