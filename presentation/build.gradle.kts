plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = AppConfiguration.compileSdk

    defaultConfig {
        configurations.all {
            resolutionStrategy { force("androidx.core:core-ktx:1.6.0") }
        }
        applicationId = AppConfiguration.appId
        minSdk = AppConfiguration.minSdk
        targetSdk = AppConfiguration.targetSdk
        versionCode = AppConfiguration.versionCode
        versionName = AppConfiguration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false

            versionNameSuffix = "-test"
            applicationIdSuffix = ".test"
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
        isCoreLibraryDesugaringEnabled = true
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

fun getVersionCode(fallbackValue: Int): Int {
    return if (project.hasProperty("vCode"))
        project.property("vCode").toString().toInt()
    else
        fallbackValue
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.hilt)
    implementation(Dependencies.constraintLayout)
    //implementation(Dependencies.permissionsDispatcher)
    implementation(Dependencies.materialDialogs)
    implementation(Dependencies.materialDialogsLifecycle)
    implementation(Dependencies.materialDialogsDateTime)
    implementation(Dependencies.glide)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation(project(":base-presentation"))
    /*implementation(project(":service"))
    implementation(project(":base-service"))*/

    kapt(Dependencies.hiltCompiler)
   // kapt(Dependencies.permissionsDispatcherProcessor)
    kapt(Dependencies.glideCompiler)

    testImplementation(Dependencies.junit4)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espressoCore)
}