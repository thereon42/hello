pipeline {
  environment {
    imageName = 'thereon42/hello'
    containerName = 'hello'
    credentialId = 'docker-hub'
  }
  agent {
    label 'hello'
  }
  stages {
    stage('Build Jar') {
      steps {
        tool 'jdk-11'
        sh './gradlew clean build -Dorg.gradle.java.home=/home/ubuntu/jenkins/tools/hudson.model.JDK/jdk-11'
      }
    }

    stage('Build & Push Docker Image') {
      steps {
        script {
          docker.withRegistry('', credentialId) {
            docker.build(imageName).push('latest')
          }
        }
      }
    }

    stage('Docker Run') {
      steps {
        sh """
          docker stop ${containerName} && docker rm ${containerName}
          docker run -d --name ${containerName} -p 8080:8080 ${imageName}
        """
      }
    }
  }
}