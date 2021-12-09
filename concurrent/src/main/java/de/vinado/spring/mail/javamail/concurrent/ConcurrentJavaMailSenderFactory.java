package de.vinado.spring.mail.javamail.concurrent;

import de.vinado.spring.mail.javamail.JavaMailSenderDecoratorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.concurrent.ExecutorService;

/**
 * @author Vincent Nadoll
 */
@RequiredArgsConstructor
public class ConcurrentJavaMailSenderFactory implements JavaMailSenderDecoratorFactory {

    private final ExecutorService threadPool;

    @Override
    public ConcurrentJavaMailSender decorate(JavaMailSender delegate) {
        return new ConcurrentJavaMailSender(delegate, threadPool);
    }
}
