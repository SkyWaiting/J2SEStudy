package com.example.DI;

import java.util.ArrayList;
import java.util.List;

/**
 * Code for listing 3_3
 * User: guorui
 * Date: 13-8-28
 * Time: 下午4:18
 */
public class HollywoodServiceWithFactory {

    public static List<Agent> getFriendlyAgents(String agentFinderType){
        AgentFinderFactory factory = AgentFinderFactory.getInstance();
        AgentFinder finder = factory.getAgentFinder(agentFinderType);
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents,"Java Developers");
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
