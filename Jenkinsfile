pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage("Build") {
            steps {
                sh 'mvn clean package'
            }
        }

        stage("SonarQube") {
            steps {
                script {
                    withSonarQubeEnv('SonarTP3') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }

        stage("Deploy & OWASP Dependency-Check") {
            steps {
                dependencyCheck additionalArguments: '''
                    -o './'
                    -s './'
                    -f 'ALL'
                    --prettyPrint''', 
                    odcInstallation: 'owasp'

                dependencyCheckPublisher pattern: 'dependency-check-report.xml'
            }
        }

        stage('Clean Up') {
            steps {
                deleteDir()
            }
        }
    }
}
