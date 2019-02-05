package modules;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DynamoDBModule {
    @Provides
    @Singleton
    DynamoDB dynamoDB(final AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDB(amazonDynamoDB);
    }

    @Provides
    @Singleton
    DynamoDBMapper providesDynamoDBMapper(final AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }

    @Provides
    @Singleton
    AmazonDynamoDB providesAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .build();
    }
}
