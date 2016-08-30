package cn.springboot.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.annotation.Resource;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")
public class ElasticsearchConfig {

	@Resource
	private Environment environment;

	@Bean
	public Client client() {
		InetAddress inetAddress = null;
		TransportClient client = null;
		try {
			client = TransportClient.builder().build();
			inetAddress = InetAddress.getByName(environment.getProperty("elasticsearch.host"));
			TransportAddress address = new InetSocketTransportAddress(inetAddress,
					Integer.parseInt(environment.getProperty("elasticsearch.port")));
			client.addTransportAddress(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
}