package com.example.DI;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

/**
 * Code for listing 3_8
 * User: guorui
 * Date: 13-8-28
 * Time: 下午5:02
 */
public class HollywoodServiceClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodService = injector.getInstance(HollywoodServiceGuice.class);
        List<Agent> agents = hollywoodService.getFriendlyAgents();
    }

}
