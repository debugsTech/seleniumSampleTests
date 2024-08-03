plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //testNG
    implementation("org.testng:testng:7.10.2")
    // Selenium WebDriver
    implementation ("org.seleniumhq.selenium:selenium-java:4.23.0")
}

tasks.test {
        useTestNG() {
            suites ("src/test/resources/testng.xml")
        }
}