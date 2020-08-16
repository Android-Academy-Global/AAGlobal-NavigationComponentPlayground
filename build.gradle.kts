buildscript {
    val kotlin_version by extra("1.3.72")
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(GradlePlugins.androidBuildTools)
        classpath(GradlePlugins.kotlin)
        classpath(GradlePlugins.navigationComponentSafeArgs)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}