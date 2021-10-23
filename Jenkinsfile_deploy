pipeline {
    agent any

    tools {
        // Install the Maven version configured as 'M3' and add it to the path.
        maven 'maven-3.6.0'
        jdk 'jdk-11.0.12'
      }
    stages {
        stage ('Checkout') {
            steps {
                git 'https://github.com/chaksamu/chaksamu.git'
            }
        }
        stage ('Build Clean') {
            steps  {
                bat 'mvn clean -f pom.xml'
            }
        }
        stage ('Build Test') {
            steps  {
                bat 'mvn test -f pom.xml'
            }
        }
        stage ('Build Package') {
            steps  {
                bat 'mvn package -f pom.xml'
            }
        }
        stage ('Build Verify') {
            steps  {
                bat 'mvn verify -f pom.xml'
            }
        }
        stage ('Build Install') {
            steps  {
                bat 'mvn install -f pom.xml'
            }
        }
        stage ('Build deploy') {
            steps  {
                bat 'mvn deploy -f pom.xml -s settings.xml'
            }
        }
    }
}