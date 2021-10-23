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
        stage('Sonarqube Analysis'){
            def scannerHome = tool 'scanner';
            withSonarQubeEnv('sonar'){
                bat '${scannerHome}/bin/sonar-scanner -Dsonar.login=6cb3f98ba5e4a6d971ebdcc3b3f5d92e87821b50 -Dsonar.host.url=http://localhost:9000
            }
        }
    }
}