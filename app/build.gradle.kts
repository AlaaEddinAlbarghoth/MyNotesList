plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.alaaeddinalbarghoth.mytodolist"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    kapt {
        correctErrorTypes = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val composeVersion = "1.0.5"

    // Kotlin
    implementation("androidx.core:core-ktx:1.7.0")

    // Android
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")

    // Compose)
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-rc01")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    // LifeCycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Room
    implementation("androidx.room:room-runtime:2.4.0")
    kapt("androidx.room:room-compiler:2.4.0")

    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.4.0")

    // Local unit tests)
    testImplementation("androidx.test:core:1.4.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
    testImplementation("io.mockk:mockk:1.10.5")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.1.0-rc01")

    // Instrumentation tests)
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.37")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.40.5")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
    androidTestImplementation("io.mockk:mockk-android:1.10.5")
    androidTestImplementation("androidx.test:runner:1.4.0")
}
