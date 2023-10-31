pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        kotlin("multiplatform") version extra["kotlin.version"].toString()
        id("org.jetbrains.compose") version extra["compose.version"].toString()
    }
}

rootProject.name = "compose-html-material3-example"
