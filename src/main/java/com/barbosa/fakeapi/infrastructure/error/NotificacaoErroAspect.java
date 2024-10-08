package com.barbosa.fakeapi.infrastructure.error;

import com.barbosa.fakeapi.business.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class NotificacaoErroAspect {

    private final EmailService emailService;

    @Pointcut("@within(com.barbosa.fakeapi.infrastructure.error.NotificacaoErro) || @annotation(com.barbosa.fakeapi.infrastructure.configs.error.NotificacaoErro)")
    public void notificacaoErroPointCut() {
    }

    @AfterThrowing(pointcut = "notificacaoErroPointCut()", throwing = "e")
    public void notificacaoErro(final Exception e) {
        emailService.enviaEmailExcecao(e);
    }

}
