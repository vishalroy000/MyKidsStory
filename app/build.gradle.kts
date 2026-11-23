plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mywish.mykidsstory"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mywish.mykidsstory"
        minSdk = 24
        targetSdk = 33
        versionCode = 2
        versionName = "1.0.1"

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
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.github.NitishGadangi:TypeWriter-TextView:v1.3")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("com.google.android.play:core:1.10.3")
    implementation ("com.google.android.gms:play-services-ads:22.6.0")

    implementation ("com.flaviofaria:kenburnsview:1.0.7")
    implementation ("com.github.santalu:aspect-ratio-imageview:1.0.9")

    implementation ("com.github.Q42:AndroidScrollingImageView:1.3.4")

    implementation ("com.airbnb.android:lottie:6.2.0")
    implementation("com.github.AtifSayings:Animatoo:1.0.1")
    implementation ("com.github.siyamed:android-shape-imageview:0.9.3")




}