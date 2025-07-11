package tanuki.ktraders.httpconnector.behavior

import tanuki.ktraders.main.structure.Contract

interface HttpContractsConnector {
    fun listContracts(): Set<Contract>
    fun getContract(contractId: String)
    fun acceptContract(contractId: String)
    fun fulfillContract(contractId: String)
    fun deliverCargoToContract(shipSymbol: String, quantity: PhysicalQuantity)
}