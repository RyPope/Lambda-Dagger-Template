package lambdas;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dagger.Injector;
import models.DynamoDBItem;

import javax.inject.Inject;

public class DynamoDBMapperHandler implements RequestHandler<String, DynamoDBItem> {
    @Inject DynamoDBMapper mDynamoDBMapper;

    public DynamoDBItem handleRequest(final String primaryKey, final Context context) {
        Injector.getInjector(context).inject(this);

        return mDynamoDBMapper.load(DynamoDBItem.class, primaryKey);
    }
}