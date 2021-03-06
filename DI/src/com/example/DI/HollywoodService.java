package com.example.DI;

import java.util.ArrayList;
import java.util.List;

/**
 *  Code for listing 3_2
 * User: guorui
 * Date: 13-8-28
 * Time: 下午3:39
 *
 */
public class HollywoodService {

    public static List<Agent> getFriendlyAgents(){
        AgentFinder finder = new SpreadsheetAgentFinder();
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents =filterAgents(agents,"Java Developers");
        return friendlyAgents;
    }

    public static List<Agent> filterAgents(List<Agent> agents,String agentType){
        List<Agent> filterAgents = new ArrayList<>();
        for (Agent agent : agents){
            if (agent.getType().equals("Java Developers")){
                filterAgents.add(agent);
            }
        }
        return filterAgents;
    }
}
