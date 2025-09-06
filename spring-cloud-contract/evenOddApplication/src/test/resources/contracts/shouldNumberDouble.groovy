import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "double number"
    request{
        method GET()
        url("/double") {
            queryParameters {
                parameter("number", "1")
            }
        }
    }
    response {
        body("7")
        status 200
    }
} 