package lambdas;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dagger.Injector;

import javax.inject.Inject;

public class SimpleLoggingHandler implements RequestHandler<String, Boolean> {
    @Inject LambdaLogger mLogger;

    public Boolean handleRequest(final String request, final Context context) {
        Injector.getInjector(context).inject(this);

        mLogger.log(String.format("Received Request: %s", request));

        return true;
    }
}
