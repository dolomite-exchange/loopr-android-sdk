package org.loopring.looprsdk.models.etherscan


/**
 * Etherscan API
 *
 * Retrieve ABI for the given address
 *
 * ```
 * {
 *   status
 *   message
 *   result
 * }
 * ```
 */
class AbiResponse(

        /**
         * Status of the request. Can be 1 for complete or 0 for failure.
         */
        var status: Int? = null,

        /**
         * Status message. Can be "OK" for successful calls or "NOTOK" for failures
         */
        var message: String? = null,

        /**
         * The contracts ABI
         */
        var abi: String? = null

)