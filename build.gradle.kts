plugins {
    java
    `maven-publish`
}

group = "dev.tonimatas"
version = System.getenv("PROJECT_VERSION") ?: "dev"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.6.1") {
        exclude(module = "opus-java")
    }
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = group.toString()
            artifactId = "CJDA"
            version = project.version.toString()

            artifact(sourcesJar.get()) {
                classifier = "sources"
                extension = "jar"
            }
            artifact(javadocJar.get()) {
                classifier = "javadoc"
                extension = "jar"
            }

            pom {
                name.set("CJDA")
                description.set("Command Java Discord Api")
                url.set("https://github.com/TonimatasDEV/CJDA")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/TonimatasDEV/CJDA/blob/master/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("tonimatasdev")
                        name.set("TonimatasDEV")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/TonimatasDEV/CJDA.git")
                    url.set("https://github.com/TonimatasDEV/CJDA")
                }
            }
        }
    }

    repositories {
        maven {
            name = "TonimatasDEV"
            url = uri("https://maven.tonimatas.dev/releases")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_TOKEN")
            }
        }
    }
}
