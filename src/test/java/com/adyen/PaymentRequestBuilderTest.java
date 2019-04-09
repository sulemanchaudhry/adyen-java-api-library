/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import java.util.HashMap;
import org.junit.Test;
import com.adyen.constants.ApiConstants;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.applicationinfo.ExternalPlatform;
import static org.junit.Assert.assertEquals;

public class PaymentRequestBuilderTest extends BaseTest {


    @Test
    public void TestCCPaymentRequest() {
        String integratorName = "TestIntegrator";
        PaymentRequest paymentRequest = createFullCardPaymentRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        ExternalPlatform externalPlatform = new ExternalPlatform();
        externalPlatform.setIntegrator(integratorName);
        applicationInfo.setExternalPlatform(externalPlatform);
        paymentRequest.setApplicationInfo(applicationInfo);

        // Test metadata
        paymentRequest.setMetadata(new HashMap<String, String>());
        paymentRequest.getMetadata().put("key", "value");

        // Test recurring processing model
        paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARD_ON_FILE);

        String paymentRequestJson = PRETTY_PRINT_GSON.toJson(paymentRequest);

        String expected = "{\n"
                + "  \"card\": {\n"
                + "    \"expiryMonth\": \"08\",\n"
                + "    \"expiryYear\": \"2018\",\n"
                + "    \"cvc\": \"737\",\n"
                + "    \"holderName\": \"John Doe\",\n"
                + "    \"number\": \"5136333333333335\"\n"
                + "  },\n"
                + "  \"recurringProcessingModel\": \"CardOnFile\",\n"
                + "  \"amount\": {\n"
                + "    \"value\": 100000,\n"
                + "    \"currency\": \"EUR\"\n"
                + "  },\n"
                + "  \"reference\": \"123456\",\n"
                + "  \"shopperIP\": \"1.2.3.4\",\n"
                + "  \"merchantAccount\": \"AMerchant\",\n"
                + "  \"browserInfo\": {\n"
                + "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"
                + "    \"acceptHeader\": \"*/*\"\n"
                + "  },\n"
                + "  \"metadata\": {\n"
                + "    \"key\": \"value\"\n"
                + "  },\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \""
                + Client.LIB_NAME
                + "\",\n"
                + "      \"version\": \""
                + Client.LIB_VERSION
                + "\"\n"
                + "    },\n"
                + "    \"externalPlatform\": {\n"
                + "      \"integrator\": \""
                + integratorName
                + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";

        assertEquals(expected, paymentRequestJson);
    }

    @Test
    public void TestCSEPaymentRequest() {
        PaymentRequest paymentRequest = createCSEPaymentRequest();
        paymentRequest.setApplicationInfo(null);

        String paymentRequestJson = PRETTY_PRINT_GSON.toJson(paymentRequest);

        String expected = "{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 100000,\n"
                + "    \"currency\": \"EUR\"\n"
                + "  },\n"
                + "  \"reference\": \"123456\",\n"
                + "  \"shopperIP\": \"1.2.3.4\",\n"
                + "  \"merchantAccount\": \"AMerchant\",\n"
                + "  \"browserInfo\": {\n"
                + "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"
                + "    \"acceptHeader\": \"*/*\"\n"
                + "  },\n"
                + "  \"additionalData\": {\n"
                + "    \"card.encrypted.json\": \"adyenjs_0_1_4p1$...\"\n"
                + "  },\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"adyen-java-api-library\",\n"
                + "      \"version\": \"2.0.1\"\n"
                + "    }\n"
                + "  }\n"
                + "}";

        assertEquals(expected, paymentRequestJson);
    }

    @Test
    public void Test3DSecureRequest() {
        PaymentRequest3d paymentRequest3d = create3DPaymentRequest();

        String paymentRequestJson = PRETTY_PRINT_GSON.toJson(paymentRequest3d);
        String expected = "{\n"
                + "  \"md\": \"mdString\",\n"
                + "  \"paResponse\": \"paResString\",\n"
                + "  \"shopperIP\": \"1.2.3.4\",\n"
                + "  \"merchantAccount\": \"AMerchant\",\n"
                + "  \"browserInfo\": {\n"
                + "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"
                + "    \"acceptHeader\": \"*/*\"\n"
                + "  },\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \""
                + Client.LIB_NAME
                + "\",\n"
                + "      \"version\": \""
                + Client.LIB_VERSION
                + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";

        assertEquals(expected, paymentRequestJson);
    }

    @Test
    public void TestSecuredFieldsPaymentRequest() {
        PaymentRequest paymentRequest = new PaymentRequest().setSecuredFieldsData("encryptedCardNumber", "cardHolder", "encryptedExpiryMonth", "encryptedExpiryYear", "encryptedSecurityCode");

        assertEquals("encryptedCardNumber", paymentRequest.getAdditionalData().get(ApiConstants.AdditionalData.ENCRYPTED_CARD_NUMBER));
        assertEquals("cardHolder", paymentRequest.getCard().getHolderName());
        assertEquals("encryptedExpiryMonth", paymentRequest.getAdditionalData().get(ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_MONTH));
        assertEquals("encryptedExpiryYear", paymentRequest.getAdditionalData().get(ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_YEAR));
        assertEquals("encryptedSecurityCode", paymentRequest.getAdditionalData().get(ApiConstants.AdditionalData.ENCRYPTED_SECURITY_CODE));
    }
}
