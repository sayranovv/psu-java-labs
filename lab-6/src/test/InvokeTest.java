package test;

import annotations.Invoke;
import entities.InvokeDemo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Task1Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit тест, проверяющий обработку аннотации @Invoke.
 */
public class InvokeTest {

    private InvokeDemo demo;
    private Task1Service service;

    @BeforeEach
    void setUp() {
        demo = new InvokeDemo();
        service = new Task1Service();
    }

    @Test
    void invokesAnnotatedMethodsWithoutException() {
        List<Object> results = service.invokeAnnotatedMethods(demo);
        assertFalse(results.isEmpty(), "Должен быть хотя бы один вызванный метод");
        assertTrue(demo.wasInvoked(), "Флаг вызова должен быть установлен");
        assertEquals("Hello from @Invoke method", results.get(0));
    }
}

