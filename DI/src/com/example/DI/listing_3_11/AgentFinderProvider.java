package com.example.DI.listing_3_11;


import com.example.DI.AgentFinder;
import com.example.DI.SpreadsheetAgentFinder;
import com.google.inject.Provider;

/**
 * User: guorui
 * Date: 13-8-29
 * Time: 上午11:37
 */
public class AgentFinderProvider implements Provider<AgentFinder> {

    @Override
    public AgentFinder get() {
        SpreadsheetAgentFinder finder = new SpreadsheetAgentFinder();
        finder.setType("Excel97");
        finder.setPath("c:/temp/agents.xls");
        return finder;
    }
}
