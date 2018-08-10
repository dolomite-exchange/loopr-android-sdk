package org.loopring.looprsdk.models.etherscan.address

import com.google.gson.annotations.SerializedName

import java.math.BigDecimal

/**
 * Etherscan API
 *
 * Account balance:
 * ```
 * {
 *   account
 *   balance
 * }
 * ```
 */
class AccountBalance {

    /**
     * The address of the account whose balance was retrieved
     */
    @SerializedName("account")
    var address: String? = null

    /**
     * The balance of the account in wei, example output - 670456215218885498951364 would be 670,456.21... eth
     */
    var balance: BigDecimal?
        get() {
            return mBalance?.let { BigDecimal(it) }
        }
        set(value) {
            mBalance = value?.toPlainString()
        }

    @SerializedName("balance")
    private var mBalance: String? = null

}