plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("kotlin-android")
}

android {
    compileSdk = AppConfiguration.compileSdk

    defaultConfig {
        minSdk = AppConfiguration.minSdk
        targetSdk = AppConfiguration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildToolsVersion = AppConfiguration.buildTools
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(Dependencies.kotlinCore)
    api(Dependencies.kotlinStandardLibrary)
    api(Dependencies.androidxAppCompat)
    api(Dependencies.androidxMaterial)
    api(Dependencies.constraintLayout)
    api(Dependencies.activityKtx)
    api(Dependencies.fragmentKtx)
    api(Dependencies.hilt)
    api(Dependencies.navigationUiKtx)
    api(Dependencies.navigationFragmentKtx)
    api(Dependencies.timber)
    api(Dependencies.materialDialogs)
    api(Dependencies.materialDialogsLifecycle)
    api(Dependencies.materialDialogsDateTime)
    api(Dependencies.glide)

    kapt(Dependencies.hiltCompiler)

    testImplementation(Dependencies.junit4)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espressoCore)
}