import com.google.gson.annotations.SerializedName


data class Quote (

	@SerializedName("quote_id") val quote_id : Int,
	@SerializedName("quote") val quote : String,
	@SerializedName("author") val author : String,
	@SerializedName("series") val series : String
)