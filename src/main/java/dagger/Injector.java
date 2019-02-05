package dagger;

import com.amazonaws.services.lambda.runtime.Context;
import modules.DynamoDBModule;
import modules.LambdaModule;

public class Injector {
    public static ExampleComponent getInjector(final Context context) {
        return DaggerExampleComponent
                .builder()
                .dynamoDBModule(new DynamoDBModule())
                .lambdaModule(new LambdaModule(context))
                .build();
    }
}