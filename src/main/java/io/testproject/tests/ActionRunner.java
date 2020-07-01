package main.java.io.testproject.tests;
import io.testproject.java.sdk.v2.addons.proxy.ActionProxy;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;

public class ActionRunner {

    private final WebTestHelper webTestHelper;

    public ActionRunner(WebTestHelper webTestHelper) {
        this.webTestHelper = webTestHelper;
    }

    void runAction(ActionProxy proxy) throws FailureException {
        try {
            ExecutionResult result = webTestHelper.executeProxy(proxy);
            if (result == ExecutionResult.FAILED) {
                throw new FailureException(String.format(
                        "The invocation of the action proxy: %s failed ",
                        proxy.getDescriptor().getClassName()
                ));
            }
        }
        catch (Exception e) {
            throw new FailureException(e.getMessage(), e);
        }
    }
}
