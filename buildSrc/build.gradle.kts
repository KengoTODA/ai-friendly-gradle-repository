plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral {
        name = "[buildSrc] Maven Central"
    }
    maven(url = "https://repo1.maven.org/maven2/") {
        name = "[buildSrc] fallback for the Maven Central"
    }
}

dependencies {
    implementation(
        libs.plugins.kotlin.jvm.map {
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${it.version}"
        }
    )
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
