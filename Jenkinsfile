pipeline {
    agent any

    tools {
    maven 'Maven'
    jdk 'JDK' // Add this line
}

    stages {
        stage('Checkout') {
            steps {
                // Fixed: Added the closing quote after .git
                git branch: 'main', url: 'https://github.com/akashsuresh2005/MyMavenSeleniumChrome.git'
            }
        }

        stage('Build & Compile') {
            steps {
                // This ensures the code is valid and downloads dependencies
                sh 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                // For Selenium, 'mvn test' is the standard way to execute
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // This is important! It tells Jenkins where to find your 
            // Selenium test results so it can display them in the UI.
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Automation tests passed!'
        }
        failure {
            echo 'Pipeline failed. Check the Console Output or Test Reports.'
        }
    }
}
