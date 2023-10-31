plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("maven-publish")
}

group = "compose.html.material3"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                scssSupport {
                    enabled.set(true)
                }
            }
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.6.4")
                implementation("compose.html.material3:compose-html-material3-js:1.0-SNAPSHOT")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
