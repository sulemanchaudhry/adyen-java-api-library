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
 * AccountHolderBalanceResponse
 */
public class AccountHolderBalanceResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("totalBalance")
    private DetailBalance totalBalance = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("balancePerAccount")
    private List<AccountDetailBalanceContainer> balancePerAccountContainers = null;

    private transient List<AccountDetailBalance> balancePerAccount = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    /**
     * @return totalBalance
     **/
    public DetailBalance getTotalBalance() {
        return totalBalance;
    }

    /**
     * Get resultCode
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Populate the virtual balancePerAccount to bypass the balancePerAccountContainers list
     *
     * @return balancePerAccount
     **/
    public List<AccountDetailBalance> getBalancePerAccount() {

        if (balancePerAccount == null) {
            balancePerAccount = new ArrayList<AccountDetailBalance>();

            if (balancePerAccountContainers != null && ! balancePerAccountContainers.isEmpty()) {
                for (AccountDetailBalanceContainer balancePerAccountContainer : balancePerAccountContainers) {
                    balancePerAccount.add(balancePerAccountContainer.getAccountDetailBalance());
                }
            }
        }

        return balancePerAccount;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderBalanceResponse accountHolderBalanceResponse = (AccountHolderBalanceResponse) o;
        return Objects.equals(this.submittedAsync, accountHolderBalanceResponse.submittedAsync)
                && Objects.equals(this.totalBalance, accountHolderBalanceResponse.totalBalance)
                && Objects.equals(this.resultCode, accountHolderBalanceResponse.resultCode)
                && Objects.equals(this.balancePerAccountContainers, accountHolderBalanceResponse.balancePerAccountContainers)
                && Objects.equals(this.pspReference, accountHolderBalanceResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, totalBalance, resultCode, balancePerAccountContainers, pspReference);
    }


    @Override
    public String toString() {
        // Populate the balancePerAccount list to provide back in the toString() method
        this.getBalancePerAccount();
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderBalanceResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    totalBalance: ").append(toIndentedString(totalBalance)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    balancePerAccount: ").append(toIndentedString(balancePerAccount)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

