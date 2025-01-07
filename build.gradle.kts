import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.github.nickklock.sheetsdsl"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    implementation("com.google.api-client:google-api-client:2.7.1")
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.37.0")
    implementation("com.google.apis:google-api-services-sheets:v4-rev614-1.18.0-rc")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {

    kotlinOptions.jvmTarget = "1.8"
}
