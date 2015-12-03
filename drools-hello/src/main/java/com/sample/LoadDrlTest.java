package com.sample;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;

/**
 * Created by Louz on 2015/10/28.
 */
public class LoadDrlTest {

    public static void main(String[] args) {
        String myRule = "package com.aa\n" +
                "\n" +
                "//list any import classes here.\n" +
                "import com.sample.Person;\n" +
                "\n" +
                "\n" +
                "//declare any global variables here\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "rule \"Your First Rule\"\n" +
                "\n" +
                "    when\n" +
                "        p : Person()\n" +
                "    then\n" +
                "        System.out.println(\"you are a person2\");\n" +
                "\n" +
                "end";

//        Resource myResource = ResourceFactory.newReaderResource((Reader) new StringReader(myRule));
//        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        kbuilder.add(myResource, ResourceType.DRL);
//
//        // Check the builder for errors
//        if ( kbuilder.hasErrors() ) {
//            System.out.println( kbuilder.getErrors().toString() );
//            throw new RuntimeException( "Unable to compile drl\"." );
//        }
//
//        // get the compiled packages (which are serializable)
//        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
//
//        // add the packages to a knowledgebase (deploy the knowledge packages).
//        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//        kbase.addKnowledgePackages( pkgs );
//
//        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//
//        Person p = new Person();
//        ksession.insert(p);
//
//        ksession.fireAllRules();
//        ksession.dispose();


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
