// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply (false)
    alias(libs.plugins.android.library) apply (false)
    alias(libs.plugins.kotlin) apply (false)
    alias(libs.plugins.ktlint) apply (false)
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        mavenCentral()
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
    register("copyGitHooks", Copy::class) {
        from("/config/git/hooks/") {
            include("**/*")
            rename("(.*)", "$1")
        }
        into("/.git/hooks")
    }
    named("clean") {
        dependsOn(":copyGitHooks")
    }
}
