plugins {
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

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
