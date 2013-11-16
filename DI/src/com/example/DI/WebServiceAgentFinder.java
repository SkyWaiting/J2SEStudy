package com.example.DI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-8-28
 * Time: 下午3:26
 *
 */
public class WebServiceAgentFinder implements AgentFinder{

    /**
     * This method returns an empty list of agents for compilation sake
     *
     * @return An empty list of Agents
     */
    @Override
    public List<Agent> findAllAgents() {
        List<Agent> agents = new ArrayList<>();
        return agents;
    }
}
