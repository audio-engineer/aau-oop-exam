plugins {
    java
    application
    checkstyle
    pmd
}

group = "dk.aau.oop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        vendor = JvmVendorSpec.AMAZON
        languageVersion = JavaLanguageVersion.of(23)
    }
}

application {
    mainClass = "dk.aau.oop.exam.Application"
}

checkstyle {
    toolVersion = "10.21.1"
}

pmd {
    toolVersion = "7.9.0"
    ruleSetFiles = files("config/pmd/custom-ruleset.xml")
}
