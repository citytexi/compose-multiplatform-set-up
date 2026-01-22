import org.example.project.libs
import org.example.project.setConfigAndroidTarget
import org.example.project.setConfigIosTarget
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpLibConventionPlugin : BaseConventionPlugin({
    with(plugins) {
        apply(libs.plugins.kotlinMultiplatform.get().pluginId)
        apply(libs.plugins.kotlinMultiplatformAndroid.get().pluginId)
    }

    val kotlinMultiplatformExtension: KotlinMultiplatformExtension? = extensions.findByType<KotlinMultiplatformExtension>()

    requireNotNull(kotlinMultiplatformExtension) { "require kotlinMultiplatformExtension" }

    setConfigAndroidTarget(kotlinMultiplatformExtension)
    setConfigIosTarget(kotlinMultiplatformExtension)
})
