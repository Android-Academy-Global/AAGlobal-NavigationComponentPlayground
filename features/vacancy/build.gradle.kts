plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

repositories {
    jcenter()
    google()
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    // Kotlin
    compileOnly(Libs.kotlin)

    // AndroidX
    compileOnly(Libs.androidX.coreKtx)
    compileOnly(Libs.androidX.appCompat)

    // UI libraries
    compileOnly(Libs.ui.materialComponents)
    compileOnly(Libs.androidX.constraintLayout)

    // Navigation
    compileOnly(Libs.jetpack.navigationComponentFragmentKtx)
    compileOnly(Libs.jetpack.navigationComponentUiKtx)
    compileOnly(Libs.ui.adapterDelegateKotlinDsl)
    compileOnly(Libs.ui.adapterDelegateKotlinDslLayoutContainer)
}