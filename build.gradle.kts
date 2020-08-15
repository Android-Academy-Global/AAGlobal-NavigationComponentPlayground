buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(GradlePlugins.androidBuildTools)
        classpath(GradlePlugins.kotlin)
        classpath(GradlePlugins.navigationComponentSafeArgs)
    }
}