[![Build Status](https://travis-ci.org/HofmeisterAn/kotlin-eclipse-microprofile.svg?branch=master)](https://travis-ci.org/HofmeisterAn/kotlin-eclipse-microprofile)

# Eclipse MicroProfile with Kotlin

An example implementation of the Eclipse MicroProfile 2.1 with JTA, Arquillian and Payara Micro in Kotlin. Vue.js is used as front end framework.

## Getting Started

To start the application, execute the Gradle tasks `npmInstall npmRunBuild prod`. Java 9 or newer is not supported by Payara Micro and the ShrinkWrap Resolver for Gradle. As soon as possible I will update the project to a newer Java version.

### Prerequisites

This project requires Java 8 and [Node.js](https://github.com/nodejs/node). Run the the Gradle task `npmInstall` and `npmRunBuild` to install all dependencies and build the front end before running the application (`./gradlew npmInstall npmRunBuild prod`). By default, the application is accessible at `http://localhost:8080/app/index.html`.

To debug the application start the backend with `./gradlew debug` and the front end with `./gradlew npmRunDebug`. The Java debugging port is `5005`, the front end runs at `http://localhost:8081/app/index.html` and reload changes live.

## Authors

* **Andre Hofmeister** - *Initial work* - [HofmeisterAn](https://github.com/HofmeisterAn/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
