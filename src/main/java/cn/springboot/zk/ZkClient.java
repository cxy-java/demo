package cn.springboot.zk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkClient implements Watcher {

	private static ZooKeeper zk;
	private static String zNode = "/changxy";

	public ZkClient(String hostPort) throws IOException {
		zk = new ZooKeeper(hostPort, 3000, this);
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("节点变化了=========" + event.getPath());
		if (event.getType().equals(EventType.NodeDeleted)) {
			List<String> subNodes = null;
			try {
				subNodes = zk.getChildren(zNode, false);
				Collections.sort(subNodes);
				zk.getData(zNode + "/" + subNodes.get(0), true, null);
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
		String hostPort = "192.168.148.131:2181";
		new ZkClient(hostPort);
		Stat stat = zk.exists(zNode, true);
		if (stat == null) {
			zk.create(zNode, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		InputStream in = ZkClient.class.getResourceAsStream("/config.properties");
		int size = in.available();
		byte[] buffer = new byte[size];
		in.read(buffer);
		zk.create(zNode + "/no_", buffer, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
		List<String> subNodes = zk.getChildren(zNode, false);
		Collections.sort(subNodes);
		zk.getData(zNode + "/" + subNodes.get(0), true, null);
		in.close();
		while (true) {
		}
	}*/

}
