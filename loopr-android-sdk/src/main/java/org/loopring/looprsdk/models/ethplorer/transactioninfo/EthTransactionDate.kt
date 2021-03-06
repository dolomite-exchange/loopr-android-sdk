package org.loopring.looprsdk.models.ethplorer.transactioninfo



/**
 * Ethplorer API
 *
 * The year month and day of a transaction
 */
class EthTransactionDate(

        /**
         * Year the transaction occurred in. IE 2018
         */
        var year: Int? = null,

        /**
         * Month the transaction occurred in, form 1-12
         */
        var month: Int? = null,

        /**
         * Day the transaction occurred in, starting from 0 to 30.
         */
        var day: Int? = null
)