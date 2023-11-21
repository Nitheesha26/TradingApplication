package com.signalHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @Mock
    private Algo mockAlgo;

    @Test
    void testHandleSignal() {
        Application application = new Application(mockAlgo);

        // Test signal 1
        application.handleSignal(1);

        Mockito.verify(mockAlgo).setUp();
        Mockito.verify(mockAlgo).setAlgoParam(1, 60);
        Mockito.verify(mockAlgo).performCalc();
        Mockito.verify(mockAlgo).submitToMarket();
        Mockito.verify(mockAlgo).doAlgo();

        // Reset the mock for the next test
        Mockito.reset(mockAlgo);

        // Test signal 2
        application.handleSignal(2);

        Mockito.verify(mockAlgo).reverse();
        Mockito.verify(mockAlgo).setAlgoParam(1, 80);
        Mockito.verify(mockAlgo).submitToMarket();
        Mockito.verify(mockAlgo).newAlgoMethod();
        Mockito.verify(mockAlgo).doAlgo();

        // Reset the mock for the next test
        Mockito.reset(mockAlgo);

        // Test signal 3
        application.handleSignal(3);

        Mockito.verify(mockAlgo).setAlgoParam(1, 90);
        Mockito.verify(mockAlgo).setAlgoParam(2, 15);
        Mockito.verify(mockAlgo).performCalc();
        Mockito.verify(mockAlgo).submitToMarket();
        Mockito.verify(mockAlgo).doAlgo();

        // Reset the mock for the next test
        Mockito.reset(mockAlgo);

        // Test default signal
        application.handleSignal(10); 

        // Verify that cancelTrades and doAlgo are called for the default case
        Mockito.verify(mockAlgo).cancelTrades();
        Mockito.verify(mockAlgo).doAlgo();
    }
}