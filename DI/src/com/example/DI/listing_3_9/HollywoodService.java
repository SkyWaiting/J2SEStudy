package com.example.DI.listing_3_9;

import com.example.DI.AgentFinder;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.lang.model.element.Name;

/**
 * Code for listing 3_9
 * User: guorui
 * Date: 13-8-29
 * Time: 上午11:00
 */
public class HollywoodService {

    private AgentFinder finder = null;

    @Inject
    public HollywoodService(@Named("primary")AgentFinder finder){
        this.finder = finder;
    }

}
