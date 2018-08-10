package org.loopring.looprsdk.models.ethplorer.eth


/**
 * Ethplorer API
 *
 * Gets data on the activity of the top ERC20 tokens
 */
class EthTopTokenActivity(

        /**
         * A list of [EthTokenInfo] objects each with data on a token
         */
        var tokens: List<EthTokenInfo>? = null
)
