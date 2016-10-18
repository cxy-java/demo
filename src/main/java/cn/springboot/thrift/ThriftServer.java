package cn.springboot.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import cn.springboot.thrift.impl.HelloWorldServiceImpl;

/**
 * 服务端
 * 
 * @author Qutke
 *
 */
public class ThriftServer {

	public static void main(String[] args) {
		try {

			TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(
					new HelloWorldServiceImpl());
			// 简单的单线程服务模型，一般用于测试
			TServerSocket serverTransport = new TServerSocket(6060);
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			TServer server = new TSimpleServer(tArgs);
			server.serve();

		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}
}
