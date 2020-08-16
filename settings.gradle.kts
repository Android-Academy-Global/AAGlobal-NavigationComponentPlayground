// Application modules
include(":app")

// Feature modules
include(":company")

project(":company").projectDir = File(settingsDir, "features/company")

rootProject.name = "JetpackNavigationComponentPlayground"