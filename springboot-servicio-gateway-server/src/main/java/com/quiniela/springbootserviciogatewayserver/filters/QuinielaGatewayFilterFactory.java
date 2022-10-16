package com.quiniela.springbootserviciogatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class QuinielaGatewayFilterFactory extends AbstractGatewayFilterFactory<QuinielaGatewayFilterFactory.Configuracion> {

private final Logger logger = LoggerFactory.getLogger(QuinielaGatewayFilterFactory.class);

    public QuinielaGatewayFilterFactory() {
        super(Configuracion.class);
    }

    @lombok.Data
    public class Configuracion {

        private String mensaje;
        private String cookievalor;
        private String cookienombre;

    }

    @Override
    public GatewayFilter apply(Configuracion config) {
        return ((exchange, chain) -> {


            logger.info("ejecutando pre gateway filter factory: " + config.mensaje);
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                Optional.ofNullable(config.cookievalor).ifPresent(cookie -> {
                    exchange.getResponse().addCookie(ResponseCookie.from(config.cookienombre,cookie).build());
                });
                logger.info("ejecutando post gateway filter factory" + config.mensaje);
            }));
        });
    }
}
