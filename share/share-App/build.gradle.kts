plugins {
    alias(libs.plugins.example.kmp.lib)
}

kotlin {
    androidLibrary {
        namespace = "org.example.project.share.app"
    }

    sourceSets {
        commonMain.dependencies {}

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
