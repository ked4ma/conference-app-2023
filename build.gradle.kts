import org.gradle.api.tasks.Delete

plugins {
    alias(libs.plugins.androidGradlePlugin) apply false
    alias(libs.plugins.androidGradleLibraryPlugin) apply false
    alias(libs.plugins.kotlinGradlePlugin) apply false
    alias(libs.plugins.kotlinxKover) apply false
    id("dev.iurysouza.modulegraph") version "0.4.0"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

buildscript {
    configurations.all {
        resolutionStrategy.eachDependency {
            when {
                requested.name == "javapoet" -> useVersion("1.13.0")
            }
        }
    }
}

moduleGraphConfig {
    readmePath.set("./README.md")
    heading.set("### Dependency Diagram")
//    showFullPath.set(false) // optional
    orientation.set(dev.iurysouza.modulegraph.Orientation.LEFT_TO_RIGHT) //optional
    linkText.set(dev.iurysouza.modulegraph.LinkText.NONE) // optional
    theme.set(dev.iurysouza.modulegraph.Theme.NEUTRAL) // optional
    // or you can fully customize it by using the BASE theme:
    // theme.set(Theme.BASE(
    //      mapOf(
    //          "primaryTextColor" to "#fff",
    //          "primaryColor" to "#5a4f7c",
    //          "primaryBorderColor" to "#5a4f7c",
    //          "lineColor" to "#f5a623",
    //          "tertiaryColor" to "#40375c",
    //          "fontSize" to "11px"
    //      )
    //   )
    // )
}
