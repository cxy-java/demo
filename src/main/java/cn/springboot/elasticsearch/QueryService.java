package cn.springboot.elasticsearch;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public void create() {
	}

	public void index() {
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("id", "1");
		userMap.put("name", "cxy");
		userMap.put("age", 28);
		IndexQuery indexQuery = new IndexQueryBuilder().withId((String)userMap.get("id")).withObject(userMap).build();
		elasticsearchTemplate.index(indexQuery);
	}

	
	public void qry(String id){
		BoolQueryBuilder builder = new BoolQueryBuilder();
		builder.must(QueryBuilders.matchQuery("id", id));
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
	        .withQuery(builder)
	        .build();
	        Page<Map> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery,Map.class);
	}
}
