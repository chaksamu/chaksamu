pipeline {
    agent any

    tools {
        // Install the Maven version configured as 'M3' and add it to the path.
        maven 'maven-3.6.0'
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
                bat 'mvn clean verify -f pom.xml'
            }                          //maven.testng.selenium.jenkins
        }
        stage('Jacoco'){
            steps {
                jacoco()
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar') {
                       bat 'mvn sonar:sonar -f pom.xml'
                  }
            }
        }
        stage('Wait for quality gate'){
	    steps {
    		    timeout(time: 1, unit: 'HOURS'){
    		        script{
    		            bat 'sleep 30'
        		        def qg = waitForQualityGate()
        		        if (qg.status != 'OK'){
        		            error "Pipeline aborted due to quality gate failure: ${qg.status}"
        		        }
    		        }
    		    }
	        }
        post{
            success{
                script{
                    nexusPublisher nexusInstanceId: 'maven.testng.selenium.jenkins', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: './target']], mavenCoordinate: [artifactId: 'maven.testng.selenium.jenkins', groupId: 'com.syniverse', packaging: 'jar', version: '0.0.4']]]
                    }
                }
            }
        }
    }
}