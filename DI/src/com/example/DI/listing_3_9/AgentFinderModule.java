package com.example.DI.listing_3_9;

import com.example.DI.AgentFinder;
import com.example.DI.WebServiceAgentFinder;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Code for listing 3_9
 * User: guorui
 * Date: 13-8-29
 * Time: 上午10:54
 */
public class AgentFinderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AgentFinder.class).annotatedWith(Names.named("primary")).to(WebServiceAgentFinder.class);
    }
}
