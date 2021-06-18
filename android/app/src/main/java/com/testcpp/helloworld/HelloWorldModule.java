
package com.testcpp.helloworld;

import com.cppreactnative.helloworld.HelloWorld;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class HelloWorldModule extends ReactContextBaseJavaModule {
  
    // Add the following lines
    private HelloWorld cppApi; // instance var for our cppApi
  
    static {
        System.loadLibrary("native-lib"); // load the "helloworld" JNI module
    }
  
    public HelloWorldModule(ReactApplicationContext reactContext) {
        super(reactContext); 
        cppApi = HelloWorld.test; // create a new instance of our cppApi
    }
  
    @Override
    public String getName() {
        return "HelloWorld";
    }
  
    @ReactMethod
    public void sayHello(Promise promise) { 
        // call the "getHelloWorld()" method on our C++ class and get the results.
        int myString = cppApi.getHelloWorld();
        promise.resolve(myString);
    }
}
