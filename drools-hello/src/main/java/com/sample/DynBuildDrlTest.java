package com.sample;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.*;

/**
 * Created by Louz on 2015/10/28.
 */
public class DynBuildDrlTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        for (int i = 1; i <= 20; i++) {
            String myRule = "package com.aa\n" +
                    "\n" +
                    "//list any import classes here.\n" +
                    "import com.sample.Person;\n" +
                    "\n" +
                    "//declare any global variables here\n" +
                    "\n" +
                    "rule \"Your First Rule\"\n" +
                    "\n" +
                    "    when\n" +
                    "        p : Person()\n" +
                    "    then\n" +
                    "        System.out.println(\"this is the " + i + "th time\");\n" +
                    "\n" +
                    "end";

            runRule(myRule);

            Thread.sleep(3000);
        }
    }

    private static void runRule(String myRule) {
        System.out.println(myRule);
        KieServices ks = KieServices.Factory.get();
        KieRepository kieRepository = ks.getRepository();
        KieFileSystem kieFileSystem = ks.newKieFileSystem();
        kieFileSystem.write("src/main/resources/rules/aa.drl", myRule);
        KieBuilder kieBuilder = ks.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        System.out.println(kieRepository.getDefaultReleaseId());
        KieContainer kContainer = ks.newKieContainer(kieRepository.getDefaultReleaseId());

        KieSession kSession = kContainer.newKieSession();

        Person p = new Person();
        kSession.insert(p);
        kSession.fireAllRules();
        kSession.dispose();
    }

}
