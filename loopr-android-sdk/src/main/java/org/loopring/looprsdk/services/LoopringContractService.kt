package org.loopring.looprsdk.services

import java.math.BigInteger
import java.util.ArrayList
import java.util.Arrays
import org.web3j.abi.EventEncoder
import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.DynamicArray
import org.web3j.abi.datatypes.Event
import org.web3j.abi.datatypes.Function
import org.web3j.abi.datatypes.Type
import org.web3j.abi.datatypes.generated.Bytes32
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.abi.datatypes.generated.Uint64
import org.web3j.abi.datatypes.generated.Uint8
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.RemoteCall
import org.web3j.protocol.core.methods.request.EthFilter
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.Contract
import org.web3j.tx.TransactionManager
import rx.Observable

/**
 *
 * Auto generated code.
 *
 * **Do not modify!**
 *
 * Please use the [web3j command line tools](https://docs.web3j.io/command_line.html),
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * [codegen module](https://github.com/web3j/web3j/tree/master/codegen) to update.
 *
 *
 * Generated with web3j version 3.2.0.
 */
class LoopringContractService : Contract {

    protected constructor(
            contractAddress: String,
            web3j: Web3j,
            credentials: Credentials,
            gasPrice: BigInteger,
            gasLimit: BigInteger
    ) : super("", contractAddress, web3j, credentials, gasPrice, gasLimit)

    protected constructor(
            contractAddress: String,
            web3j: Web3j,
            transactionManager: TransactionManager,
            gasPrice: BigInteger,
            gasLimit: BigInteger
    ) : super("", contractAddress, web3j, transactionManager, gasPrice, gasLimit)

