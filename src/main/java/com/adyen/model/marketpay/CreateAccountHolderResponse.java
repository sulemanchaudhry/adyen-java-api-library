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
package com.adyen.model.marketpay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * CreateAccountHolderResponse
 */
public class CreateAccountHolderResponse {
    @SerializedName("accountStatus")
    private AccountStatus accountStatus = null;

    @SerializedName("verificationResult")
    private KYCVerificationResult verificationResult = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("requirementsForNextAccountState")
    private List<AccountStateRequirement> requirementsForNextAccountState = new ArrayList<AccountStateRequirement>();

    @SerializedName("invalidFields")
    public List<ErrorFieldTypeContainer> invalidFieldsContainers = null;

    private transient List<ErrorFieldType> invalidFields = null;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("kycVerificationResults")
    private List<KYCVerificationResult> kycVerificationResults = new ArrayList<KYCVerificationResult>();

    /**
     * status of created account holder
     *
     * @return accountStatus
     **/
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     * verification result
     *
     * @return verificationResult
     **/
    public KYCVerificationResult getVerificationResult() {
        return verificationResult;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    /**
     * account holder code
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    /**
     * account holder's account code (if an account has been created for the account holder)
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * account holder properties that must be provided, in order for the account holder to reach the next processing state level
     *
     * @return requirementsForNextAccountState
     **/
    public List<AccountStateRequirement> getRequirementsForNextAccountState() {
        return requirementsForNextAccountState;
    }

    /**
     * Populate the virtual invalidFields to bypass the invalidFieldsContainers list
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        if (invalidFields == null) {
            invalidFields = new ArrayList<ErrorFieldType>();

            if (invalidFieldsContainers != null && ! invalidFieldsContainers.isEmpty()) {
                for (ErrorFieldTypeContainer invalidFieldsContainer : invalidFieldsContainers) {
                    invalidFields.add(invalidFieldsContainer.getErrorFieldType());
                }
            }
        }

        return invalidFields;
    }

    /**
     * details of created account holder
     *
     * @return accountHolderDetails
     **/
    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    /**
     * account holder status
     *
     * @return accountHolderStatus
     **/
    public AccountHolderStatus getAccountHolderStatus() {
        return accountHolderStatus;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    /**
     * KYC verification results
     *
     * @return kycVerificationResults
     **/
    public List<KYCVerificationResult> getKycVerificationResults() {
        return kycVerificationResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateAccountHolderResponse createAccountHolderResponse = (CreateAccountHolderResponse) o;
        return Objects.equals(this.accountStatus, createAccountHolderResponse.accountStatus)
                && Objects.equals(this.verificationResult, createAccountHolderResponse.verificationResult)
                && Objects.equals(this.submittedAsync, createAccountHolderResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, createAccountHolderResponse.accountHolderCode)
                && Objects.equals(this.accountCode, createAccountHolderResponse.accountCode)
                && Objects.equals(this.requirementsForNextAccountState, createAccountHolderResponse.requirementsForNextAccountState)
                && Objects.equals(this.invalidFieldsContainers, createAccountHolderResponse.invalidFieldsContainers)
                && Objects.equals(this.accountHolderDetails, createAccountHolderResponse.accountHolderDetails)
                && Objects.equals(this.accountHolderStatus, createAccountHolderResponse.accountHolderStatus)
                && Objects.equals(this.pspReference, createAccountHolderResponse.pspReference)
                && Objects.equals(this.kycVerificationResults, createAccountHolderResponse.kycVerificationResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus,
                            verificationResult,
                            submittedAsync,
                            accountHolderCode,
                            accountCode,
                            requirementsForNextAccountState,
                            invalidFieldsContainers,
                            accountHolderDetails,
                            accountHolderStatus,
                            pspReference,
                            kycVerificationResults);
    }


    @Override
    public String toString() {
        // Populate the invalidFields list to provide back in the toString() method
        this.getInvalidFields();

        StringBuilder sb = new StringBuilder();
        sb.append("class CreateAccountHolderResponse {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    verificationResult: ").append(toIndentedString(verificationResult)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    requirementsForNextAccountState: ").append(toIndentedString(requirementsForNextAccountState)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    kycVerificationResults: ").append(toIndentedString(kycVerificationResults)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

