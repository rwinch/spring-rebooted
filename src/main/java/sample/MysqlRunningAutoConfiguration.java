package sample;

import java.io.IOException;
import java.net.ServerSocket;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

import sample.MysqlRunningAutoConfiguration.MysqlRunningCondition;

@Configuration
@ConditionalOnClass(com.mysql.jdbc.Driver.class)
@Conditional(MysqlRunningCondition.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class MysqlRunningAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.username("spring")
				.password("password")
				.url("jdbc:mysql://localhost/spring")
				.build();
	}
	
	static class MysqlRunningCondition extends SpringBootCondition {

		@Override
		public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
			try(ServerSocket socket = new ServerSocket(3306)) {
				return ConditionOutcome.noMatch("Mysql not running");
			}catch (IOException e) {}
			return ConditionOutcome.match();
		}
		
	}

}
