package com.example.s162138.myweather;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by s162138 on 2/2/2017.
 */
public class MySingleton {
    private static MySingleton ourInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;
    public static synchronized MySingleton getInstance(Context context){
        if (ourInstance == null)
        {
            ourInstance = new MySingleton(context);
        }
        return ourInstance;
    }



    private MySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}

