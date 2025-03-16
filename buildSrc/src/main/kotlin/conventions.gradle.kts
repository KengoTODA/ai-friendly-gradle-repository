/**
 * Convention plugin that provides common project configurations.
 *
 * This plugin provides the following configurations:
 * - Basic setup for Kotlin JVM projects
 * - Test fixtures support (java-test-fixtures)
 * - Java 21 toolchain configuration
 * - Reproducible build settings (no timestamp preservation, consistent file order)
 *
 * By applying this plugin, projects can maintain consistent configurations
 * and ensure build reproducibility across the codebase.
 */

import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("java-test-fixtures")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}
