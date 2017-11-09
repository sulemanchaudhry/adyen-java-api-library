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
 * AccountHolderTransactionListResponse
 */
public class AccountHolderTransactionListResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountTransactionLists")
    private List<AccountTransactionListContainer> accountTransactionListContainers = null;

    private transient List<AccountTransactionList> accountTransactionLists = null;

    @SerializedName("resultCode")
    private String resultCode = null;

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
     * Populate the virtual accountTransactionLists to bypass the accountTransactionListContainers list
     *
     * @return accountTransactionLists
     **/
    public List<AccountTransactionList> getAccountTransactionLists() {
        if (accountTransactionLists == null) {
            accountTransactionLists = new ArrayList<AccountTransactionList>();
            if (accountTransactionListContainers != null && ! accountTransactionListContainers.isEmpty()) {
                for (AccountTransactionListContainer accountTransactionListContainer : accountTransactionListContainers) {
                    accountTransactionLists.add(accountTransactionListContainer.getAccountTransactionList());
                }
            }
        }
        return accountTransactionLists;
    }

    /**
     * The result code
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
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
        AccountHolderTransactionListResponse accountHolderTransactionListResponse = (AccountHolderTransactionListResponse) o;
        return Objects.equals(this.submittedAsync, accountHolderTransactionListResponse.submittedAsync)
                && Objects.equals(this.accountTransactionListContainers,
                                  accountHolderTransactionListResponse.accountTransactionListContainers)
                && Objects.equals(this.resultCode, accountHolderTransactionListResponse.resultCode)
                && Objects.equals(this.pspReference, accountHolderTransactionListResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, accountTransactionListContainers, resultCode, pspReference);
    }


    @Override
    public String toString() {
        // Populate the accountTransactionLists list to provide back in the toString() method
        this.getAccountTransactionLists();
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderTransactionListResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountTransactionLists: ").append(toIndentedString(accountTransactionLists)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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

