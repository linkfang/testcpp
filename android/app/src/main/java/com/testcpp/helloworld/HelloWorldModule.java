
package com.testcpp.helloworld;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class HelloWorldModule extends ReactContextBaseJavaModule {
  
    // Add the following lines

  
    static {
        System.loadLibrary("native-lib"); // load the "helloworld" JNI module
    }


    private native String getHelloWorld(long test);


    public HelloWorldModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }
  
    @Override
    public String getName() {
        return "HelloWorld";
    }
  
    @ReactMethod
    public void sayHello(Callback callBack) {
        // call the "getHelloWorld()" method on our C++ class and get the results

        String myInt = getHelloWorld(2);

        callBack.invoke(myInt);
    }
}
