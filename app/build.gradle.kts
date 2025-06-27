plugins {
    id("java")
    checkstyle
    jacoco
    id("org.sonarqube") version "6.2.0.5505"
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
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

checkstyle {
    configFile = file("config/checkstyle/checkstyle.xml")
}

sonar {
    properties {
        property("sonar.projectKey", "Lakever_java-project-78")
        property("sonar.organization", "lakever")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
    }
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