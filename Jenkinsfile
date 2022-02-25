pipeline {
    agent any

    tools {
        // Install the Maven version configured as 'M3' and add it to the path.
        maven 'maven-3.6.0'
        jdk 'jdk-11.0.12'
      }
    stages {
        stage ('Checkout') {
            steps{ 
                git 'https://github.com/chaksamu/chaksamu.git' 
                }
        }
        stage('Test'){
            steps{
                bat "echo 'Hello'"
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean verify install -f pom.xml'
            }                          //maven.testng.selenium.jenkins
        }
        
    }
}
