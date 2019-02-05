package modules;

import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class LambdaModule {
    private final Context mContext;

    public LambdaModule(final Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    LambdaLogger providesLambdaLogger() {
        return mContext.getLogger();
    }
}
