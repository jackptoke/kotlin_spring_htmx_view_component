package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

enum class TransferStatus(val value: String) {
    NEW("NEW"),
    COMPLETED("COMPLETED"),
    ARTICLE_EXPORTED("ARTICLE_EXPORTED"),
    JOB_EXPORTED("JOB_EXPORTED"),
    ARTICLE_ERROR("ARTICLE_ERROR"),
    JOB_ERROR("JOB_ERROR")
}