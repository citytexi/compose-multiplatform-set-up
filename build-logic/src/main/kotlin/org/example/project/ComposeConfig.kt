package org.example.project

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.setConfigComposeMultiplatform(extension: KotlinMultiplatformExtension) {
    extension.sourceSets
        .named("commonMain")
        .configure {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.ui.backhandler)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.compose.components.resources)
                implementation(libs.compose.components.ui.tooling.preview)
                implementation(libs.compose.material3)
            }
        }

    extension.sourceSets
        .named("commonTest")
        .configure {
            dependencies {
                implementation(libs.compose.ui.test)
            }
        }
}
