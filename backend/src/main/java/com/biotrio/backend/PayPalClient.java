package com.biotrio.backend;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class PayPalClient {

    /**
     *Set up the PayPal Java SDK environment with PayPal access credentials.
     *This sample uses SandboxEnvironment. In production, use ProductionEnvironment.
     */
    private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
            "AYi6ynH1fwYMY1XdyMOK0YK-QJsiRxFMueAO1Ck96X528D_deV2RwDIEIQ3Yf9r_TuVzQ-SZNXNv9j8B",
            "EEmJwEmrkVnGl7vPA27NOXA27HXY5VKqHfbi65hRBR9bixf-eHLJRmZ6D2nGC9T6m2PEWFWmfu2Nx7Zm");

    /**
     *PayPal HTTP client instance with environment that has access
     *credentials context. Use to invoke PayPal APIs.
     */
    PayPalHttpClient client = new PayPalHttpClient(environment);

    /**
     *Method to get client object
     *
     *@return PayPalHttpClient client
     */
    public PayPalHttpClient client() {
        return this.client;
    }
}