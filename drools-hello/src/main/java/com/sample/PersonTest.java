package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class PersonTest {

	public static void main(String[] args) {
			KieServices ks = KieServices.Factory.get();
			KieContainer kc = ks.getKieClasspathContainer();
			KieSession kss = kc.newKieSession("ksession-rules");
			
			kss.insert(new Integer(1));
			kss.insert(new Person());
			kss.fireAllRules();

			System.out.println("end");
	}
}
