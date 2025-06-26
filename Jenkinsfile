pipeline {
    agent any

    environment {
        JAR = "build/libs/my-app-0.0.1-SNAPSHOT.jar"
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Run') {
            steps {
                sh 'nohup java -jar $JAR > app.log 2>&1 &'
            }
        }
    }
}
