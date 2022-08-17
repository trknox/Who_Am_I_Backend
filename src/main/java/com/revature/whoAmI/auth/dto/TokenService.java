package com.revature.whoAmI.auth.dto;

import com.revature.whoAmI.auth.dto.response.Principal;
import com.revature.whoAmI.user.User;
import com.revature.whoAmI.user.UserService;
import com.revature.whoAmI.util.annotations.Inject;
import com.revature.whoAmI.util.custom_exception.InvalidRequestException;
import com.revature.whoAmI.util.custom_exception.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class TokenService {
    @Inject
    private JwtConfig jwtConfig;
    private UserService userService;

    public TokenService() {
        super();
    }

    @Inject
    @Autowired
    public TokenService(JwtConfig jwtConfig, UserService userService) {
        this.jwtConfig = jwtConfig;
        this.userService = userService;
    }






    public String generateToken(Principal subject) {
        long now = System.currentTimeMillis();
        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(subject.getId())
                .setIssuer("TrailMates")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()))
                .setSubject(subject.getUsername())
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        return tokenBuilder.compact();
    }

    public Principal extractRequesterDetails(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            return new Principal(claims.getId(), claims.getSubject());
        } catch (Exception e) {
            return null;
        }
    }

    public Principal noTokenThrow(String token){
        Principal requester = extractRequesterDetails(token);
        if(requester == null) throw new UnauthorizedException("No authorization found");//401
        User user = userService.getUserByUsername(requester.getUsername());
        if(user == null) throw new InvalidRequestException("Invalid user token");//404
        //if(!user.getIsActive()) throw new AuthenticationException("Inactive user token");//403
        return requester;
    }
}