package response

data  class FailedResponse(
    val status: String = "fail",
    val data: Any? = null,
    val message: String,
    val reason: String
)