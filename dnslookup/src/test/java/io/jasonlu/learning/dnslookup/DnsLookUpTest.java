package io.jasonlu.learning.dnslookup;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by louz on 2016/12/14.
 *
 * 在程序的启动参数中要加上 -Dsun.net.spi.nameservice.provider.1=dns,dnsljh
 */
public class DnsLookUpTest {
    @Test
    public void testLookup() throws UnknownHostException {
//        System.setProperty("sun.net.spi.nameservice.provider.1", "dns,dnsljh");
//        System.setProperty("sun.net.spi.nameservice.provider.2", "default");

        String googleHost = InetAddress.getByName("www.google.com").getHostAddress();
        System.out.println(googleHost);

        String mockhost = InetAddress.getByName("mockhost").getHostAddress();
        assertThat(mockhost, is("10.1.1.1"));
    }
}
