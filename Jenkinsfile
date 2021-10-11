pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3.6.0"
      }
    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/chaksamu/chaksamu.git'
            }
        }
        stage('Build') {
            steps {
                bat "mvn clean verify -f pom.xml"
            }                          //maven.testng.selenium.jenkins
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar') {
                       bat "mvn sonar:sonar -f pom.xml"
                  }
            }
        }
      }
}