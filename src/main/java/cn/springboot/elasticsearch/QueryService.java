package cn.springboot.elasticsearch;

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

import cn.springboot.elasticsearch.model.User;

@Service
public class QueryService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public void create() {
	}

	public void index() {
		User user = new User();
		user.setId(200);
		user.setName("虚竹");
		user.setAge(28);
		IndexQuery indexQuery = new IndexQueryBuilder().withId(String.valueOf(user.getId())).withObject(user).build();
		elasticsearchTemplate.index(indexQuery);
	}

	public Page<User> qry(String name) {
		BoolQueryBuilder builder = new BoolQueryBuilder();
		builder.must(QueryBuilders.matchQuery("name", name));
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		Page<User> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery, User.class);
		return sampleEntities;
	}
}
