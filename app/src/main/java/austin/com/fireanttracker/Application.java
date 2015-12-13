package austin.com.fireanttracker;

/**
 * Created by austinkladke on 12/12/15.
 */

import com.parse.Parse;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Register any ParseObject subclass. Must be done before calling Parse.initialize()
        //ParseObject.registerSubclass(YourClass.class);

        Parse.initialize(this, "bWzGUS3Mj00BHIax7d9kk21GKzoHq5Y3Yw2m9vSm", "p0wTCMhRH9HRUDYzlBzoZOdllm5qJ41VP6Lz8fR0");
    }

}