package io.jasonlu.learning.dnslookup;

import sun.net.spi.nameservice.NameService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by louz on 2016/12/15.
 */
public class LocalManagedNameService implements NameService {

    private Map<String, InetAddress> managedAddresses = new HashMap<>();

    public LocalManagedNameService() {
        try {
            InetAddress address = InetAddress.getByName("10.1.1.1");
            managedAddresses.put("mockhost", address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InetAddress[] lookupAllHostAddr(String s) throws UnknownHostException {
        InetAddress inetAddress = managedAddresses.get(s);
        if (inetAddress == null) {
            throw new UnknownHostException();
        }

        return new InetAddress[]{inetAddress};
    }

    @Override
    public String getHostByAddr(byte[] bytes) throws UnknownHostException {
        throw new UnknownHostException("method not implement yet");
    }
}
