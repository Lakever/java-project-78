plugins {
    id("java")
    checkstyle
}

group = "hexlet.code"
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



//plugins {
//    java
//    application
//    checkstyle
//    jacoco
//    id("org.sonarqube") version "6.0.1.5171"
//}
//
//group = "hexlet.code"
//version = "1.0-SNAPSHOT"
//
//tasks.test {
//    useJUnitPlatform()
//}
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
//    implementation("info.picocli:picocli:4.6.3")
//    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
//    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.16.1")
//
//}
//
//application {
//    mainClass.set("hexlet.code.App")
//}