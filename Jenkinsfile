pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='kishtityagi/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'kishtityagi', passwordVariable: 'Kishti@2909', usernameVariable: 'user')]) {
                    
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push kishtityagi/selenium-docker:latest"
			    }                           
            }
        }
    }
}
