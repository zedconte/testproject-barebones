/*
 * testproject-challenge
 * Copyright (C) 2020  Raul Ortega
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
