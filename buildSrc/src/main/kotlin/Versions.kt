object Versions {
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 21
    const val buildToolsVersion = "30.0.1"

    const val kotlin = "1.3.72"
}

object GradlePlugins {
    private const val androidBuildToolsVersion = "4.1.0-rc01"

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
    const val navigationComponentSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Libs.jetpack.navigationComponentVersion}"
}

object Libs {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    val ui = UI
    val androidX = AndroidX
    val jetpack = Jetpack
    val test = Test


    object UI {
        private const val materialComponentsVersion = "1.1.0"
        private const val adapterDelegateVersion = "4.3.0"

        const val materialComponents = "com.google.android.material:material:$materialComponentsVersion"
        const val adapterDelegateKotlinDsl = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$adapterDelegateVersion"
        const val adapterDelegateKotlinDslLayoutContainer = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:$adapterDelegateVersion"
    }

    object AndroidX {
        private const val constraintLayoutVersion = "1.1.3"
        private const val appCompatVersion = "1.1.0"
        private const val coreKtxVersion = "1.3.1"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    }

    object Jetpack {
        const val navigationComponentVersion = "2.3.0"

        const val navigationComponentFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationComponentVersion"
        const val navigationComponentUiKtx = "androidx.navigation:navigation-ui-ktx:$navigationComponentVersion"
    }

    object Test {
        private const val junitVersion = "4.13"
        private const val junitExtVersion = "1.1.1"
        private const val espressoVersion = "3.2.0"

        const val junit = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

}