import org.example.project.libs
import org.example.project.setConfigIosApplication
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class IOSApplicationConventionPlugin : BaseConventionPlugin({
    with(plugins) {
        apply(libs.plugins.kotlinMultiplatform.get().pluginId)
        apply(libs.plugins.composeCompiler.get().pluginId)
    }

    val kotlinMultiplatformExtension: KotlinMultiplatformExtension? = extensions.findByType<KotlinMultiplatformExtension>()

    requireNotNull(kotlinMultiplatformExtension) { "require kotlinMultiplatformExtension" }

    setConfigIosApplication(kotlinMultiplatformExtension)
})
