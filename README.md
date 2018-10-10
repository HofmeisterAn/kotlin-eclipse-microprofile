# Eclipse MicroProfile with Kotlin

An example implementation of the Eclipse MicroProfile 1.3 with JTA, Arquillian and Payara Micro in Kotlin. Vue.js is used as front end framework. Later I will add an automatic build pipeline.

## Getting Started

To start the application execute the Gradle task `start`. Java 9 or newer is not supported by Payara Micro and the ShrinkWrap Resolver for Gradle.

### Prerequisites

This project requires Java and [Node.js](https://github.com/nodejs/node). Run the the Gradle task `npmInstall` and `npmRunBuild` to install all dependencies and build the front end before running the application (`./gradlew npmInstall npmRunBuild debug`). By default the application is accessible at `http://localhost:8080/app/index.html`.

## Authors

* **Andre Hofmeister** - *Initial work* - [padme-amidala](https://github.com/padme-amidala/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
