/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transformer.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import org.mule.DataTypeMatcher;
import org.mule.MuleMessageDataTypeWrapper;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transformer.types.MimeTypes;

import org.junit.Test;

public class SetPayloadDataTypeTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigFile()
    {
        return "set-payload-data-type-config.xml";
    }

    @Test
    public void setsPayloadLocal() throws Exception
    {
        //TODO(pablo.kraan): DFL - replace this test with unit tests
        doSetPayloadTest("vm://setPayloadLocal");
    }

    @Test
    public void setsPayloadGlobal() throws Exception
    {
        doSetPayloadTest("vm://setPayloadGlobal");
    }

    private void doSetPayloadTest(String url) throws MuleException
    {
        LocalMuleClient client = muleContext.getClient();

        MuleMessage response = client.send(url, TEST_MESSAGE, null);

        MuleMessageDataTypeWrapper dataType = (MuleMessageDataTypeWrapper) response.getDataType();

        assertThat(dataType, DataTypeMatcher.like(Long.class, MimeTypes.XML, "UTF-16"));
    }
}