    fun getRingMinedEvents(transactionReceipt: TransactionReceipt): List<RingMinedEventResponse> {
        val event = Event("RingMined",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Type<Bytes32>>() {

                }),
                Arrays.asList(object : TypeReference<Uint256>() {

                }, object : TypeReference<Address>() {

                }, object : TypeReference<Address>() {

                }, object : TypeReference<DynamicArray<Bytes32>>() {

                }))
        val valueList = extractEventParameters(event, transactionReceipt)
        val responses = ArrayList<RingMinedEventResponse>(valueList.size)
        for (eventValues in valueList) {
            val typedResponse = RingMinedEventResponse()
            typedResponse._ringHash = eventValues.indexedValues[0].value as ByteArray
            typedResponse._ringIndex = eventValues.nonIndexedValues[0].value as BigInteger
            typedResponse._miner = eventValues.nonIndexedValues[1].value as String
            typedResponse._feeRecipient = eventValues.nonIndexedValues[2].value as String
            typedResponse._orderInfoList = eventValues.nonIndexedValues[3].value as List<ByteArray>
            responses.add(typedResponse)
        }
        return responses
    }

    fun ringMinedEventObservable(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter): Observable<RingMinedEventResponse> {
        val event = Event("RingMined",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Bytes32>() {

                }),
                Arrays.asList(object : TypeReference<Uint256>() {

                }, object : TypeReference<Address>() {

                }, object : TypeReference<Address>() {

                }, object : TypeReference<DynamicArray<Bytes32>>() {

                }))
        val filter = EthFilter(startBlock, endBlock, getContractAddress())
        filter.addSingleTopic(EventEncoder.encode(event))
        return web3j.ethLogObservable(filter).map { log ->
            val eventValues = extractEventParameters(event, log)
            val typedResponse = RingMinedEventResponse()
            typedResponse._ringHash = eventValues.indexedValues[0].value as ByteArray
            typedResponse._ringIndex = eventValues.nonIndexedValues[0].value as BigInteger
            typedResponse._miner = eventValues.nonIndexedValues[1].value as String
            typedResponse._feeRecipient = eventValues.nonIndexedValues[2].value as String
            typedResponse._orderInfoList = eventValues.nonIndexedValues[3].value as List<ByteArray>
            typedResponse
        }
    }

    fun getOrderCancelledEvents(transactionReceipt: TransactionReceipt): List<OrderCancelledEventResponse> {
        val event = Event("OrderCancelled",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Bytes32>() {

                }),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        val valueList = extractEventParameters(event, transactionReceipt)
        val responses = ArrayList<OrderCancelledEventResponse>(valueList.size)
        for (eventValues in valueList) {
            val typedResponse = OrderCancelledEventResponse()
            typedResponse._orderHash = eventValues.indexedValues[0].value as ByteArray
            typedResponse._amountCancelled = eventValues.nonIndexedValues[0].value as BigInteger
            responses.add(typedResponse)
        }
        return responses
    }

    fun orderCancelledEventObservable(
            startBlock: DefaultBlockParameter,
            endBlock: DefaultBlockParameter
    ): Observable<OrderCancelledEventResponse> {
        val event = Event("OrderCancelled",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Bytes32>() {

                }),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        val filter = EthFilter(startBlock, endBlock, getContractAddress())
        filter.addSingleTopic(EventEncoder.encode(event))
        return web3j.ethLogObservable(filter).map { log ->
            val eventValues = extractEventParameters(event, log)
            val typedResponse = OrderCancelledEventResponse()
            typedResponse._orderHash = eventValues.indexedValues[0].value as ByteArray
            typedResponse._amountCancelled = eventValues.nonIndexedValues[0].value as BigInteger
            typedResponse
        }
    }

    fun getAllOrdersCancelledEvents(transactionReceipt: TransactionReceipt): List<AllOrdersCancelledEventResponse> {
        val event = Event("AllOrdersCancelled",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        val valueList = extractEventParameters(event, transactionReceipt)
        val responses = ArrayList<AllOrdersCancelledEventResponse>(valueList.size)
        for (eventValues in valueList) {
            val typedResponse = AllOrdersCancelledEventResponse()
            typedResponse._address = eventValues.indexedValues[0].value as String
            typedResponse._cutoff = eventValues.nonIndexedValues[0].value as BigInteger
            responses.add(typedResponse)
        }
        return responses
    }

    fun allOrdersCancelledEventObservable(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter): Observable<AllOrdersCancelledEventResponse> {
        val event = Event("AllOrdersCancelled",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        val filter = EthFilter(startBlock, endBlock, getContractAddress())
        filter.addSingleTopic(EventEncoder.encode(event))
        return web3j.ethLogObservable(filter).map { log ->
            val eventValues = extractEventParameters(event, log)
            val typedResponse = AllOrdersCancelledEventResponse()
            typedResponse._address = eventValues.indexedValues[0].value as String
            typedResponse._cutoff = eventValues.nonIndexedValues[0].value as BigInteger
            typedResponse
        }
    }

    fun getOrdersCancelledEvents(transactionReceipt: TransactionReceipt): List<OrdersCancelledEventResponse> {
        val event = Event("OrdersCancelled",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }),
                Arrays.asList(object : TypeReference<Address>() {

                }, object : TypeReference<Address>() {

                }, object : TypeReference<Uint256>() {

                }))
        val valueList = extractEventParameters(event, transactionReceipt)
        val responses = ArrayList<OrdersCancelledEventResponse>(valueList.size)
        for (eventValues in valueList) {
            val typedResponse = OrdersCancelledEventResponse()
            typedResponse._address = eventValues.indexedValues[0].value as String
            typedResponse._token1 = eventValues.nonIndexedValues[0].value as String
            typedResponse._token2 = eventValues.nonIndexedValues[1].value as String
            typedResponse._cutoff = eventValues.nonIndexedValues[2].value as BigInteger
            responses.add(typedResponse)
        }
        return responses
    }

    fun ordersCancelledEventObservable(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter): Observable<OrdersCancelledEventResponse> {
        val event = Event("OrdersCancelled",
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }),
                Arrays.asList(object : TypeReference<Address>() {

                }, object : TypeReference<Address>() {

                }, object : TypeReference<Uint256>() {

                }))
        val filter = EthFilter(startBlock, endBlock, getContractAddress())
        filter.addSingleTopic(EventEncoder.encode(event))
        return web3j.ethLogObservable(filter).map { log ->
            val eventValues = extractEventParameters(event, log)
            val typedResponse = OrdersCancelledEventResponse()
            typedResponse._address = eventValues.indexedValues[0].value as String
            typedResponse._token1 = eventValues.nonIndexedValues[0].value as String
            typedResponse._token2 = eventValues.nonIndexedValues[1].value as String
            typedResponse._cutoff = eventValues.nonIndexedValues[2].value as BigInteger
            typedResponse
        }
    }

    fun MARGIN_SPLIT_PERCENTAGE_BASE(): RemoteCall<BigInteger> {
        val function = Function("MARGIN_SPLIT_PERCENTAGE_BASE",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint8>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    fun ringIndex(): RemoteCall<BigInteger> {
        val function = Function("ringIndex",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint64>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    fun RATE_RATIO_SCALE(): RemoteCall<BigInteger> {
        val function = Function("RATE_RATIO_SCALE",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    fun lrcTokenAddress(): RemoteCall<String> {
        val function = Function("lrcTokenAddress",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }))
        return executeRemoteCallSingleValueReturn(function, String::class.java)
    }

    fun tokenRegistryAddress(): RemoteCall<String> {
        val function = Function("tokenRegistryAddress",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }))
        return executeRemoteCallSingleValueReturn(function, String::class.java)
    }

    fun delegateAddress(): RemoteCall<String> {
        val function = Function("delegateAddress",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Address>() {

                }))
        return executeRemoteCallSingleValueReturn(function, String::class.java)
    }

    fun getTradingPairCutoffs(
            orderOwner: String,
            token1: String,
            token2: String
    ): RemoteCall<BigInteger> {
        val function = Function("getTradingPairCutoffs",
                Arrays.asList<Type<*>>(org.web3j.abi.datatypes.Address(orderOwner),
                        org.web3j.abi.datatypes.Address(token1),
                        org.web3j.abi.datatypes.Address(token2)),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    fun cancelAllOrdersByTradingPair(
            token1: String,
            token2: String,
            cutoff: BigInteger
    ): RemoteCall<TransactionReceipt> {
        val function = Function(
                "cancelAllOrdersByTradingPair",
                Arrays.asList(org.web3j.abi.datatypes.Address(token1),
                        org.web3j.abi.datatypes.Address(token2),
                        org.web3j.abi.datatypes.generated.Uint256(cutoff)),
                emptyList())
        return executeRemoteCallTransaction(function)
    }

    fun cancelOrder(
            addresses: List<String>,
            orderValues: List<BigInteger>,
            buyNoMoreThanAmountB: Boolean?,
            marginSplitPercentage: BigInteger,
            v: BigInteger,
            r: ByteArray,
            s: ByteArray
    ): RemoteCall<TransactionReceipt> {
        val function = Function(
                "cancelOrder",
                Arrays.asList(org.web3j.abi.datatypes.generated.StaticArray5(
                        org.web3j.abi.Utils.typeMap(addresses, org.web3j.abi.datatypes.Address::class.java)),
                        org.web3j.abi.datatypes.generated.StaticArray6(
                                org.web3j.abi.Utils.typeMap(orderValues, org.web3j.abi.datatypes.generated.Uint256::class.java)),
                        org.web3j.abi.datatypes.Bool(buyNoMoreThanAmountB!!),
                        org.web3j.abi.datatypes.generated.Uint8(marginSplitPercentage),
                        org.web3j.abi.datatypes.generated.Uint8(v),
                        org.web3j.abi.datatypes.generated.Bytes32(r),
                        org.web3j.abi.datatypes.generated.Bytes32(s)),
                emptyList())
        return executeRemoteCallTransaction(function)
    }

    fun MAX_RING_SIZE(): RemoteCall<BigInteger> {
        val function = Function("MAX_RING_SIZE",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    fun cancelAllOrders(cutoff: BigInteger): RemoteCall<TransactionReceipt> {
        val function = Function(
                "cancelAllOrders",
                Arrays.asList<Type<*>>(org.web3j.abi.datatypes.generated.Uint256(cutoff)),
                emptyList())
        return executeRemoteCallTransaction(function)
    }

    fun rateRatioCVSThreshold(): RemoteCall<BigInteger> {
        val function = Function("rateRatioCVSThreshold",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint256>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    fun submitRing(
            addressList: List<String>,
            uintArgsList: List<BigInteger>,
            uint8ArgsList: List<BigInteger>,
            buyNoMoreThanAmountBList: List<Boolean>,
            vList: List<BigInteger>,
            rList: List<ByteArray>,
            sList: List<ByteArray>,
            feeRecipient: String,
            feeSelections: BigInteger
    ): RemoteCall<TransactionReceipt> {
        val function = Function(
                "submitRing",
                Arrays.asList(org.web3j.abi.datatypes.generated.StaticArray4(
                        org.web3j.abi.Utils.typeMap(addressList, org.web3j.abi.datatypes.Address::class.java)),
                        org.web3j.abi.datatypes.generated.StaticArray6(
                                org.web3j.abi.Utils.typeMap(uintArgsList, org.web3j.abi.datatypes.generated.Uint256::class.java)),
                        org.web3j.abi.datatypes.generated.StaticArray1(
                                org.web3j.abi.Utils.typeMap(uint8ArgsList, org.web3j.abi.datatypes.generated.Uint8::class.java)),
                        org.web3j.abi.datatypes.DynamicArray(
                                org.web3j.abi.Utils.typeMap(buyNoMoreThanAmountBList, org.web3j.abi.datatypes.Bool::class.java)),
                        org.web3j.abi.datatypes.DynamicArray(
                                org.web3j.abi.Utils.typeMap(vList, org.web3j.abi.datatypes.generated.Uint8::class.java)),
                        org.web3j.abi.datatypes.DynamicArray(
                                org.web3j.abi.Utils.typeMap(rList, org.web3j.abi.datatypes.generated.Bytes32::class.java)),
                        org.web3j.abi.datatypes.DynamicArray(
                                org.web3j.abi.Utils.typeMap(sList, org.web3j.abi.datatypes.generated.Bytes32::class.java)),
                        org.web3j.abi.datatypes.Address(feeRecipient),
                        org.web3j.abi.datatypes.generated.Uint16(feeSelections)),
                emptyList())
        return executeRemoteCallTransaction(function)
    }

    fun walletSplitPercentage(): RemoteCall<BigInteger> {
        val function = Function("walletSplitPercentage",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Uint8>() {

                }))
        return executeRemoteCallSingleValueReturn(function, BigInteger::class.java)
    }

    class RingMinedEventResponse {
        var _ringHash: ByteArray? = null

        var _ringIndex: BigInteger? = null

        var _miner: String? = null

        var _feeRecipient: String? = null

        var _orderInfoList: List<ByteArray>? = null
    }

    class OrderCancelledEventResponse {
        var _orderHash: ByteArray? = null

        var _amountCancelled: BigInteger? = null
    }

    class AllOrdersCancelledEventResponse {
        var _address: String? = null

        var _cutoff: BigInteger? = null
    }

    class OrdersCancelledEventResponse {
        var _address: String? = null

        var _token1: String? = null

        var _token2: String? = null

        var _cutoff: BigInteger? = null
    }

    companion object {

        fun getService(
                contractAddress: String,
                web3j: Web3j,
                credentials: Credentials,
                gasPrice: BigInteger,
                gasLimit: BigInteger
        ): LoopringContractService {
            return LoopringContractService(contractAddress, web3j, credentials, gasPrice, gasLimit)
        }

        fun getService(
                contractAddress: String,
                web3j: Web3j,
                transactionManager: TransactionManager,
                gasPrice: BigInteger,
                gasLimit: BigInteger
        ): LoopringContractService {
            return LoopringContractService(contractAddress, web3j, transactionManager, gasPrice, gasLimit)
        }
    }


}
