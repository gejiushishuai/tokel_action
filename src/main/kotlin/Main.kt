import okhttp3.OkHttpClient
import okhttp3.Request

fun main(args: Array<String>) {

    var last="ON"

    val build = OkHttpClient.Builder().build()
    while (true) {
        Thread.sleep(1000)
        val result = build.newCall(Request.Builder().url("http://127.0.0.1:9999").build()).execute().body().string()

        if (result!=last) {
            println(result)
            last = result
            val cmd=when(result) {
                "ON" -> "xset dpms force on"
                "OFF" -> "xset dpms force off"
                else -> ""
            }
            Runtime.getRuntime().exec(cmd)
        }
    }
}


