/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.launcher;

import org.mule.module.launcher.artifact.Artifact;

import java.io.IOException;
import java.net.URL;

/**
 *
 */
public interface MuleDeployer
{

    void deploy(Artifact app);

    void undeploy(Artifact app);

    /**
     * Installs packaged Mule apps from $MULE_HOME/apps directory.
     * @param packedMuleAppFileName filename of the packed Mule app (only name + ext)
     */
    Artifact installFromDir(String packedMuleAppFileName) throws IOException;


    Artifact installFrom(URL url) throws IOException;
}
