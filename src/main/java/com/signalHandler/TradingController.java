package com.signalHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class TradingController {

    @Autowired
    private Application application;

    @RequestMapping("/receiveSignal/{signal}")
    public void receiveSignal(@PathVariable int signal) {
        application.handleSignal(signal);
    }
}
