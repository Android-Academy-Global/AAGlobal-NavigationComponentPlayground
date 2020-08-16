// Application modules
include(":app")

// Core modules
include(":common-navigation")

project(":common-navigation").projectDir = File(settingsDir, "core/common-navigation")

// Feature modules
include(":company")
include(":vacancy")

project(":company").projectDir = File(settingsDir, "features/company")
project(":vacancy").projectDir = File(settingsDir, "features/vacancy")

rootProject.name = "JetpackNavigationComponentPlayground"