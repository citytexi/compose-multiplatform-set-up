import org.gradle.kotlin.dsl.kotlin

plugins {
    alias(libs.plugins.example.kmp.lib)
    alias(libs.plugins.example.compose.multiplatform)
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
