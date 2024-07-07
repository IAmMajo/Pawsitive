import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.jetbrainsCompose)
  alias(libs.plugins.compose.compiler)
}

kotlin {
  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    moduleName = "composeApp"
    browser {
      commonWebpackConfig {
        outputFileName = "composeApp.js"
        devServer =
            (devServer ?: KotlinWebpackConfig.DevServer()).apply {
              static =
                  (static ?: mutableListOf()).apply {
                    // Serve sources to debug inside browser
                    add(project.projectDir.path)
                  }
            }
      }
    }
    binaries.executable()
  }

  androidTarget {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
  }

  sourceSets {
    androidMain.dependencies {
      implementation(compose.preview)
      implementation(libs.androidx.activity.compose)
      implementation(libs.aws.auth.cognito)
      implementation(libs.aws.api)
      implementation(libs.aws.storage.s3)
      implementation(libs.core.kotlin)
      implementation(libs.ktor.client.okhttp)
    }
    commonMain.dependencies {
      implementation(compose.runtime)
      implementation(compose.foundation)
      implementation(compose.material3)
      implementation(compose.ui)
      implementation(compose.components.resources)
      implementation(compose.components.uiToolingPreview)
      implementation(libs.lifecycle.viewmodel.compose)
      implementation(libs.navigation.compose)
      implementation(libs.kotlinx.datetime)
      implementation(libs.coil)
      implementation(libs.coil.network.ktor)
      implementation(libs.coil.compose)
    }
    wasmJsMain.dependencies {
      implementation(libs.ktor.client.js)
    }
  }
}

android {
  namespace = "dev.maxoverlack.pawsitive"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  sourceSets["main"].java.srcDirs("src/androidMain/java")
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  sourceSets["main"].res.srcDirs("src/androidMain/res")
  sourceSets["main"].resources.srcDirs("src/commonMain/resources")

  defaultConfig {
    applicationId = "dev.maxoverlack.pawsitive"
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    versionCode = 1
    versionName = "1.0"
  }
  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
  buildTypes { getByName("release") { isMinifyEnabled = false } }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  buildFeatures { compose = true }
  dependencies { debugImplementation(compose.uiTooling) }
}
