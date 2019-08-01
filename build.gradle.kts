import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.10"
	id("org.springframework.boot") version "2.1.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("plugin.allopen") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	id("idea")
}

group = "com.note"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val queryDslVersion = "4.1.3"

allOpen {
	annotation ("javax.persistence.Entity")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation ("joda-time:joda-time:2.10.2")
	implementation ("com.querydsl:querydsl-jpa:$queryDslVersion")

	// graphql
	//---------------------------------------------------------------------------------------------------
	implementation("com.graphql-java-kickstart:graphql-java-tools:5.6.0")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:5.10.0")
	implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:5.10.0")
	implementation("com.graphql-java-kickstart:voyager-spring-boot-starter:5.10.0")
	implementation("com.zhokhov.graphql:graphql-datetime-spring-boot-starter:1.5.1")
	//---------------------------------------------------------------------------------------------------

	kapt ("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

idea {
	module {
		val kaptMain = file("build/generated/source/kapt/main")
		sourceDirs = sourceDirs + kaptMain
		generatedSourceDirs = generatedSourceDirs + kaptMain
	}
}