plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Hibernate Core (JPA + ORM)
    // https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core
implementation("org.hibernate.orm:hibernate-core:7.0.0.Final")

    // Jakarta Persistence API (JPA)
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

    // PostgreSQL Driver
    implementation("org.postgresql:postgresql:42.7.5")

       implementation("org.jboss.logging:jboss-logging:3.5.0.Final")
implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
    // Logging (SLF4J simple)
    implementation("org.slf4j:slf4j-api:2.0.12")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.12")

     implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    runtimeOnly("org.glassfish.jaxb:jaxb-runtime:4.0.2")
   implementation("com.fasterxml:classmate:1.5.1")
// https://mvnrepository.com/artifact/org.hibernate/hibernate-annotations
implementation("org.hibernate:hibernate-annotations:3.5.6-Final")
// https://mvnrepository.com/artifact/net.bytebuddy/byte-buddy
implementation("net.bytebuddy:byte-buddy:1.17.5")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainModule.set("prueba")  // Tu nombre de módulo aquí
    mainClass.set("prueba.App")  // Clase con el main()
}

tasks.withType<JavaExec> {
    jvmArgs("--add-reads", "org.jboss.logging=java.logging")
}