import com.android.build.api.dsl.ApplicationExtension
import org.example.project.libs
import org.example.project.setConfigAndroidApplication
import org.gradle.kotlin.dsl.findByType

class AndroidApplicationConventionPlugin : BaseConventionPlugin({
    with(plugins) {
        apply(libs.plugins.androidApplication.get().pluginId)
        apply(libs.plugins.composeCompiler.get().pluginId)
    }

    val applicationExtension: ApplicationExtension? = extensions.findByType<ApplicationExtension>()

    requireNotNull(applicationExtension) { "should be plugin: ${libs.plugins.androidApplication.get().pluginId}" }

    setConfigAndroidApplication(applicationExtension)
})
