package com.dm3.security.services;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;





@Service
public class JwtService {

    private final String SECRET_KEY = "mysecretkeycreatedforjwtuniqueandsecure";

public String gerarToken(String email) {    

    return Jwts.builder()
            .setSubject(email)
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();

}


}
