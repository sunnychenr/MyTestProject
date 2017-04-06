package com.lionmobi.rxjavatest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.lionmobi.rxjavatest.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Flowable.just("RxJava to String").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.d("chenr", "Consumer ---> accept: " + s);
            }
        });

        Flowable<String> mFlowable = new Flowable<String>() {
            @Override
            protected void subscribeActual(Subscriber<? super String> subscriber) {
                subscriber.onNext("this is a string, you know???");
            }
        };

        Subscriber<String> mSubscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d("chenr", "mSubscriber ---> onSubscriber");
            }

            @Override
            public void onNext(String s) {
                Log.d("chenr", "mSubsriber ---> onNext: " + s);
            }

            @Override
            public void onError(Throwable t) {
                Log.d("chenr", "mSubscriber ---> onError");
            }

            @Override
            public void onComplete() {
                Log.d("chenr", "mSubscriber ---> onComplete");
            }
        };
        mFlowable.subscribe(mSubscriber);
    }
}
