package cn.springboot.spark;

/*import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkYarnConfiguration {

	@Autowired
	private org.apache.hadoop.conf.Configuration hadoopConfiguration;

	@Value("${example.inputDir}")
	String inputDir;

	@Value("${example.inputFileName}")
	String inputFileName;

	@Value("${example.inputLocalDir}")
	String inputLocalDir;

	@Value("${example.outputDir}")
	String outputDir;

	@Value("${example.sparkAssembly}")
	String sparkAssembly;

	// Job definition
	@Bean
	Job tweetHashtags(JobBuilderFactory jobs, Step initScript, Step sparkTopHashtags) throws Exception {
		return jobs.get("TweetTopHashtags").start(initScript).next(sparkTopHashtags).build();
	}
}*/
