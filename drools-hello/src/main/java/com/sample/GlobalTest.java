package com.sample;

import java.util.ArrayList;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class GlobalTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.getKieClasspathContainer();
		KieSession kss = kc.newKieSession("ksession-rules");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		kss.setGlobal("gList", list);
		kss.insert(new Person());
		kss.insert(new Person());
		kss.fireAllRules();
		
		System.out.printf("list size is %d", list.size());

	}

}
