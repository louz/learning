package io.jasonlu.learning.dnslookup;

import sun.net.spi.nameservice.NameService;
import sun.net.spi.nameservice.NameServiceDescriptor;

/**
 * Created by louz on 2016/12/14.
 */
public class LocalManagedNameServiceDescriptor implements NameServiceDescriptor {
    @Override
    public NameService createNameService() throws Exception {
        return new LocalManagedNameService();
    }

    @Override
    public String getProviderName() {
        return "dnsljh";
    }

    @Override
    public String getType() {
        return "dns";
    }

    public LocalManagedNameServiceDescriptor() {
        System.out.println("hello, you're in LocalManagedNameServiceDescriptor");
    }
}
