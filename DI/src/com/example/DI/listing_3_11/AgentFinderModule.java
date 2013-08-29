package com.example.DI.listing_3_11;

import com.example.DI.AgentFinder;
import com.google.inject.AbstractModule;

/**
 * User: guorui
 * Date: 13-8-29
 * Time: 上午11:36
 */
public class AgentFinderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AgentFinder.class).toProvider(AgentFinderProvider.class);
    }
}
