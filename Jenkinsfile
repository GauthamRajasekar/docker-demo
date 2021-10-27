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