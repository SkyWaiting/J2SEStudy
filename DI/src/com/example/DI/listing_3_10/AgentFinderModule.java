package com.example.DI.listing_3_10;

import com.example.DI.AgentFinder;
import com.example.DI.SpreadsheetAgentFinder;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;

/**
 * Code for listing 3_10
 * User: guorui
 * Date: 13-8-29
 * Time: 上午11:23
 */
public class AgentFinderModule extends AbstractModule{

    @Override
    protected void configure() {

    }

    @Provides
    AgentFinder provideAgentFinder(){
        SpreadsheetAgentFinder finder = new SpreadsheetAgentFinder();
        finder.setType("Excel97");
        finder.setPath("c:/temp/agents.xls");
        return finder;
    }
}
