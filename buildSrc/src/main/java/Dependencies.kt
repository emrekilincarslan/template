object Dependencies {

    // Kotlin
    const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

    // Application compatibility
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"

    // Activity Kotlin extensions
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    // Design
    const val androidxMaterial = "com.google.android.material:material:${Versions.androidxMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Material dialogs
    const val materialDialogs = "com.afollestad.material-dialogs:core:${Versions.materialDialogs}"
    const val materialDialogsLifecycle =
        "com.afollestad.material-dialogs:lifecycle:${Versions.materialDialogs}"
    const val materialDialogsDateTime =
        "com.afollestad.material-dialogs:datetime:${Versions.materialDialogs}"

    // Hilt / DI
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Permissions
    const val permissionsDispatcher =
        "org.permissionsdispatcher:permissionsdispatcher:${Versions.permissionDispatcher}"
    const val permissionsDispatcherProcessor =
        "org.permissionsdispatcher:permissionsdispatcher-processor:${Versions.permissionDispatcher}"

    // Navigation
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navComponents}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navComponents}"

    // Logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Networking
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.squareOkHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.squareOkHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Image loading
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Test
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"

    // UI Test
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}