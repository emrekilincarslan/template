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
        targetSdk =  AppConfiguration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildToolsVersion = AppConfiguration.buildTools
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(Dependencies.kotlinCore)
    api(Dependencies.kotlinStandardLibrary)
    api(Dependencies.kotlinCoroutines)

    api(Dependencies.androidxAppCompat)

    api(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    api(Dependencies.timber)

    api(Dependencies.okHttp)
    api(Dependencies.okHttpLoggingInterceptor)
    api(Dependencies.retrofit)
    api(Dependencies.retrofitGsonConverter)

    testApi (Dependencies.junit4)
    androidTestApi (Dependencies.junitExt)
    androidTestApi (Dependencies.espressoCore)
}