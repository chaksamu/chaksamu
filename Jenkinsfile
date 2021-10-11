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

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean deploy sonar:sonar -Dsonar.projectKey=maven.testng.selenium.jenkins -Dsonar.host.url=http://localhost:9000 -Dsonar.login=ede7ebb005b5b67523dddb260795553a23f9b9e7"
            }

          //  post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
            //    success {
              //      junit '**/target/surefire-reports/TEST-*.xml'
                //    archiveArtifacts 'target/*.jar'
                //}
           // }
        }
  	}
  }
