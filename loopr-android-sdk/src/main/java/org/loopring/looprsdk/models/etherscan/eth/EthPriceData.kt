package org.loopring.looprsdk.models.etherscan.eth

import com.google.gson.annotations.SerializedName

import java.math.BigDecimal
import java.util.*

/**
 * Ethereum price data at a given time
 *
 * ```
 * {
 *   ethbtc
 *   ethbtc_timestamp
 *   ethusd
 *   ethusd_timestamp
 * }
 * ```
 */
class EthPriceData {

    /**
     * ETH/BTC ratio
     */
    var ethToBtc: BigDecimal?
        get() = mEthToBtc?.let { BigDecimal(it) }
        set(value) {
            mEthToBtc = value?.toPlainString()
        }

    @SerializedName("ethbtc")
    private var mEthToBtc: String? = null

    /**
     * Timestamp the ETH/BTC ratio was taken from
     */
    @SerializedName("ethbtc_timestamp")
    var ethToBtcTimestamp: Date? = null

    /**
     * ETH/USD ratio
     */
    var ethToUsd: BigDecimal?
        get() = mEthToUsd?.let { BigDecimal(it) }
        set(value) {
            mEthToUsd = value?.toPlainString()
        }

    @SerializedName("ethusd")
    private var mEthToUsd: String? = null

    /**
     * Timestamp the ETH/USD ratio was taken from
     */
    @SerializedName("ethusd_timestamp")
    var ethToUsdTimestamp: Date? = null

}