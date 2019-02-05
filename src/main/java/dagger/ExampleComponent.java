package dagger;

import lambdas.DynamoDBMapperHandler;
import lambdas.SimpleLoggingHandler;
import modules.DynamoDBModule;
import modules.LambdaModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        DynamoDBModule.class,
        LambdaModule.class,
})
public interface ExampleComponent {
    void inject(SimpleLoggingHandler simpleLoggingHandler);
    void inject(DynamoDBMapperHandler dynamoDBMapperHandler);
}
