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
		stage(clean){
			steps{
			
				withMaven(maven: 'Maven'){
				sh 'mvn install'
				}
			}
		}
		
	}
}