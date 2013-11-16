package com.example.DI;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * User: guorui
 * Date: 13-8-28
 * Time: 下午4:59
 */
public class HollywoodServiceGuice {
    private AgentFinder finder = null;

    @Inject
    public HollywoodServiceGuice(AgentFinder finder) {
        this.finder = finder;
    }

    public List<Agent> getFriendlyAgents() {
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
        return friendlyAgents;
    }

    public List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filterAgents = new ArrayList<>();
        for (Agent agent : agents) {
            if (agent.getType().equals("Java Developers")) {
                filterAgents.add(agent);
            }
        }
        return filterAgents;
    }
}
