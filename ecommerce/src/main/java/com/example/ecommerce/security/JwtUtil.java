package com.example.ecommerce.security;

import io.jsonwebtoken.*;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtUtil {
    
    private final String SECRET_KEY = "mySecretKeyandItShouldBeLongEnough";

    public String generateToken(String username) {
        // Implement JWT token generation logic here
        return  Jwts.builder()
                .setSubject(username) //Aqui você está armazenando o nome do usuário
                .setIssuedAt(new Date())  //Data de emissão do token 'agora'
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //Token válido por 1 hora, exemplo: 1000ms * 60s * 60m = 1h
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)   //Assinatura do token isso é importante para garantir que o token não seja alterado.
                .compact(); //Compactação do token

    }
    
   public String extractUsername(String token) {
        
    return Jwts.parser() //Aqui você está configurando o parser do JWT para usar a chave secreta para validar a assinatura do token.
           .setSigningKey(SECRET_KEY) //Aqui você está configurando o parser do JWT para usar a chave secreta para validar a assinatura do token.
           .parseClaimsJws(token) //Aqui você está analisando o token JWT e extraindo as reivindicações (claims) contidas nele.
           .getBody() //Aqui você está obtendo o corpo do token, que contém as reivindicações (claims) do JWT.
           .getSubject(); //Aqui você está extraindo o assunto (subject) do token, que é o nome do usuário que foi armazenado durante a geração do token.
    }

    public boolean validateToken(String token, String username) {

        return username.equals(extractUsername(token)) && !isTokenExpired(token);
        //Essa parte do codigo realiza essas duas validações:
        //Se o username do token é igual ao fornecido
        //Se o token não está expirado
    }

    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(SECRET_KEY) //Usa a mesma chave secreta
                .parseClaimsJws(token) //Decodifica o token
                .getBody() //pegam a data de expiração do token
                .getExpiration(); //Obtém a data de expiração
        return expiration.before(new Date()); //Verifica se a data de expiração é anterior à data atual, ou seja, se o token está expirado
    }
}