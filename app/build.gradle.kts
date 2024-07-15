plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.hfad.notesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hfad.notesapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.dagger:hilt-android:2.49")
    ksp("com.google.dagger:hilt-android-compiler:2.49")

    implementation("androidx.fragment:fragment-ktx:1.8.0")
    implementation("me.relex:circleindicator:2.1.6")


    val room_version = "2.6.1"
    implementation ("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
//    annotationProcessor ("androidx.room:room-compiler:$room_version")
//    implementation("android.room: room-ktx: $room_version")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}