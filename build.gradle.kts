plugins {
    java
    `maven-publish`
}

val projectVersion : String by project

group = "dev.tonimatas"
version = projectVersion

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.6.1") {
        exclude(module = "opus-java")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = group.toString()
            artifactId = "CJDA"
            version = project.version.toString()
        }
    }

    repositories {
        maven {
            name = "TonimatasDEV"
            url = uri("https://maven.tonimatas.dev/releases")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}
