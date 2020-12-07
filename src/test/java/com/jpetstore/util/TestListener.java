package com.jpetstore.util;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.util.Helper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestListener extends DriverManager implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Helper.takeScreenShot(driver, context.getDisplayName());
        System.out.printf("*** 111 Test is failed ***");
    }

}
