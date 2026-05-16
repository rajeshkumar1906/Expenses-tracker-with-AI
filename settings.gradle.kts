rootProject.name = "ExpensesTrackerWithAi"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":core:common")
include(":core:database")
include(":core:network")
include(":core:model")
include(":core:di")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":core:camera")
include(":core:ocr")
include(":core:ai")
include(":feature:home")
include(":feature:scanner")
include(":feature:entry")
include(":feature:analytics")
