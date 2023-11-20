package com.signalHandler;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Component
class Application implements SignalHandler {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Application.class);
	
	private final Algo algo;

    @Autowired
    public Application(Algo algo) {
        this.algo = algo;
    }

    public void handleSignal(int signal) {
    	LOGGER.info("Handling signal: {}", signal);
        switch (signal) {
            case 1:
                executeSignal1();
                break;

            case 2:
                executeSignal2();
                break;

            case 3:
                executeSignal3();
                break;

            default:
            	handleUnknownSignal(signal);
                break;
        }

        algo.doAlgo();
    }

    private void executeSignal1() {
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
    }

    private void executeSignal2() {
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        algo.newAlgoMethod();
    }

    private void executeSignal3() {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }
    
    private void handleUnknownSignal(int signal) {
        LOGGER.warn("Unknown signal received: {}", signal);
        algo.cancelTrades();
    }
}

