<?xml version="1.0" encoding="ISO-8859-1"?>
<!--

    Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
    The software in this package is published under the terms of the CPAL v1.0
    license, a copy of which has been included with this distribution in the
    LICENSE.txt file.

-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

    <xsl:param name="echo"/>

    <xsl:template match="/">
        <echo-value><xsl:value-of select="$echo"/></echo-value>
    </xsl:template>
</xsl:stylesheet>
