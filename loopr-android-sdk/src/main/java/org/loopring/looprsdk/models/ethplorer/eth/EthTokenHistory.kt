package org.loopring.looprsdk.models.ethplorer.eth

import org.loopring.looprsdk.models.ethplorer.transactioninfo.EthTransactionOperationInfo


/**
 * Ethplorer API
 *
 * Gets history of token operations for an address
 */
class EthTokenHistory(

        /**
         * List of [EthTransactionOperationInfo] objects containing the token history
         */
        var operations: ArrayList<EthTransactionOperationInfo>? = null
)