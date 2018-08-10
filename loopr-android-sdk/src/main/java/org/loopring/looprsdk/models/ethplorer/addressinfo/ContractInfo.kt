package org.loopring.looprsdk.models.ethplorer.addressinfo


/**
 * Ethplorer API
 *
 * Exists if the address is for a contract
 *
 * ```
 * {
 *   creatorAddress:  # contract creator address,
 *   transactionHash: # contract creation transaction hash,
 *   timestamp:       # contract creation timestamp
 * }
 * ```
 */
class ContractInfo(

        /**
         * Address of the creator of the contract
         */
        var creatorAddress: String? = null,

        /**
         * Contract creation hash
         */
        var transactionHash: String? = null,

        /**
         * Timestamp for the creation of the contract
         */
        var timestamp: String? = null
)