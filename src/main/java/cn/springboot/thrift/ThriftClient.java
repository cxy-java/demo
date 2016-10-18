package cn.springboot.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {

	public static void main(String[] args) {
		TTransport transport = null;
		try {
			transport = new TSocket("127.0.01", 6060, 30);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			HelloWorldService.Client client = new HelloWorldService.Client(protocol);
			transport.open();
			client.sayHello();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}
}
