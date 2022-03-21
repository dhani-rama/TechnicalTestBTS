package id.research.btstest

class LoginResponse (
    var statusCode: String = "",
    var message: String = "",
    var errorMessage: String = "",
    var data: ArrayList<LoginEntity>
)