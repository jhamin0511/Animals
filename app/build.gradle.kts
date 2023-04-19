plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "com.github.jhamin0511.animals"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.github.jhamin0511.animals"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
        }
        register("benchmark") {

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
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.junit)
}
