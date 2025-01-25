plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.casualchess"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Lombok
	val lombokVersion = "1.18.36"
	compileOnly("org.projectlombok:lombok:${lombokVersion}")
	annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
	testCompileOnly("org.projectlombok:lombok:${lombokVersion}")
	testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")

	// PostgreSQL
	implementation("org.postgresql:postgresql:42.7.5")

	// JWT
	implementation("io.jsonwebtoken:jjwt:0.12.6")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
