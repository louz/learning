package io.jasonlu.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by jiehenglu on 17/05/12.
 */
public class Main {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, watchedEvent -> { });
        for (String child : zk.getChildren("/", false)) {
            System.out.println(child);
        }

        zk.create("/test", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        for (String child : zk.getChildren("/", false)) {
            System.out.println(child);
        }
    }
}
