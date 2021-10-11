pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3.6.0"
      }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/chaksamu/chaksamu.git'
			}
		}
		stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven:'maven-3.6.0') {
                        bat 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
  	}
}