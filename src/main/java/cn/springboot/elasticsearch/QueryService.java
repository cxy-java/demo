package cn.springboot.elasticsearch;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	public void qry(){
		
	}
	
}
