package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

/**
 * Created by Louz on 2015/10/29.
 */
public class RuleSelectTest {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-ruleselect");

        Person p = new Person();
        kSession.insert(p);
        kSession.fireAllRules(new AgendaFilter() {
            public boolean accept(Match match) {
                System.out.println(match.getRule().getName());

                if (match.getRule().getName().equals("rule1")) {
                    return true;
                } else {
                    return false;
                }

            }
        });
    }
}
