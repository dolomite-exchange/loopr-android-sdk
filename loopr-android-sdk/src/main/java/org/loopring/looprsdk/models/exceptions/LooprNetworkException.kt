package org.loopring.looprsdk.models.exceptions

class LooprNetworkException(
        override var message: String,
        var errorCode: Int
) : Exception(message)