package org.example.project

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import kotlin.text.toInt

internal fun Project.setConfigAndroidApplication(extension: ApplicationExtension) {
    extension.compileSdk = libs.versions.android.compileSdk.get().toInt()

    extension.defaultConfig {
        applicationId = libs.versions.applicationId.get()
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.android.versionCode.get().toInt()
        versionName = libs.versions.android.versionName.get()
    }

    extension.buildFeatures {
        compose = true
    }

    extension.packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    extension.buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    extension.compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        implementation(project(":share:share-App"))
        implementation(project(":share:share-UI"))

        implementation(libs.androidx.activity.compose)
        implementation(libs.androidx.splash)
    }
}

internal fun Project.setConfigAndroidTarget(extension: KotlinMultiplatformExtension) {
    val androidLibraryTarget: KotlinMultiplatformAndroidLibraryTarget? = extension?.extensions
        ?.findByType<KotlinMultiplatformAndroidLibraryTarget>()

    requireNotNull(androidLibraryTarget) { "require androidLibraryTarget" }

    with(androidLibraryTarget) {
        compileSdk = libs.versions.android.compileSdk.get().toInt()
    }
}
