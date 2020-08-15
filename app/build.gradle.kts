plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
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

        applicationId = "com.aaglobal.jnc_playground"
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

dependencies {
    // Kotlin
    implementation(Libs.kotlin)

    // AndroidX
    implementation(Libs.androidX.coreKtx)
    implementation(Libs.androidX.appCompat)

    // UI libraries
    implementation(Libs.ui.materialComponents)
    implementation(Libs.androidX.constraintLayout)

    // Navigation
    implementation(Libs.jetpack.navigationComponentFragmentKtx)
    implementation(Libs.jetpack.navigationComponentUiKtx)

    testImplementation(Libs.test.junit)
    androidTestImplementation(Libs.test.junitExt)
    androidTestImplementation(Libs.test.espresso)
}