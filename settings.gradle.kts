pluginManagement {
    repositories {
        // Download dependencies from the Central first,
        // or sometimes plugins repo redirects to the unstable JCenter
        mavenCentral() {
            name = "Maven Central"
        }
        gradlePluginPortal()
        maven(url = "https://repo1.maven.org/maven2/") {
            name = "fallback for the Maven Central repository"
        }
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral {
            name = "Maven Central"
            content {
                excludeGroup("com.example")
            }
        }
    }
}

plugins {
    id("com.gradle.develocity") version "3.19.2"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "2.0.2"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

include(
    ":app",
)
