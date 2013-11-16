package com.example.DI;

import com.google.inject.AbstractModule;

/**
 * Code for listing 3_7
 * User: guorui
 * Date: 13-8-28
 * Time: 下午4:55
 */
public class AgentFinderModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(AgentFinder.class).to(WebServiceAgentFinder.class);
    }

}
