import org.example.project.libs
import org.example.project.setConfigComposeMultiplatform
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeMultiplatformConventionPlugin : BaseConventionPlugin({
    val kotlinMultiplatformExtension: KotlinMultiplatformExtension? = extensions.findByType<KotlinMultiplatformExtension>()

    requireNotNull(kotlinMultiplatformExtension) { "require kotlinMultiplatformExtension" }

    with(plugins) {
        apply(libs.plugins.composeMultiplatform.get().pluginId)
        apply(libs.plugins.composeCompiler.get().pluginId)
    }

    setConfigComposeMultiplatform(kotlinMultiplatformExtension)
})
