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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * CreateAccountResponse
 */
public class CreateAccountResponse {
    @SerializedName("accountStatus")
    private AccountStatus accountStatus = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    /**
     * account status
     */
    public enum StatusEnum {
        @SerializedName("Active") ACTIVE("Active"),

        @SerializedName("Closed") CLOSED("Closed"),

        @SerializedName("Inactive") INACTIVE("Inactive"),

        @SerializedName("Suspended") SUSPENDED("Suspended");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("payoutSchedule")
    private PayoutScheduleResponse payoutSchedule = null;

    /**
     * account status
     *
     * @return accountStatus
     **/
    public AccountStatus getAccountStatus() {
        return accountStatus;
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
     * generated account code
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
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
     * account status
     *
     * @return status
     **/
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * parameters of the created payout schedule
     *
     * @return payoutSchedule
     **/
    public PayoutScheduleResponse getPayoutSchedule() {
        return payoutSchedule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateAccountResponse createAccountResponse = (CreateAccountResponse) o;
        return Objects.equals(this.accountStatus, createAccountResponse.accountStatus)
                && Objects.equals(this.submittedAsync, createAccountResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, createAccountResponse.accountHolderCode)
                && Objects.equals(this.accountCode, createAccountResponse.accountCode)
                && Objects.equals(this.pspReference, createAccountResponse.pspReference)
                && Objects.equals(this.status, createAccountResponse.status)
                && Objects.equals(this.payoutSchedule, createAccountResponse.payoutSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus, submittedAsync, accountHolderCode, accountCode, pspReference, status, payoutSchedule);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateAccountResponse {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
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

