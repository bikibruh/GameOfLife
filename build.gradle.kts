import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
}

group = "com.carbonit"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.12")
    testImplementation("io.cucumber:cucumber-java8:4.3.1")
    testImplementation("io.cucumber:cucumber-junit:4.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.4.2")
    testImplementation("nl.jqno.equalsverifier:equalsverifier:3.1.9")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.4.2")
}


tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
