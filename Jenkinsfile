pipeline {
	agent any
	
	stages{
		stage('clean'){
			steps{
			
				withMaven(maven: 'Maven'){
				sh 'mvn clean'
				}
			}
		}
		stage('install'){
			steps{
			
				withMaven(maven: 'Maven'){
				sh 'mvn install'
				}
			}
		}
		
	}
}

pipeline{
    agent any
    stages {
        stage('Build Maven') {
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '6649780f-9b73-40f1-a507-955a829bfbf4', url: 'https://github.com/GauthamRajasekar/docker-demo.git']]])             
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                  sh 'docker build -t gjaseka/docker-demo:latest .'
                }
            }
        }
        stage('Deploy Docker Image') {
            steps {
                script {
                withCredentials([string(credentialsId: 'gjaseka', variable: 'dockerhub_pwd')]) {
 			   		sh 'docker login -u gjaseka -p ${dockerhub_pwd}'
				}
                 sh 'docker push gjaseka/docker-demo:latest'
                }
            }
        }
    
    stage('Deploy App on k8s') {
      steps {
            sshagent(['k8s']) {
            sh "scp -o StrictHostKeyChecking=no docker-k8s-demo.yaml ec2-user@ec2-18-118-1-238.us-east-2.compute.amazonaws.com:/home/ec2-user"
            script {
                try{
                    sh "ssh ec2-user@ec2-18-118-1-238.us-east-2.compute.amazonaws.com kubectl apply -f ."
                }catch(error){
                    sh "ssh ec2-user@ec2-18-118-1-238.us-east-2.compute.amazonaws.com kubectl create -f ."
            }
}
        }
      
    }
    }
    }
}