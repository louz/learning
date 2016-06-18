package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by Louz on 2016/6/18.
 */
public class ReuseKieSessionDemo {

    public static void main(String[] args) {
//        correctUse();
//        wrongUseButNoMemLeak();
        wrongUse();
    }

    private static void correctUse() {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();

            // go !
            int i = 1;
            while (true) {
                KieSession kSession = kContainer.newKieSession("reuse-ksession-rules");

                ReuseObject obj = new ReuseObject();
                obj.setMessage("Message " + i++);
                kSession.insert(obj);
                kSession.fireAllRules();
                kSession.dispose();

                Thread.sleep(2);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * cause memory leak
     */
    private static void wrongUse() {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("reuse-ksession-rules");

            // go !
            int i = 1;
            while (true) {
                ReuseObject obj = new ReuseObject();
                obj.setMessage("Message " + i++);   // different every time
                kSession.insert(obj);
                kSession.fireAllRules();

                Thread.sleep(2);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * 不插入事实时，内存溢出不明显
     */
    private static void wrongUseButNoMemLeak() {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("reuse-ksession-rules");

            // go !
            int i = 1;
            while (true) {
                kSession.fireAllRules();

                Thread.sleep(2);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class ReuseObject {
        public String getMessage() {
            return message;
        }

        private String message;

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
