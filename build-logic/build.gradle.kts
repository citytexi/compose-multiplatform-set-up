plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // This allows the use of the 'libs' type-safe accessor in the Kotlin source of the plugins
    compileOnly(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))

    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.composeMultiplatform.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "org.example.project.androidApplication"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("iosApplication") {
            id = "org.example.project.iosApplication"
            implementationClass = "IOSApplicationConventionPlugin"
        }

        register("kmpLib") {
            id = "org.example.project.kmpLib"
            implementationClass = "KmpLibConventionPlugin"
        }

        register("composeMultiplatform") {
            id = "org.example.project.composeMultiplatform"
            implementationClass = "ComposeMultiplatformConventionPlugin"
        }
    }
}
