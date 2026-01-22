package org.example.project

import org.gradle.api.Project
import org.gradle.kotlin.dsl.getting
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.setConfigIosApplication(extension: KotlinMultiplatformExtension) {
    with(extension) {
        listOf(
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "ComposeApp"
                isStatic = true
            }
        }
    }

    extension.sourceSets.named("commonMain").configure {
        dependencies {
            implementation(project(":share:share-App"))
            implementation(project(":share:share-UI"))
        }
    }
}

internal fun Project.setConfigIosTarget(extension: KotlinMultiplatformExtension) {
    with(extension) {
        listOf(
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = project.name
                isStatic = true
            }
        }
    }
}
