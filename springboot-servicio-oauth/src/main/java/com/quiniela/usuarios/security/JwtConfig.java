package com.quiniela.usuarios.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;


@Component
public class JwtConfig {


    private String clavePrivada="-----BEGIN PRIVATE KEY-----\r\n"
    		+ "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCi6NqxKDPqL8Ug\r\n"
    		+ "AdrYEbuOE/oYPtwKBp4ecwVJHggfZcyh7guRRHd0bQStu1l9E1vMOXXKwssoCl70\r\n"
    		+ "6U7RY04JUYPetOhRBA7fJx0zOwxWqgROvmFzIZokyNWlsS1a9HhJQYg88Mn8FcfK\r\n"
    		+ "EtrDcDO2n9WLL8//636y/kPFx+o1etqBX8fqzGA5PwjI0kmutvqH+vC7JIFggALs\r\n"
    		+ "vemZUtbnSLDEpbJBBOB5YrY7BExJT7fX2w64nOk4EKAXG1Iq4JqtpD/2n7iK95hK\r\n"
    		+ "06ZECAMKZNX5TYwVNJMqfXMd2OXaBjkNZA0NHU8wshlslcOormtGyfdhcH2fM8N1\r\n"
    		+ "CFbpVKlRAgMBAAECggEAHDN1EC/mdMbaOAU6Lic7sYexxpqzGqU0oA7HPnYNb+n+\r\n"
    		+ "d5WuuPICP8xTgAOrpSRBwuO7iWMZKhBJidoNg9/N9Xz/+ACXKtcp/+VUf7bcFvCN\r\n"
    		+ "mFgKpJSPi4icu3clY9ZoMD5A6FPCk3ntwQRsjGKTAS1AGT0oo6PPpgqwDr/hwmoA\r\n"
    		+ "TvfVB7l9adk0fBtOyp+WjUNSTNZ7gHvsc627B4EJOsZ71HqxAHC6Xrh5UStXWmsq\r\n"
    		+ "sHR1LhymZ92uOcCuPVcO1ZRkVl89Uz3meHX6sFVjQyyBp6bscks01oaYVdAtYZ5V\r\n"
    		+ "EsjOgagwpLKkrrmZedPrDtTQ1YNCU8Bnl66/Xwb88QKBgQDMgFJce8Tq7nGj+YvY\r\n"
    		+ "mIl6O821Nv85euRy2FGbaA1mmwbtGGQ74CnWBO7ySwXyAWjcmKjHAt2r2gVhZ8Zg\r\n"
    		+ "zc4hZgr0hOMoAQpWbas7umu1+Dmfz3AQPVmF4hXr97sKWoTto8ehGTaqbtzlDGCA\r\n"
    		+ "nWfLNcAd0ftB4QHG7TjeQYqJTQKBgQDL7zkPd/+Oq5HWU8JNqT91fgaQ4ELJyCaW\r\n"
    		+ "VtmvQwdHME4pVD2MPakKgzDQbImcsfIRnU/NqmDLIbQBqMpCKxtFKaZiYCsBLCQ7\r\n"
    		+ "bLqWwgV2jisxYE0tpolRhoQe9QDsuEMz3+ZFOIFjOxz/c9sWbGMDveludZ5w0Mt9\r\n"
    		+ "CUfggTH+FQKBgQDCKqCIoReB/G23xAuM1p/JiBizk4lW+SEJDezGAlCe+FjmKv+Y\r\n"
    		+ "fikaxMpfEO6PLdlzghrWAhmYvsPXDSIk7aNmwK1sJvRLGlnHYA9yAXmdaBbGbr23\r\n"
    		+ "HZjvbo9j4W4c0X9e5t93TSpDPknLzCmgVFOldN55MdM/ZLU8PCZ/mHlCDQKBgClT\r\n"
    		+ "vEt/NOHTsQUvCiQ01TBZLrlzSPWdQvyacxjKS5JInr5PXP2rjTMdLOo/5I9FnFmn\r\n"
    		+ "eIGkMmNX3COt8fcAx1D3xMkQ1gYxzNHiEdn1Tagd3XDvJBTJN/C2gtXHLr3KBYxg\r\n"
    		+ "pkiGz+mtFA5Miyx7IIGkncaNvWL9XQ9krxU2+UuVAoGASmL2d0v0G30tGOXsNr4e\r\n"
    		+ "0fOAoVPdWYVrUbjaBE3jUyFNtTUCyu3+x5spuY38S/O8tG6hC42U8FqamGdw+Fiw\r\n"
    		+ "8SyV0PlcO9+QqpQsMbGl+2nnDaTOaKqTVjG1l2JKpVGYj1gUCozN42g6j3l9Pa/u\r\n"
    		+ "6jAsBw/ohydi3UMI38E/WbM=\r\n"
    		+ "-----END PRIVATE KEY-----";

    private String clavePublica="-----BEGIN PUBLIC KEY-----\r\n"
    		+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoujasSgz6i/FIAHa2BG7\r\n"
    		+ "jhP6GD7cCgaeHnMFSR4IH2XMoe4LkUR3dG0ErbtZfRNbzDl1ysLLKApe9OlO0WNO\r\n"
    		+ "CVGD3rToUQQO3ycdMzsMVqoETr5hcyGaJMjVpbEtWvR4SUGIPPDJ/BXHyhLaw3Az\r\n"
    		+ "tp/Viy/P/+t+sv5DxcfqNXragV/H6sxgOT8IyNJJrrb6h/rwuySBYIAC7L3pmVLW\r\n"
    		+ "50iwxKWyQQTgeWK2OwRMSU+319sOuJzpOBCgFxtSKuCaraQ/9p+4iveYStOmRAgD\r\n"
    		+ "CmTV+U2MFTSTKn1zHdjl2gY5DWQNDR1PMLIZbJXDqK5rRsn3YXB9nzPDdQhW6VSp\r\n"
    		+ "UQIDAQAB\r\n"
    		+ "-----END PUBLIC KEY-----";

    public JwtConfig() {
    }

    public String getClavePrivada() {
        return clavePrivada;
    }

    public String getClavePublica() {
        return clavePublica;
    }

    @Bean
    public KeyPair keyPair() {
    	byte[] privateKeyBytes = Base64.getDecoder().decode(clavePrivada
                .replaceAll("\\n|\\r", "")
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", ""));
        byte[] publicKeyBytes = Base64.getDecoder().decode(clavePublica
                .replaceAll("\\n|\\r", "")
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", ""));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            return new KeyPair(publicKey, privateKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

}
