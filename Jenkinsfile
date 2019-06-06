pipeline {
    agent any
    stages{
        stage('Get Code from Repo'){
            steps{
                git url: 'https://github.com/javierbl30/TPI135-RutasBuses.git'
            }
        }
        stage('Run Tests'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn install'
            }
        }
    }
}
