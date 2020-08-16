// Application modules
include(":app")

// Feature modules
include(":company")
include(":vacancy")

project(":company").projectDir = File(settingsDir, "features/company")
project(":vacancy").projectDir = File(settingsDir, "features/vacancy")

rootProject.name = "JetpackNavigationComponentPlayground"