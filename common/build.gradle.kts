@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiPlatform)
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

kotlin {
    // Targets
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
    }
    jvm("desktop") {
        jvmToolchain(11)
    }


    iosX64()
    iosArm64()
    iosSimulatorArm64()
    cocoapods {
        summary = "Common"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        homepage="https://github.com/DAKSHSEMWAL"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "Common"
            isStatic = true
        }
    }

    // Platform-specific dependencies
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material)
                implementation(compose.material3)
            }
        }

        val androidMain by getting {
            dependencies {
                // Android specific dependencies
            }
        }

        val desktopMain by getting {
            dependencies {
                // Desktop specific dependencies
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                // iOS specific dependencies
            }
        }

    }
}

android {
    namespace = "io.github.dakshsemwal.nudge"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}