package ru.coffee.nostresso.security;

//import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtProviderOld {
//
//    @Value("${jwt.token.secret}")
//    private String secret;
//
//    @Value("${jwt.token.expired}")
//    private long validityInMilliseconds;
//
//    @Autowired
//    private IUserService userService;
//
//    @PostConstruct
//    protected void init() {
//        secret = Base64.getEncoder().encodeToString(secret.getBytes());
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    public String createToken(String username, Collection<? extends GrantedAuthority> authority) {
//
//        Claims claims = Jwts.claims().setSubject(username);
//        claims.put("role", authority);
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = this.userService.loadUserByUsername(getUsername(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getUsername(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        String bearerToken = req.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer_")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new RuntimeException("JWT token is expired or invalid");
//        }
//    }
}
