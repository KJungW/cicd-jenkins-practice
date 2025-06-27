pipeline {
    agent any

    environment {
        IMAGE_NAME = "application-image"
        CONTAINER_NAME = "application-container"
        PORT = "8081"
    }

    stages {
        // Stage : 빌드와 테스트
        stage('Build & Test') {
            steps {
                echo "Build and test start"
                bat 'gradlew.bat clean build'
                echo "Build and test complete"
            }
        }

        // Stage : Docker 이미지 빌드
        stage('Build Docker Image') {
            steps {
                echo "Build Docker Image start"
                bat "docker build -t %IMAGE_NAME% ."
                echo "Build Docker Image complete"
            }
        }

        // Stage :  배포
        stage('Deploy') {
            steps {
                withCredentials([
                    string(credentialsId: 'SECRET_VALUE1', variable: 'SECRET_VALUE1'),
                    string(credentialsId: 'SECRET_VALUE2', variable: 'SECRET_VALUE2')
                ]) {
                    echo "Try remove ${CONTAINER_NAME} Container"

                    bat """
                    docker ps -a --filter "name=%CONTAINER_NAME%" --format "{{.Names}}" | findstr /i "%CONTAINER_NAME%" >nul
                    IF %ERRORLEVEL% EQU 0 (
                        echo Stopping and removing existing container: %CONTAINER_NAME%
                        docker stop %CONTAINER_NAME%
                        docker rm %CONTAINER_NAME%
                    ) ELSE (
                        echo No existing container named %CONTAINER_NAME% found.
                    )
                    exit 0
                    """

                    bat """
                    echo Starting new container: %CONTAINER_NAME% from image: %IMAGE_NAME%
                    docker run -d ^
                        -p %PORT%:%PORT% ^
                        --name %CONTAINER_NAME% ^
                        -e SECRET_VALUE1=%SECRET_VALUE1% ^
                        -e SECRET_VALUE2=%SECRET_VALUE2% ^
                        %IMAGE_NAME%
                    """

                    echo "Docker container ${CONTAINER_NAME} started."
                }
            }
        }
    }
}
