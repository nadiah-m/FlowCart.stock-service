pipeline {
    agent any
    tools {
        maven 'Maven 3'
    }
    environment {
        // Define Docker image name and version
        DOCKER_IMAGE = 'nadiah92/flowcart.stock-service'
        DOCKER_TAG = "latest-${BUILD_NUMBER}" // or use a specific version
        registryCredential = 'dockerCredentials'
        DB_PASSWORD = credentials('my-db-password')
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests -Dspring.datasource.password=${DB_PASSWORD}'
            }
            post {
                success {
                    echo 'Build Success'
        //         echo 'Now Archiving...'
        //         archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dspring.datasource.password=${DB_PASSWORD}'
            }
        }
        // stage('Integration Test') {
        //     steps {
        //         sh 'mvn verify -DskipUnitTests'
        //     }
        // }
        stage('Code Analysis With Checkstyle') {
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
            post {
                success {
                    echo 'Generated Analysis Result'
                }
            }
        }
        stage('Run Sonarqube') {
            environment {
                scannerHome = tool 'Sonar'
            }
            steps {
                withSonarQubeEnv(credentialsId: 'Sonar', installationName: 'sq1') {
                    sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar \
                     -Dsonar.projectKey=nadiah-m_FlowCart.stock-service \
                     -Dsonar.organization=nadiah-m \
                     -Dsonar.jacoco.reportPaths=target/jacoco.exec'
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                }
            }
        }
        stage('Upload Image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push("V$BUILD_NUMBER")
                        dockerImage.push('latest')
                    }
                }
            }
        }
    }
}
