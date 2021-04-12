plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}
repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(project(":shared"))

    implementation("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.3.0")


    //COmpose
    implementation ("androidx.compose.ui:ui:1.0.0-beta04")
    implementation ("androidx.compose.material:material:1.0.0-beta04")
    implementation( "androidx.compose.foundation:foundation:1.0.0-beta04")

//    implementation( "androidx.compose.compiler:compiler:1.0.0-beta04")
    implementation( "androidx.activity:activity-compose:1.3.0-alpha06")
    implementation( "androidx.navigation:navigation-compose:1.0.0-alpha09")

    implementation ("androidx.compose.ui:ui-tooling:1.0.0-beta04")
    implementation ("androidx.compose.runtime:runtime:1.0.0-beta04")
    implementation ("androidx.compose.compiler:compiler:1.0.0-beta04")

//Icon
// Material design icons
    implementation ("androidx.compose.material:material-icons-core:1.0.0-beta04")
    implementation ("androidx.compose.material:material-icons-extended:1.0.0-beta04")


    // Needed for viewmodel to do constructor injection
    implementation("androidx.hilt:hilt-navigation:1.0.0-beta01")
    kapt("com.google.dagger:hilt-compiler:2.34-beta")
    implementation("com.google.dagger:hilt-android:2.34-beta")


//logging interceptor
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

//glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")

}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.elixer.paws.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta04"
    }
}