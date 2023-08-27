package io.github.droidkaigi.confsched2023.designsystem.strings

sealed class AppStrings : Strings<AppStrings>(Bindings) {
    data object Retry : AppStrings()
    data object License : AppStrings()

    private object Bindings : StringsBindings<AppStrings>(
        Lang.Japanese to { item, _ ->
            when (item) {
                Retry -> "リトライ"
                License -> "OSSライセンス"
            }
        },
        Lang.English to { item, bindings ->
            when (item) {
                Retry -> "Retry"
                License -> "Open Source License"
            }
        },
        default = Lang.Japanese,
    )
}
