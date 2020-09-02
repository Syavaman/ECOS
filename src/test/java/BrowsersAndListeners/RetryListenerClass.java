package BrowsersAndListeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListenerClass implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation itestannotation, Class testClass, Constructor testConstructor, Method testMethod) {
        itestannotation.setRetryAnalyzer(RetryFailedTestCases.class);
    }
}
