plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

allure {
    report {
        version.set("2.21.0")
    }
    adapter {
        frameworks {
            junit5 {
                adapterVersion.set("2.21.0")
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("com.codeborne:selenide:6.13.1")
    testImplementation("io.qameta.allure:allure-selenide:2.21.0")
}

tasks.test {
    useJUnitPlatform()
}