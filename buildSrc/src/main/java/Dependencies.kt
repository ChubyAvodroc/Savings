object Versions {
    const val android_gradle_plugin = "3.0.1"
    const val kotlin = "1.2.21"

    const val minSdk = 17
    const val targetSdk = 26
    const val compileSdk = 26
    const val versionCode = 1
    const val versionName = "1.0"

    const val support_library = "26.1.0"
    const val constraint_layout = "1.0.2"
    const val arch_lifecycle = "1.1.0"
    const val arch_persistence = "1.0.0"
    const val arch_paging = "1.0.0-alpha6"

    const val junit = "4.12"
    const val test_runner = "1.0.1"
    const val espresso = "3.0.1"
}

object Deps {
    //    Plugins
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    //    Kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"

    //    Android
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_library}"
    val support_constraint_layout =
        "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"
    val support_design_v7 = "com.android.support:design:${Versions.support_library}"
    val architecture_lifecycle = "android.arch.lifecycle:extensions:${Versions.arch_lifecycle}"
    val architecture_lifecycle_compiler =
        "android.arch.lifecycle:compiler:${Versions.arch_lifecycle}"
    val architecture_persistence =
        "android.arch.persistence.room:runtime:${Versions.arch_persistence}"
    val architecture_persistence_compiler =
        "android.arch.persistence.room:compiler:${Versions.arch_persistence}"
    val architecture_paging = "android.arch.paging:runtime:${Versions.arch_paging}"

}

object Testing {
    //    JUnit
    val junit = "junit:junit:${Versions.junit}"

    //    Runner
    val runner = "com.android.support.test:runner:${Versions.test_runner}"

    //    Espresso
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"

    //    Architecture Components
    val architecture_live_data = "android.arch.core:core-testing:${Versions.arch_lifecycle}"
    val architecture_room = "android.arch.persistence.room:testing:${Versions.arch_persistence}"
}