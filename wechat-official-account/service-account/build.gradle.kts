import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    `maven-publish`
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-webflux")
    api("io.projectreactor.kotlin:reactor-kotlin-extensions")

    implementation("dom4j:dom4j:1.6.1")
    implementation("com.alibaba:fastjson:1.2.62")
    implementation("commons-codec:commons-codec:1.13")
    implementation("commons-io:commons-io:2.6")
    implementation("commons-lang:commons-lang:2.6")

    compileOnly("javax.servlet:javax.servlet-api:3.1.0")

}

tasks {
    register<Jar>("sourcesJar") {
        group = "build"
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
    named<Jar>("jar") {
        enabled = true
    }
    named<BootJar>("bootJar") {
        enabled = false
    }
}

publishing {
    repositories {
        maven {
            val githubUrl = project.findProperty("GITHUB_URI") as String? ?: System.getenv("GITHUB_URL")

            name = "githubPackages"
            url = uri("$githubUrl/${rootProject.name}")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    afterEvaluate {
        publications {
            register<MavenPublication>("gpr") {
                from(components["java"])
                artifact(tasks["sourcesJar"])
                pom {
                    description.set("GPR publishing")
                }
            }
        }
    }
}