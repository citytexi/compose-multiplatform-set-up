import org.gradle.kotlin.dsl.kotlin

plugins {
    alias(libs.plugins.example.kmpLib)
    alias(libs.plugins.example.composeMultiplatform)
}

kotlin {
    android {
        namespace = "org.example.project.share.ui"
    }

    sourceSets {
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
