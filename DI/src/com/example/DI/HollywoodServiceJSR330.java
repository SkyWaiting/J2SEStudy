package com.example.DI;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Code for listing 3_5
 * User: guorui
 * Date: 13-8-28
 * Time: 下午4:38
 */
public class HollywoodServiceJSR330 {

    @Inject
    public static List<Agent> getFriendlyAgents(AgentFinder finder){
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
        return friendlyAgents;
    }

    public static List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filterAgents = new ArrayList<>();
        for (Agent agent : agents) {
            if (agent.getType().equals("Java Developers")) {
                filterAgents.add(agent);
            }
        }
        return filterAgents;
    }
}
