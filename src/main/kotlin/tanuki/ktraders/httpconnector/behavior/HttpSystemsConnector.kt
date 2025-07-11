package tanuki.ktraders.httpconnector.behavior

interface HttpSystemsConnector {
    fun listSystems()
    fun getSystem()
    fun listWaypointsInSystem()
    fun getWaypoint()
    fun getConstructionSite()
    fun supplyConstructionSite()
    fun getMarket()
    fun getJumpGate()
    fun getShipyard()
}