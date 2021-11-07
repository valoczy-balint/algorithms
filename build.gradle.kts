plugins {
//    id 'org.jetbrains.kotlin.jvm' version '1.5.31'
    val kotlinVersion = "1.5.31"

    kotlin("jvm") version kotlinVersion
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
