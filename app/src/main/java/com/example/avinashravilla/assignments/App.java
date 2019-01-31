package com.example.avinashravilla.assignments;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static App instance;

    private static Context mContext;
    /**
     * set context to instance
     */
    public App() {
        instance = this;
    }

    /**
     * call from anywhere returns application context
     *
     * @return Application context
     */
    public static App get() {
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public  void setContext(Context mContext) {
        this.mContext = mContext;
    }

}

